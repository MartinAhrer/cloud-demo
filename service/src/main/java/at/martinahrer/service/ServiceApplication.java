package at.martinahrer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;


@RestController
@EnableAutoConfiguration
@Slf4j
public class ServiceApplication {

    @Value("${message}")
    private String message;

    @RequestMapping("/")
    public String home() {
        return String.format("%s from %s", message, hostname());
    }

    private String hostname() {
        try {
            InetAddress iAddress = InetAddress.getLocalHost();
            return iAddress.getCanonicalHostName();
        } catch (UnknownHostException e) {
            // in some way localhost always seems to be the right thing
            log.warn("Could not get the hostname, returning 'localhost' due to " + e.getMessage());
            return "localhost";
        }
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ServiceApplication.class, args);
    }
}