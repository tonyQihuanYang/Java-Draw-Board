
package com.drawBoard.drawBoard.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

  @Bean
  LettuceConnectionFactory redisConnectionFactory() {
    // return new LettuceConnectionFactory(new RedisStandaloneConfiguration("_",
    // 6379));
    return new LettuceConnectionFactory();
  }

  // @Bean
  // public JedisConnectionFactory redisConnectionFactory() {
  // return new JedisConnectionFactory();
  // }

  @Bean
  RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(redisConnectionFactory);
    return template;
  }
}
