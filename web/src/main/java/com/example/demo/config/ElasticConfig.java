package com.example.demo.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by yangtthi on 18/3/11.
 */
@Configuration
public class ElasticConfig {

    private static Logger LOG  = LogManager.getLogger();

    @Bean
    public TransportClient client() throws UnknownHostException {

        InetSocketTransportAddress node = new InetSocketTransportAddress(
                InetAddress.getByName("localhost"),
                9300
        );

        Settings settings = Settings.builder()
                .put("cluster.name" , "wali")
                .build();

        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);

        return client;
    }

}
