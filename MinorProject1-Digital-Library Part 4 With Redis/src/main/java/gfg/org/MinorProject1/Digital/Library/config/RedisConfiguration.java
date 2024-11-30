package gfg.org.MinorProject1.Digital.Library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

//@Configuration
//public class RedisConfiguration {
//
//    @Bean
//    public LettuceConnectionFactory lettuceConnectionFactory() {
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//        redisStandaloneConfiguration.setHostName("localhost");
//        redisStandaloneConfiguration.setPort(6379);
//
//        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);
//        return connectionFactory;
//    }
//
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(){
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//
//        redisTemplate().setKeySerializer(redisTemplate().getStringSerializer());
//        redisTemplate().setValueSerializer(new JdkSerializationRedisSerializer());
//        redisTemplate().setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate().setHashValueSerializer(new JdkSerializationRedisSerializer());
//
//
//        redisTemplate().setConnectionFactory(lettuceConnectionFactory());
//        return redisTemplate;
//
//    }
//
//
//}













@Configuration
public class RedisConfiguration {


    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(); //creating object of RedisStandaloneConfiguration. It allows you to set properties such as the host, port, and password for the Redis server.
//        redisStandaloneConfiguration.setHostName("localhost");
//        redisStandaloneConfiguration.setPort(6379);

        redisStandaloneConfiguration.setHostName("redis-10781.c256.us-east-1-2.ec2.redns.redis-cloud.com");
        redisStandaloneConfiguration.setPort(10781);
        redisStandaloneConfiguration.setPassword("1Ymhpj5QsGWDkNutiVEGk6DpM6oj1CQd");

        LettuceConnectionFactory redisConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);//creating object of LettuceConnectionFactory to establish connection with redis server
        return redisConnectionFactory;
    }


    @Bean
    public RedisTemplate<String, Object> redisTemplate(){ //  (LettuceConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>(); //creating object of RedisTemplate so that we use it anywhere


        redisTemplate.setKeySerializer(new StringRedisSerializer()); //setting key serializer , here key is string that's why we use StringRedisSerializer
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer()); //setting value serializer , here value is object that's why we use JdkSerializationRedisSerializer. JdkSerializationRedisSerializer is used to convert object to byte[] and vice versa
        redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer()); //setting hash key serializer (let's suppose if we are using hashmap then we need to add this serializer)
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer()); //setting hash value serializer

        redisTemplate.setConnectionFactory(redisConnectionFactory()); //setting connection factory

        //redisTemplate.setConnectionFactory(redisConnectionFactory); //setting connection factory
        return redisTemplate;
    }


}

