package com.ecole221.classe.service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TheMapper {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
