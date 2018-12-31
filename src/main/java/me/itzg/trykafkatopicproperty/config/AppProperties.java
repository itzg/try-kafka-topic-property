package me.itzg.trykafkatopicproperty.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("app")
@Component
@Data
public class AppProperties {
  String topic;
}
