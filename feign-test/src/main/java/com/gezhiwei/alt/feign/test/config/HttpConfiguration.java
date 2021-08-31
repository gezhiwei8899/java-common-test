package com.gezhiwei.alt.feign.test.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpConfiguration {

    @Value("${feign.httpclient.max-connections:1000}")
    private int maxConnections;

    @Value("${feign.httpclient.max-connections-per-route:500}")
    private int maxConnectionsPerRoute;

    @Value("${feign.httpclient.connect-timeout:0}")
    private int connectTimeout;

    @Value("${feign.httpclient.socket-timeout:0}")
    private int socketTimeout;

    @Value("${feign.httpclient.connect-request-timeout:0}")
    private int connectRequestTimeout;

    @Bean
    public HttpClient httpClient(HttpClientBuilder httpClientBuilder) {
        return HttpClientBuilder.create().build();
    }

    @Bean
    public HttpClientBuilder httpClientBuilder(HttpClientConnectionManager httpClientConnectionManager) {
        RequestConfig requestConfig = RequestConfig
                .custom()
                .setConnectTimeout(connectTimeout)
                .setSocketTimeout(socketTimeout)
                .setConnectionRequestTimeout(connectRequestTimeout)
                .build();
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        httpClientBuilder.setConnectionManager(httpClientConnectionManager);
        httpClientBuilder.setDefaultRequestConfig(requestConfig);
        httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(1000,true));
        return httpClientBuilder;
    }

    @Bean
    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(maxConnections);
        connectionManager.setDefaultMaxPerRoute(maxConnectionsPerRoute);
        return connectionManager;
    }
}
