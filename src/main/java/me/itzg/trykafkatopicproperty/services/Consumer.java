package me.itzg.trykafkatopicproperty.services;

import lombok.extern.slf4j.Slf4j;
import me.itzg.trykafkatopicproperty.config.AppProperties;
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
   * Supplies the configured topic name to the SpEL in the {@link #consumeTime(String)}
   * listener annotation.
   * @return the configured kafka topic to consume
   */
  public String getTopic() {
    return topic;
  }

  @KafkaListener(topics = "#{__listener.topic}")
  public void consumeTime(String content) {
    log.info("Consumed: {}", content);
  }
}
