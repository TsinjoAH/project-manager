package com.management.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class Config {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        PreFilter preFilter=new PreFilter();
        httpSecurity.cors().configurationSource(corsConfig()).and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity
                .cors()
                .and()
                .addFilter(preFilter)
                .authorizeHttpRequests(
                        (auhtz)->
                    auhtz.anyRequest().permitAll()
                ).httpBasic();
        return httpSecurity.build();
    }

    public CorsConfigurationSource corsConfig(){
        CorsConfiguration config=new CorsConfiguration();
        config.setAllowedHeaders(List.of("*"));
        config.setAllowedMethods(List.of("*"));
        config.setAllowedOrigins(List.of("*"));
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",config);
        return source;
    }

}
