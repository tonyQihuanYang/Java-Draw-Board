
package com.drawBoard.drawBoard.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfig {

  @Value("${spring.data.redis.host}")
  private String redisHost;

  @Value("${spring.data.redis.port}")
  private int redisPort;

  static Logger logger = LoggerFactory.getLogger(RedisConfig.class);

  @Bean
  LettuceConnectionFactory redisConnectionFactory() {
    logger.info("Trying to Connect to Redis with Host={} and port={}", redisHost, redisPort);
    return new LettuceConnectionFactory(new RedisStandaloneConfiguration(redisHost,
        redisPort));
    // return new LettuceConnectionFactory();
  }

  @Bean
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(redisConnectionFactory);
    return template;
  }
}
