export default class Anagram {
  constructor(word) {
    this.word = word;
  }

  matches(words) {
    const candidates = Array.isArray(words)
      ? words
      : Object.values(arguments);

    return candidates.filter(candidate => isNotIdenticalWord(this.word, candidate) && isAnagram(this.word, candidate));
  }
}

const isNotIdenticalWord = (word, candidate) => word.toLowerCase() !== candidate.toLowerCase();
const isAnagram = (word, candidate) => sortWord(word) === sortWord(candidate);
const sortWord = word => word.toLowerCase().split('').sort().join('');
