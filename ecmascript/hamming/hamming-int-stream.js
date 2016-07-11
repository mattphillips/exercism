export default class Hamming {
  compute(s, t) {
    if (s.length !== t.length) {
      throw new Error('DNA strands must be of equal length.');
    }

    return intStream(s.length).map(i => eq(s[i], t[i])).reduce(sum);
  }
}

const intStream = size => Array.from(new Array(size), (arr, i) => i);
const eq = (a, b) => a === b ? 0 : 1;
const sum = (total, next) => total + next;
