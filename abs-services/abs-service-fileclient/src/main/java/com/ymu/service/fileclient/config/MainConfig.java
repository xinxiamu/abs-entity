package com.ymu.service.fileclient.config;

import com.abs.infrastructure.spring.AppContext;
import com.abs.infrastructure.spring.SpringBeanFactory;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.io.IOException;

@Configuration
public class MainConfig {

    /**
     * 环境上下文。
     *
     * @return
     */
    @Bean
    public AppContext appContext() {
        return new AppContext();
    }

    /**
     * Bean工厂。
     *
     * @return
     */
    @Bean
    public SpringBeanFactory springBeanFactory() {
        return new SpringBeanFactory();
    }

    @Bean
    public StorageClient1 fdfsStorageClient1() throws IOException, MyException {
        String trackerServers = "40.125.171.31:22122";
        ClientGlobal.initByTrackers(trackerServers);
        ClientGlobal.setG_connect_timeout(30);
        System.out.println("ClientGlobal.configInfo() : " + ClientGlobal.configInfo());

        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient1 client = new StorageClient1(trackerServer, storageServer);
        return  client;
    }
}
