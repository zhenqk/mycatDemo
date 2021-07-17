package cn.ccut.log;

import cn.ccut.util.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "cn.ccut.log.mapper")
public class LogApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class,args);
    }

    //交给spring
    @Bean
    public IdWorker idworker(){
        return new IdWorker(0,0);
    }
}