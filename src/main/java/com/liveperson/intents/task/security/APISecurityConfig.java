package com.liveperson.intents.task.security;

import com.liveperson.intents.task.dal.IntentRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@Order(1)
public class APISecurityConfig extends WebSecurityConfigurerAdapter {

    private String apiKeyParamName = "API-KEY";

    private IntentRepository intentRepository;

    public APISecurityConfig(IntentRepository intentRepository) {
        this.intentRepository = intentRepository;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        APIKeyAuthFilter filter = new APIKeyAuthFilter(apiKeyParamName);
        filter.setAuthenticationManager(authentication -> {
            String principal = (String) authentication.getPrincipal();
            String apiKey = intentRepository.getApiKey(principal);
            if (apiKey == null) {
                throw new BadCredentialsException("The API key was not found or not the expected value.");
            }
            authentication.setAuthenticated(true);
            return authentication;
        });
        httpSecurity.
                antMatcher("/*intent*").
                csrf().disable().
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                and().addFilter(filter).authorizeRequests().anyRequest().authenticated();
    }

}