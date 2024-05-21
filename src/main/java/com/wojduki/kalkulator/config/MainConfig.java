package com.wojduki.kalkulator.config;

import com.wojduki.kalkulator.model.Work;
import com.wojduki.kalkulator.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
@Configuration
public class MainConfig {
    @Bean(name="inMemoryMaterialRepo")
    @Profile("dev")
    public MaterialRepo createInMemoryMaterialRepo() {
        return new InMemoryMaterialRepo();
    }
    @Bean(name="inMemoryWorkRepo")
    @Profile("dev")
    public CostRepo<Work> createInMemoryWorkRepo() { return new InMemoryWorkRepo(); }

    @Bean(name="DBMaterialRepo")
    @Profile("prod")
    public MaterialRepo createDBMaterialRepo() {
        return new DBMaterialRepo();
    }
}
