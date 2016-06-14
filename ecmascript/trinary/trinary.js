export default class Trinary {
  constructor(trinary) {
    this.trinary = trinary;
  }

  toDecimal() {
    return TRINARY.test(this.trinary)
      ? [...this.trinary].reverse().reduce((total, b, index) => total + b * Math.pow(3, index), 0)
      : 0;
  }
}

const TRINARY = /^[012]+$/;
