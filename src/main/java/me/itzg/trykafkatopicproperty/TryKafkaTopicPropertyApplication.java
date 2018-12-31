package me.itzg.trykafkatopicproperty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TryKafkaTopicPropertyApplication {

  public static void main(String[] args) {
    SpringApplication.run(TryKafkaTopicPropertyApplication.class, args);
  }

}

