package com.ymu.service.fileclient.config;

import com.abs.infrastructure.spring.mvc.api.CustomRequestMappingHandlerMapping;
import com.abs.infrastructure.spring.mvc.sensitive.SensitiveFormatAnnotationFormatterFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ymu.service.fileclient.vo.VBase;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.hateoas.RelProvider;
import org.springframework.hateoas.hal.CurieProvider;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.MediaTypes.HAL_JSON;

/**
 * 采用继承WebMvcConfigurationSupport方式。
 * 这种方式会屏蔽springboot的@EnableAutoConfiguration中的设置
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    private ListableBeanFactory beanFactory;

    private static CurieProvider getCurieProvider(BeanFactory factory) {

        try {
            return factory.getBean(CurieProvider.class);
        } catch (NoSuchBeanDefinitionException e) {
            return null;
        }
    }

    private static final String DELEGATING_REL_PROVIDER_BEAN_NAME = "_relProvider";
//    private static final String LINK_DISCOVERER_REGISTRY_BEAN_NAME = "_linkDiscovererRegistry";
//    private static final String HAL_OBJECT_MAPPER_BEAN_NAME = "_halObjectMapper";

    /**
     * 消息转换。集成超媒体连接。
     * @param clazz 请求、返回指定的继承类型。
     * @return
     */
    private JsonViewHttpMessageConverter jsonViewHttpMessageConverter(Class clazz) {
        //Need to override some behaviour in the HAL Serializer...so let's make our own
        CurieProvider curieProvider = getCurieProvider(beanFactory);
        RelProvider relProvider = beanFactory.getBean(DELEGATING_REL_PROVIDER_BEAN_NAME, RelProvider.class);
//        ObjectMapper halObjectMapper = beanFactory.getBean(HAL_OBJECT_MAPPER_BEAN_NAME, ObjectMapper.class);
        ObjectMapper halObjectMapper = new CustomObjectMapper();

        halObjectMapper.registerModule(new Jackson2HalModule());
        halObjectMapper.setHandlerInstantiator(new Jackson2HalModule.HalHandlerInstantiator(relProvider, curieProvider,null));

        JsonViewHttpMessageConverter halConverter = new JsonViewHttpMessageConverter(clazz);
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.APPLICATION_JSON_UTF8);
        list.add(HAL_JSON);
        halConverter.setSupportedMediaTypes(list);
        halConverter.setObjectMapper(halObjectMapper);

        return halConverter;
    }

    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new CustomRequestMappingHandlerMapping();
        handlerMapping.setOrder(0);
        handlerMapping.setInterceptors(getInterceptors());
        return handlerMapping;
    }

    /**
     * 配置消息转换规则。
     * @param converters
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //------json与对象转换器
        JsonViewHttpMessageConverter jsonViewHttpMessageConverter = jsonViewHttpMessageConverter(VBase.class);
        converters.add(jsonViewHttpMessageConverter);

        //-----字符串返回转换器
        /*StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        //解决返回乱码的问题。
        stringHttpMessageConverter.setSupportedMediaTypes(MediaType.parseMediaTypes("text/html;charset=UTF-8"));
        converters.add(stringHttpMessageConverter);*/

        //添加其它默认消息转换器
//        super.addDefaultHttpMessageConverters(converters);
    }


    /**
     * 全局验证器
     * @return
     */
    @Override
    protected Validator getValidator() {
//        return new GlobalValidator(); //设置自己的全局表单校验器后，hibernate-valid的将失效
        return super.getValidator();
    }

    /**
     * 过滤敏感词。
     * @param registry
     */
    @Override
    protected void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldAnnotation (new SensitiveFormatAnnotationFormatterFactory());
        super.addFormatters(registry);
    }

    /**
     * 定义拦截器。
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }

}
