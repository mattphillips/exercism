export default class Trinary {
  constructor(trinary) {
    this.trinary = trinary;
  }

  toDecimal() {
    return TRINARY.test(this.trinary)
      ? [...this.trinary].reverse().reduce((total, t, index) => total + t * Math.pow(3, index), 0)
      : 0;
  }
}

const TRINARY = /^[012]+$/;
