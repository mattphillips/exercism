export default class Squares {
  constructor(n) {
    this.squareOfSums = sumN(n, (total, next) => total + next) ** 2;
    this.sumOfSquares = sumN(n, (total, next) => total + next ** 2);
    this.difference = this.squareOfSums - this.sumOfSquares;
  }
}

const sumN = (n, sum) => naturalNumbers(n).reverse().reduce(sum);

const naturalNumbers = n => {
  if (n < 0) return [];
  return [n].concat(naturalNumbers(n - 1));
};
