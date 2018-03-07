package com.ymu.service.fileclient.config;

import com.abs.infrastructure.spring.CorsRegistrationConfig;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.io.IOException;

@Configuration
public class MainConfig {

    @Value("${fdfs.tracker_servers}")
    private String trackerServers;
    @Value("${fdfs.connect_timeout}")
    private int connectTimeout;
    @Value("${fdfs.network_timeout}")
    private int networkTimeout;
    @Value("${fdfs.charset}")
    private String charset;
    @Value("${fdfs.http.tracker_http_port}")
    private int trackerHttpPort;
    @Value("${fdfs.http.anti_steal_token}")
    private boolean antiStealToken;
    @Value("${fdfs.http.secret_key}")
    private String secretKey;

    @Bean
    public StorageClient1 fdfsStorageClient1() throws IOException, MyException {
        ClientGlobal.initByTrackers(trackerServers);
        ClientGlobal.setG_connect_timeout(connectTimeout);
        ClientGlobal.setG_network_timeout(networkTimeout);
        ClientGlobal.setG_charset(charset);
        ClientGlobal.setG_tracker_http_port(trackerHttpPort);
        ClientGlobal.setG_anti_steal_token(antiStealToken);
        ClientGlobal.setG_secret_key(secretKey);
        System.out.println("ClientGlobal.configInfo() : " + ClientGlobal.configInfo());

        TrackerClient tc = new TrackerClient();

        TrackerServer ts = tc.getConnection();
        if (ts == null) {
            throw new NullPointerException("FastDFS获取TrackerServer连接失败!");
        }

        StorageServer ss = tc.getStoreStorage(ts);
        if (ss == null) {
            throw new NullPointerException("FastDFS获取StorageServer连接失败!");
        }

        StorageClient1 sc1 = new StorageClient1(ts, ss);
        return  sc1;
    }

    @Bean
    public CorsFilter corsFilter(@Autowired CorsRegistrationConfig corsRegistrationConfig) {
        //1.添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        //放行哪些原始域
        config.addAllowedOrigin(corsRegistrationConfig.getAllowedOrigins());
        //是否发送Cookie信息
        config.setAllowCredentials(corsRegistrationConfig.getAllowCredentials());
        //放行哪些原始域(请求方式)
        config.addAllowedMethod(corsRegistrationConfig.getAllowedMethods());
        //放行哪些原始域(头部信息)
        config.addAllowedHeader(corsRegistrationConfig.getAllowedHeaders());
        //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
//        config.addExposedHeader("header-1,header-2");

        //2.添加映射路径
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        //3.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }
}
