package com.stone;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
public class DeliveryAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeliveryAppApplication.class, args);
        log.info("启动成功");
    }
}
