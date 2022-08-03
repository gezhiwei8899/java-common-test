package com.gezhiwei.mysql.cursor.service;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class MyService {

    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(10,10,60, TimeUnit.MINUTES,new LinkedBlockingDeque<>(1000));
    @Autowired
    private HikariDataSource hikariDataSource;

    String sql = "select id from case_search_sync_v3";

    public void connectAsync() throws SQLException, InterruptedException {
        int n = 5;
        for (int i = 0; i < n; i++) {
            THREAD_POOL_EXECUTOR.submit(() -> {
                try {
                    Connection connection = hikariDataSource.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                    preparedStatement.setFetchSize(20);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("id"));
                    }
                } catch (Exception e) {
                    log.error("error: ", e);
                }
            });
        }
        THREAD_POOL_EXECUTOR.awaitTermination(1,TimeUnit.DAYS);
    }

    public void connect() throws SQLException {
        Connection connection = hikariDataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        preparedStatement.setFetchSize(20);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("id"));
        }
    }
}
