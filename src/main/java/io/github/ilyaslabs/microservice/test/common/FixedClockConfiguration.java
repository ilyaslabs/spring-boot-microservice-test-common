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
     * Provides a {@link MutableClock} instance initialized with a fixed instant and time zone.
     * This clock starts at the epoch instant (1970-01-01T00:00:00Z) and operates in the UTC
     * time zone, making it suitable for testing scenarios where a predictable and modifiable
     * clock is required.
     *
     * @return a {@link MutableClock} instance initialized with the epoch instant and UTC time zone
     */
    @Bean
    MutableClock clock() {
        return new MutableClock(Instant.EPOCH, ZoneId.of("UTC"));
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
