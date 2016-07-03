export default class Octal {
  constructor(octal) {
    this.octal = octal;
  }

  toDecimal() {
    return this.octal.match(OCTAL)
      ? [...this.octal].reverse().reduce((total, o, index) => total + o * Math.pow(8, index), 0)
      : 0;
  }
}

const OCTAL = /^[0-7]+$/;
