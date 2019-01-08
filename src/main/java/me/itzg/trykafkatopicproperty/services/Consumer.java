package me.itzg.trykafkatopicproperty.services;

import lombok.extern.slf4j.Slf4j;
import me.itzg.trykafkatopicproperty.config.AppProperties;
import me.itzg.trykafkatopicproperty.model.TimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {

  private final String topic;

  @Autowired
  public Consumer(AppProperties appProperties) {
    this.topic = appProperties.getTopic();
    log.info("Will consume from {}", this.topic);
  }

  /**
   * Supplies the configured topic name to the SpEL in the {@link #consumeTime(TimeMessage)}
   * listener annotation.
   * @return the configured kafka topic to consume
   */
  public String getTopic() {
    return topic;
  }

  @KafkaListener(topics = "#{__listener.topic}")
  public void consumeTime(TimeMessage content) {
    log.info("Consumed: {}", content);
  }
}
