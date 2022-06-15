package com.ldx.JWTsecurity.config;


import com.ldx.JWTsecurity.utils.FastJsonRedisSerializer;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
    public class RedisConfig extends CachingConfigurerSupport {
        @Bean
        public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
            RedisTemplate<Object, Object> template = new RedisTemplate<>();
            template.setConnectionFactory(connectionFactory);
            //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
            //Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);
            //使用Fastjson2JsonRedisSerializer来序列化和反序列化redis的value值 by zhengkai
            FastJsonRedisSerializer serializer = new FastJsonRedisSerializer(Object.class);
            //使用StringRedisSerializer来序列化和反序列化redis的key值
            template.setKeySerializer(new StringRedisSerializer());
            template.setValueSerializer(serializer);
            //Hash的key也采用StringRedisSerial的序列化方式
            template.setHashKeySerializer(new StringRedisSerializer());
            template.setHashValueSerializer(serializer);
            template.afterPropertiesSet();
            return template;
        }

    }
