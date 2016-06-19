export default class Series {
  constructor(digits) {
    this.digits = [...digits].map(d => parseInt(d));
  }

  slices(n) {
    if (n > this.digits.length) {
      throw new Error('Slice size is too big.');
    }

    return slice(n, this.digits);
  }
}

const slice = (n, xs) => {
  if (xs.length === 0 || xs.length < n) return [];

  const head = xs.slice(0, n);
  const tail = xs.slice(1);

  return [head].concat(slice(n, tail));
};
