export default class SpaceAge {
  constructor(seconds) {
    this.seconds = seconds;
    this.unroundedEarthAge = seconds / EARTH_ORBITAL_PERIOD;
  }

  getSeconds() {
    return this.seconds;
  }

  onEarth() {
    return calculateAgeOnPlanet(this.seconds, EARTH_ORBITAL_PERIOD);
  }

  onMercury() {
    return calculateAgeOnPlanet(this.unroundedEarthAge, MERCURY_ORBITAL_PERIOD);
  }

  onVenus() {
    return calculateAgeOnPlanet(this.unroundedEarthAge, VENUS_ORBITAL_PERIOD);
  }

  onMars() {
    return calculateAgeOnPlanet(this.unroundedEarthAge, MARS_ORBITAL_PERIOD);
  }

  onJupiter() {
    return calculateAgeOnPlanet(this.unroundedEarthAge, JUPITER_ORBITAL_PERIOD);
  }

  onSaturn() {
    return calculateAgeOnPlanet(this.unroundedEarthAge, SATURN_ORBITAL_PERIOD);
  }

  onUranus() {
    return calculateAgeOnPlanet(this.unroundedEarthAge, URANUS_ORBITAL_PERIOD);
  }

  onNeptune() {
    return calculateAgeOnPlanet(this.unroundedEarthAge, NEPTUNE_ORBITAL_PERIOD);
  }
}

const calculateAgeOnPlanet = (time, orbitalPeriod) => parseFloat((time / orbitalPeriod).toFixed(2));

const EARTH_ORBITAL_PERIOD = 31557600;
const MERCURY_ORBITAL_PERIOD = 0.2408467;
const VENUS_ORBITAL_PERIOD = 0.61519726;
const MARS_ORBITAL_PERIOD = 1.8808158;
const JUPITER_ORBITAL_PERIOD = 11.862615;
const SATURN_ORBITAL_PERIOD = 29.447498;
const URANUS_ORBITAL_PERIOD = 84.016846;
const NEPTUNE_ORBITAL_PERIOD = 164.79132;
