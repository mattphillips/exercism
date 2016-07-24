module LeapYear (isLeapYear) where

isLeapYear :: Int -> Bool
isLeapYear year = isDivisible year 4 && not (isDivisible year 100) || isDivisible year 400
  where
    isDivisible x divisor = x `mod` divisor == 0
