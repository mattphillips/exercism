module PrimeFactors (primeFactors) where

primeFactors :: Integer -> [Integer]
primeFactors n = compute n 2

compute :: Integer -> Integer -> [Integer]
compute rem divisor
  | rem == 1 = []
  | rem `mod` divisor == 0 = divisor : compute (rem `div` divisor) divisor
  | otherwise = compute rem (divisor + 1)
