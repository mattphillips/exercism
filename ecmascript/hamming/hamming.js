export default class Hamming {
  compute(s, t) {
    if (s.length != t.length) {
      throw new Error('DNA strands must be of equal length.');
    }

    return calc(s, t);
  }
}

const calc = (s, t) => {
  if (s.length === 0 && t.length === 0) return 0;

  const sHead = s.substring(0, 1);
  const tHead = t.substring(0, 1);
  const sTail = s.substring(1);
  const tTail = t.substring(1);

  return eq(sHead, tHead) + calc(sTail, tTail);
};

const eq = (a, b) => a === b ? 0 : 1;
