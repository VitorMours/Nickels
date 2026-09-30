package com.nickels.backend_core.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sprinframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

z
@Configuration 
class PasswordEncoder {
  @Bean 
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}