package com.kaziabid.learn.angular.apiserver.config;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.Locale;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

/**
 * @author Kazi Abid
 */
@Configuration
@EnableCaching
public class AngularApiServerConfig {

    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration
                .defaultCacheConfig().entryTtl(Duration.ofMinutes(1))
                .disableCachingNullValues().serializeValuesWith(SerializationPair
                        .fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return builder -> builder
                .withCacheConfiguration("itemCache", cacheConfiguration())
                .withCacheConfiguration("dbCache", cacheConfiguration());
    }

    @Bean
    public Faker faker() {
        return new Faker(
                new FakeValuesService(Locale.ENGLISH,
                        new RandomService(new SecureRandom())),
                new RandomService(new SecureRandom()));
    }

    @Bean
    public WebFluxConfigurer webFluxConfigurer() {
        return new WebFluxConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**").allowedOrigins("*").allowedMethods("*")
                        .allowedHeaders("*");
            }
        };
    }
}
