package com.astronet.oms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * @author: Yanan Lyu
 * @date 3/7/21 11:07 PM
 */

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfiguration {

    @Bean
    public AuditorAware<String> auditorProvider() {
        /**
         *  if you are using spring security, you can get the currently logged username with following code segment.
         *  SecurityContextHolder.getContext().getAuthentication().getName()
         */
        return () -> Optional.ofNullable("Mr. Auditor");
    }
}
