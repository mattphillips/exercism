module Anagram (anagramsFor) where

import Data.Char (toLower)
import Data.List (sort)

anagramsFor :: String -> [String] -> [String]
anagramsFor word candidates = filter (isNotIdenticalAndIsAnagram word) candidates

isNotIdenticalAndIsAnagram :: String -> String -> Bool
isNotIdenticalAndIsAnagram w c = not (isIdenticalWord w c) && isAnagram w c

isIdenticalWord :: String -> String -> Bool
isIdenticalWord w c = toLowerCase w == toLowerCase c

isAnagram :: String -> String -> Bool
isAnagram w c = sortString w == sortString c

sortString :: String -> String
sortString w = sort (toLowerCase w)

toLowerCase :: String -> String
toLowerCase s = map toLower s
