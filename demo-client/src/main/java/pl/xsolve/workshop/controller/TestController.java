package pl.xsolve.workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
public class TestController {

    private static final String LOCAL_SERVER_PORT = "local.server.port";

    @Autowired
    protected DiscoveryClient discoveryClient;

    @Autowired
    protected Environment environment;

    @Value("${booty.message:Default message from application }")
    private String message;

    @RequestMapping("/hello")
    public String hello() {
        return message + environment.getProperty(LOCAL_SERVER_PORT);
    }
}
