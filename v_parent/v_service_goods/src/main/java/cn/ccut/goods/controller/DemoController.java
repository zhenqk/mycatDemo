package cn.ccut.goods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    // 1. 先启动 eureka server 2。启动 9001
    //  http://localhost:9001/demo/show

    @RequestMapping("/show")
    public String sayHi(){
        return "ok";
    }

}
