package com.ymu.service.fileclient.vo;

import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

/**
 * extends ResourceSupport后，消息转换总的进出口MappingJackson2HttpMessageConverter将无效。
 * 所以要修改默认行为。
 */
public class VBase extends ResourceSupport implements Serializable,Cloneable {

    @Override
    public String toString() {
        String vo = JSON.toJSONString(this);
        return vo;
    }
}
