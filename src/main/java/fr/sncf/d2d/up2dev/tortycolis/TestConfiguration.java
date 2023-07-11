package fr.sncf.d2d.up2dev.tortycolis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {
    @Bean
    public TestService testService(){
        return new TestService();
    }
}
