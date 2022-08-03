package com.gezhiwei.mysql.cursor.test;

import com.gezhiwei.mysql.cursor.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MyserviceTest {

    @Autowired
    private MyService myService;

    @Test
    public void connectTest() throws SQLException, InterruptedException {
        myService.connect();
    }
}
