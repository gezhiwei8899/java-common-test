package com.gezhiwei.feign.test.muti;

import com.gezhiwei.feign.test.feign.RequestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class LaunchService implements ApplicationRunner {

    public static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5000, 5000, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10000000));

    private final CountDownLatch countDownLatch = new CountDownLatch(5000);

    @Autowired
    private RequestClient requestClient;

    public void launch() {
        int t = 10000;
        for (int i = 0; i < t; i++) {
            THREAD_POOL_EXECUTOR.submit(() -> {
                countDownLatch.countDown();
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                requestClient.select("饮料");
            });
        }
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        launch();
    }
}
