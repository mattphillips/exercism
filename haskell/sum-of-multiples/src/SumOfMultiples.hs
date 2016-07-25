module SumOfMultiples (sumOfMultiples) where

sumOfMultiples :: [Int] -> Int -> Int
sumOfMultiples numbers n = sum [ i | i <- [1.. n - 1], any (isDivisible i) numbers]

isDivisible :: Int -> Int -> Bool
isDivisible x y = x `mod` y == 0
