module Hamming (distance) where

distance :: String -> String -> Maybe Int
distance s1 s2
  | length s1 /= length s2 = Nothing
  | otherwise = Just (calc s1 s2)

calc :: String -> String -> Int
calc [] [] = 0
calc (s:ss) (t:ts) = eq s t + calc ss ts

eq :: Char -> Char -> Int
eq a b = if a == b then 0 else 1
