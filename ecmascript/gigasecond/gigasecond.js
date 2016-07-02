export default class Gigasecond {
  constructor(date) {
    this.gigaDate = date.getTime() + GIGA_MILLISECONDS;
  }

  date() {
    return new Date(this.gigaDate);
  }
}

const GIGA_MILLISECONDS = 1000000000000;
