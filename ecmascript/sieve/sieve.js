export default class Sieve {
  constructor(limit) {
    this.primes = filterPrimes([...Array(limit + 1).keys()].filter(i => i > 1), []);
  }
}

const filterPrimes = (range, primes) => {
  if (range.length === 0) return primes;

  const head = range[0];
  return filterPrimes(range.filter(i => i % head != 0), primes.concat(head));
};
