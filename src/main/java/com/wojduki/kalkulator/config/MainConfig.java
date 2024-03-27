package com.wojduki.kalkulator.config;

import com.wojduki.kalkulator.repository.DBMaterialRepo;
import com.wojduki.kalkulator.repository.InMemoryMaterialRepo;
import com.wojduki.kalkulator.repository.MaterialRepo;
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

    @Bean(name="DBMaterialRepo")
    @Profile("prod")
    public MaterialRepo createDBMaterialRepo() {
        return new DBMaterialRepo();
    }
}
