This is a Spring Boot application that tries out configuring a Kafka listener with a 
Spring Expression (SpEL) as the configured Kafka topic.

The main point of this project is the 
[Consumer](src/main/java/me/itzg/trykafkatopicproperty/services/Consumer.java), where the
special `__listener` token is used in the `topics` SpEL to reference to the application configured
topic.

It's worth nothing that the use of `@Scheduled` on the `Producer`'s `sendTime` method did require
scheduling to be enabled with `@EnableScheduling`.