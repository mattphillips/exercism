const EMPTY_STRING = '';
const PRIME_FACTOR_RAINDROPS = {
  3: 'Pling',
  5: 'Plang',
  7: 'Plong'
};

export default () => ({
  convert: number => Object.keys(PRIME_FACTOR_RAINDROPS)
                           .map(prime => buildRaindrop(prime, number))
                           .join(EMPTY_STRING)
                    || number.toString()
});

const buildRaindrop = (prime, number) => number % prime === 0 ? PRIME_FACTOR_RAINDROPS[prime] : EMPTY_STRING;
