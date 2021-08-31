package com.gezhiwei.alt.feign.test.feign;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import feign.Headers;
import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangzhuangnai
 * @date 2021/2/3
 * @since 1.0.0
 **/
@FeignClient(name = "requestClient", url = "${request.url}", configuration = RequestClient.ConfigClientConfig.class)
public interface RequestClient {

    class ConfigClientConfig {

        @Bean
        public Encoder feignEncoder() {
            return new SpringEncoder(feignHttpMessageConverter());
        }

        @Bean
        public Decoder feignDecoder() {
            return new SpringDecoder(feignHttpMessageConverter());
        }

        private ObjectFactory<HttpMessageConverters> feignHttpMessageConverter() {
            final HttpMessageConverters httpMessageConverters = new HttpMessageConverters(createFastJsonConverter());
            return () -> httpMessageConverters;
        }

        private HttpMessageConverter createFastJsonConverter() {
            FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
            List<MediaType> supportedMediaTypes = new ArrayList<>();
            supportedMediaTypes.add(MediaType.APPLICATION_JSON);
            supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
            supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
            supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
            supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
            supportedMediaTypes.add(MediaType.APPLICATION_PDF);
            supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
            supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
            supportedMediaTypes.add(MediaType.APPLICATION_XML);
            supportedMediaTypes.add(MediaType.IMAGE_GIF);
            supportedMediaTypes.add(MediaType.IMAGE_JPEG);
            supportedMediaTypes.add(MediaType.IMAGE_PNG);
            supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
            supportedMediaTypes.add(MediaType.TEXT_HTML);
            supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
            supportedMediaTypes.add(MediaType.TEXT_PLAIN);
            supportedMediaTypes.add(MediaType.TEXT_XML);
            fastJsonConverter.setSupportedMediaTypes(supportedMediaTypes);

            FastJsonConfig fastJsonConfig = new FastJsonConfig();
            fastJsonConfig.setSerializerFeatures(
                    // 是否输出值为null的字段,默认为false
                    SerializerFeature.WriteMapNullValue,
                    // 将Collection类型字段的字段空值输出为[]
                    SerializerFeature.WriteNullListAsEmpty,
                    // 将字符串类型字段的空值输出为空字符串
                    SerializerFeature.WriteNullStringAsEmpty,
                    // 将数值类型字段的空值输出为0
                    SerializerFeature.WriteNullNumberAsZero,
                    //Boolean字段如果为null,输出为false,而非null
                    SerializerFeature.WriteNullBooleanAsFalse,
                    //SerializerFeature.WriteDateUseDateFormat,
                    //枚举字段输出为枚举值
                    SerializerFeature.WriteEnumUsingToString,
                    // 禁用循环引用
                    SerializerFeature.DisableCircularReferenceDetect
            );


            fastJsonConverter.setFastJsonConfig(fastJsonConfig);
            return fastJsonConverter;
        }

        /**
         * 打印日志
         *
         * @return 配置
         */
        @Bean
        public feign.Logger.Level multipartLoggerLevel() {
            return Logger.Level.NONE;
        }
    }

    /**
     * 库存查询
     *
     * @param inventoryCacheSelectRequest 库存查询对象
     * @return erp返回结构体
     */
    @GetMapping(value = "/product/api/CategoryManagement/BackstageCategory/searchParallelCategory")
    @Headers("application/x-www-form-urlencoded")
    JSONObject select(@RequestParam("name") String name);

}
