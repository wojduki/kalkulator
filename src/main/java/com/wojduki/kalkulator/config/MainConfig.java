package com.wojduki.kalkulator.config;

import com.wojduki.kalkulator.model.Material;
import com.wojduki.kalkulator.model.Work;
import com.wojduki.kalkulator.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class MainConfig {
    @Bean(name="inMemoryMaterialRepo")
    @Profile("dev")
    public CostRepo<Material> createInMemoryMaterialRepo() {
        return new InMemoryMaterialRepo();
    }
    @Bean(name="inMemoryWorkRepo")
    @Profile("dev")
    public CostRepo<Work> createInMemoryWorkRepo() { return new InMemoryWorkRepo(); }

    @Bean(name="DBMaterialRepo")
    @Profile("prod")
    public CostRepo<Material> createDBMaterialRepo() {
        return new DBMaterialRepo();
    }

    @Bean(name="DBWorkRepo")
    @Profile("prod")
    public CostRepo<Work> createWorkRepo() {
        return new DBWorkRepo();
    }

    @Autowired
    public void securityUsers(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password("user1").roles("USER")
                .and()
                .withUser("user2").password("user2").roles("ADMIN");
    }
}
