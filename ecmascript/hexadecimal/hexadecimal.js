export default class Hex {
  constructor(hex) {
    this.hex = hex;
  }

  toDecimal() {
    return this.hex.match(HEX)
      ? [...this.hex].reverse().reduce((total, h, index) => total + parseInt(h, 16) * Math.pow(16, index), 0)
      : 0;
  }
}

const HEX = /^[0-9a-f]+$/;
