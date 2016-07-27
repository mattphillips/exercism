module Anagram (anagramsFor) where

import Data.Char (toLower)
import Data.List (sort)

anagramsFor :: String -> [String] -> [String]
anagramsFor w = filter (\c -> isNotIdentical c && isAnagram c)
  where
    isNotIdentical c = toLowerCase w /= toLowerCase c
    isAnagram c = sortString w == sortString c
    sortString s = sort (toLowerCase s)
    toLowerCase s = map toLower s
