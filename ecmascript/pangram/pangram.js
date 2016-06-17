export default class pangram {
  constructor(sentence) {
    this.sentence = sentence;
  }

  isPangram() {
    const characters = new Set([...this.sentence.toLowerCase()]);
    return buildRange(ALPHABET_START, ALPHABET_END)
            .map(i => String.fromCharCode(i))
            .reduce((acc, next) => acc && characters.has(next), true);
  }
}

const ALPHABET_START = 'a'.charCodeAt(0);
const ALPHABET_END = 'z'.charCodeAt(0);
const buildRange = (from, to) => Array.from(new Array(to - from), (x, i) => i + from);
