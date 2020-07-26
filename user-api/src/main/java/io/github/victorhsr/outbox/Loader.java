package io.github.victorhsr.outbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author victorhsr <victor.hugo.origins@gmail.com>
 */
@EnableScheduling
@SpringBootApplication
public class Loader {

    public static void main(String[] args) {
        SpringApplication.run(Loader.class, args);
    }

}
