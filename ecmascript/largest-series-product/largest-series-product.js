export default class Series {
  constructor(digits) {
    this.digits = digits;
  }

  largestProduct(n) {
    if (n > this.digits.length) throw new Error('Slice size is too big.');

    if (n < 0 || !(this.digits.match(/^$|^[\d]+$/))) throw new Error('Invalid input.');

    if (n === 0) return 1;

    const products = generateProductSlices([...this.digits], n);
    return products.reduce((largest, next) => largest > next ? largest : next);
  }
}

const generateProductSlices = (xs, n) => {
  if (xs.length < n) return [];

  const slice = xs.slice(0, n);
  const tail = xs.slice(1);
  const product = slice.reduce((p, x) => p * x);

  return [product].concat(generateProductSlices(tail, n));
};
