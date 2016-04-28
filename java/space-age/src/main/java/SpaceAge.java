public class SpaceAge {

    private static final double EARTH_ORBITAL_PERIOD = 31557600;
    private static final double MERCURY_ORBITAL_PERIOD = 0.2408467;
    private static final double VENUS_ORBITAL_PERIOD = 0.61519726;
    private static final double MARS_ORBITAL_PERIOD = 1.8808158;
    private static final double JUPITER_ORBITAL_PERIOD = 11.862615;
    private static final double SATURN_ORBITAL_PERIOD = 29.447498;
    private static final double URANUS_ORBITAL_PERIOD = 84.016846;
    private static final double NEPTUNE_ORBITAL_PERIOD = 164.79132;

    private final double seconds;

    public SpaceAge(final double seconds) {
        this.seconds = seconds;
    }

    public double getSeconds() {
        return seconds;
    }

    public double onEarth() {
        return seconds / EARTH_ORBITAL_PERIOD;
    }

    public double onMercury() {
        return calculateAgeOnPlanet(MERCURY_ORBITAL_PERIOD);
    }

    public double onVenus() {
        return calculateAgeOnPlanet(VENUS_ORBITAL_PERIOD);
    }

    public double onMars() {
        return calculateAgeOnPlanet(MARS_ORBITAL_PERIOD);
    }

    public double onJupiter() {
        return calculateAgeOnPlanet(JUPITER_ORBITAL_PERIOD);
    }

    public double onSaturn() {
        return calculateAgeOnPlanet(SATURN_ORBITAL_PERIOD);
    }

    public double onUranus() {
        return calculateAgeOnPlanet(URANUS_ORBITAL_PERIOD);
    }

    public double onNeptune() {
        return calculateAgeOnPlanet(NEPTUNE_ORBITAL_PERIOD);
    }

    private double calculateAgeOnPlanet(double orbitalPeriod) {
        return onEarth() / orbitalPeriod;
    }
}
