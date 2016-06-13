export default class Binary {
  constructor(binary) {
    this.binary = binary;
  }

  toDecimal() {
    return BINARY.test(this.binary)
      ? [...this.binary].reverse().reduce((total, b, index) => total + b * Math.pow(2, index), 0)
      : 0;
  }
}

const BINARY = /^[01]+$/;
