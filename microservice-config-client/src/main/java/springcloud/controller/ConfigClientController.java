package springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${profile}")
    private String profile;

    @Value("${context}")
    private String context;

    @Value("${encrypt}")
    private String encrypt;

    @GetMapping("/profile")
    public String config() {
        return profile + "----" + context + "，解密结果-= " + encrypt;
    }

}
