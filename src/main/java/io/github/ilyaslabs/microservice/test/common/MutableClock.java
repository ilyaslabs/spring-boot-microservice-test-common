package io.github.ilyaslabs.microservice.test.common;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

/**
 * A mutable implementation of {@link Clock} that allows manipulation of the current time
 * by adding or subtracting durations, or setting a specific instant.
 *
 * This class is useful for testing and scenarios where the time needs to be controlled
 * or advanced manually.
 */
public class MutableClock extends Clock {

    private Instant instant;
    private final ZoneId zone;

    public MutableClock(Instant fixedInstant, ZoneId zone) {
        this.instant = fixedInstant;
        this.zone = zone;
    }

    /**
     * Returns the time zone associated with this clock instance.
     *
     * @return the zone ID of this clock
     */
    @Override
    public ZoneId getZone() {
        return zone;
    }

    /**
     * Creates a new {@code MutableClock} instance with the specified time zone,
     * retaining the current instant of this clock.
     *
     * @param zone the time zone to be associated with the new clock instance
     * @return a new clock instance with the specified time zone
     */
    @Override
    public Clock withZone(ZoneId zone) {
        return new MutableClock(instant, zone);
    }

    /**
     * Returns the current instant represented by this clock.
     *
     * @return the current instant of this clock
     */
    @Override
    public Instant instant() {
        return instant;
    }

    /**
     * Adds the specified duration to the current instant of this clock.
     *
     * @param duration the duration to add to the instant; must not be null
     */
    public void add(Duration duration) {
        this.instant = instant.plus(duration);
    }


    /**
     * Subtracts the specified duration from the current instant of this clock.
     *
     * @param duration the duration to subtract from the instant; must not be null
     */
    public void subtract(Duration duration) {
        this.instant = instant.minus(duration);
    }

    /**
     * Sets the current instant of this clock to the specified value.
     *
     * @param newInstant the new instant to set; must not be null
     */
    public void set(Instant newInstant) {
        this.instant = newInstant;
    }
}