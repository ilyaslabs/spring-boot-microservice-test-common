package io.github.ilyaslabs.microservice.test.common;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Test class for validating the configuration of the {@link MutableClock} bean
 * within the Spring application context.
 * <p>
 * This test ensures the {@link MutableClock} is correctly instantiated as a
 * Spring-managed bean using the {@link FixedClockConfiguration}. The test
 * component scanning for the relevant package.
 * <p>
 * An instance of {@link MutableClock} is autowired into this test class, and
 * assertions are performed to verify its presence and successful configuration.
 */
@SpringBootTest(classes = {AutoConfig.class, FixedClockConfiguration.class})
class FixedClockConfigurationTest {

    @Autowired
    private MutableClock clock;

    @Test
    void testMutableClockBeanIsCreated() {
        assertThat(clock).isNotNull();
    }

}