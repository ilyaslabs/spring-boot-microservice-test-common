package io.github.ilyaslabs.microservice.test.common;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.backoff.Sleeper;

import java.time.Instant;
import java.time.ZoneId;

/**
 * Test configuration class providing bean definitions for testing environments.
 * <p>
 * This configuration includes a fixed {@link MutableClock} for testing purposes and
 * a no-operation implementation of {@link Sleeper} to bypass delays during tests.
 * <p>
 * It uses the {@code @TestConfiguration} annotation, which is a specialized form of
 * {@code @Configuration} for defining beans that should only be available in the test
 * context.
 */
@TestConfiguration(proxyBeanMethods = false)
public class FixedClockConfiguration {

    /**
     * Creates a {@link MutableClock} bean with a fixed initial instant and UTC time zone.
     * <p>
     * The created clock is initialized with the minimum possible {@link Instant} (`Instant.MIN`)
     * and is set to the "UTC" time zone.
     * This clock is mutable, allowing modifications to its instant, making it particularly
     * useful for testing scenarios where control over time is necessary.
     *
     * @return a {@link MutableClock} instance initialized with `Instant.MIN` and the "UTC" time zone
     */
    @Bean
    MutableClock clock() {
        return new MutableClock(Instant.MIN, ZoneId.of("UTC"));
    }

    /**
     * Provides a {@link Sleeper} implementation that performs no operation, effectively
     * bypassing any sleep or delay behavior. This implementation is useful in testing
     * environments where delays need to be skipped to improve test execution speed.
     *
     * @return a no-operation {@link Sleeper} implementation
     */
    @Bean
    public Sleeper sleeper() {
        // No-op sleeper (skips Thread.sleep)
        return millis -> {
        };
    }
}
