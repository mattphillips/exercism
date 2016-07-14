module DNA (toRNA) where

import Data.List

toRNA :: String -> Maybe String
toRNA dna = sequence (map toRnaNucleotide dna)

toRnaNucleotide :: Char -> Maybe Char
toRnaNucleotide 'G' = Just 'C'
toRnaNucleotide 'C' = Just 'G'
toRnaNucleotide 'T' = Just 'A'
toRnaNucleotide 'A' = Just 'U'
toRnaNucleotide _   = Nothing
