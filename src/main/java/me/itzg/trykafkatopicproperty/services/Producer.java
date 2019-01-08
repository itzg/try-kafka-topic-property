package me.itzg.trykafkatopicproperty.services;

import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import me.itzg.trykafkatopicproperty.config.AppProperties;
import me.itzg.trykafkatopicproperty.model.TimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Producer {

  private final KafkaTemplate kafkaTemplate;
  private final AppProperties appProperties;

  @Autowired
  public Producer(KafkaTemplate kafkaTemplate, AppProperties appProperties) {
    this.kafkaTemplate = kafkaTemplate;
    this.appProperties = appProperties;
  }

  @Scheduled(fixedRate = 1000)
  public void sendTime() {
    final TimeMessage content = new TimeMessage().setSent(new Date().toString());
    log.info("Producing to {}: {}", appProperties.getTopic(), content);
    kafkaTemplate.send(appProperties.getTopic(), content);
  }
}
