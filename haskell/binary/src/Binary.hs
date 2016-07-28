module Binary (toDecimal) where

import Data.Char (digitToInt)

toDecimal :: String -> Int
toDecimal binary =
  if (isValid) then
    foldl convert 0 $ zip [0..] (reverse binary)
  else
    0
  where
    convert acc (i,b) = acc + digitToInt b * 2 ^ i
    isValid = foldl isBinary True binary
    isBinary acc c = acc && (c == '0' || c == '1')
