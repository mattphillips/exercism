export default class PhoneNumber {
  constructor(number) {
    this.phoneNumber = cleanNumber(number);
  }

  number() {
    if (this.phoneNumber.length === 11) {
      return this.phoneNumber.startsWith('1') ? this.phoneNumber.substring(1) : INVALID;
    }

    if (this.phoneNumber.length < 10) {
      return INVALID;
    }

    return this.phoneNumber;
  }

  areaCode() {
    return this.phoneNumber.substring(0, 3);
  }

  toString() {
    return '(' + this.areaCode() + ') '
            + this.phoneNumber.substring(3, 6) + '-' + this.phoneNumber.substring(6);
  }
}

const cleanNumber = number => [...number].filter(n => !isNaN(n) && n !== ' ').join('');
const INVALID = '0000000000';
