package com.gezhiwei.feign.test.feign;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import feign.Headers;
import feign.Logger;
import feign.Retryer;
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
import org.springframework.web.bind.annotation.PostMapping;
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
                    // ??????????????????null?????????,?????????false
                    SerializerFeature.WriteMapNullValue,
                    // ???Collection????????????????????????????????????[]
                    SerializerFeature.WriteNullListAsEmpty,
                    // ??????????????????????????????????????????????????????
                    SerializerFeature.WriteNullStringAsEmpty,
                    // ???????????????????????????????????????0
                    SerializerFeature.WriteNullNumberAsZero,
                    //Boolean???????????????null,?????????false,??????null
                    SerializerFeature.WriteNullBooleanAsFalse,
                    //SerializerFeature.WriteDateUseDateFormat,
                    //??????????????????????????????
                    SerializerFeature.WriteEnumUsingToString,
                    // ??????????????????
                    SerializerFeature.DisableCircularReferenceDetect
            );


            fastJsonConverter.setFastJsonConfig(fastJsonConfig);
            return fastJsonConverter;
        }

        /**
         * ????????????
         *
         * @return ??????
         */
        @Bean
        public feign.Logger.Level multipartLoggerLevel() {
            return Logger.Level.NONE;
        }
    }

    /**
     * ????????????
     *
     * @param inventoryCacheSelectRequest ??????????????????
     * @return erp???????????????
     */
    @GetMapping(value = "/product/api/CategoryManagement/BackstageCategory/searchParallelCategory")
    @Headers("application/x-www-form-urlencoded")
    JSONObject select(@RequestParam("name") String name);

}
