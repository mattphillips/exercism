const FIRST_DIVISOR = 2;

export default class PrimeFactors {
  for(naturalNumber) {
    return computePrimeFactors([], naturalNumber, FIRST_DIVISOR);
  }
}

const computePrimeFactors = (primeFactors, naturalNumberRemainder, divisor) => {
  if (isRemainderOne(naturalNumberRemainder))
    return primeFactors;

  else if (isRemainderDivisible(naturalNumberRemainder, divisor))
    return computePrimeFactors([...primeFactors, divisor], naturalNumberRemainder / divisor, divisor);

  else
    return computePrimeFactors(primeFactors, naturalNumberRemainder, divisor + 1);
};

const isRemainderOne = (remainingNaturalNumber) => remainingNaturalNumber === 1;

const isRemainderDivisible = (remainder, divisor) => remainder % divisor === 0;
