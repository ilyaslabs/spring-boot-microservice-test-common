package io.github.ilyaslabs.microservice.test.common;

import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for enabling component scanning within the specific base package.
 * This class is annotated with {@code @Configuration}, making it a source of bean definitions,
 * and {@code @ComponentScan}, which specifies the base package for automatic scanning
 * of Spring components, configurations, and services.
 */
@Configuration
class AutoConfig {
}
