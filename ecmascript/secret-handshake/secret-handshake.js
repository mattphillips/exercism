export default class SecretHandshake {
  constructor(decimal) {
    if (!Number.isInteger(decimal)) throw new Error('Handshake must be a number');
    this.decimal = decimal;
  }

  commands() {
    const handsake = Object.keys(secret)
      .map(key => (this.decimal & key) == key ? [secret[key]] : [])
      .reduce((acc, next) => acc.concat(next));
    return (this.decimal & reverse) == reverse ? handsake.reverse() : handsake;
  }
}

const reverse = 16;
const secret = {
  1: 'wink',
  2: 'double blink',
  4: 'close your eyes',
  8: 'jump',
};
