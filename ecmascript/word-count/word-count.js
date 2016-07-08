export default class Words {
  count(phrase) {
    const words = phrase.trim().toLowerCase().split(/\s+/);
    return words.reduce((wordCount, word) => containsKey(wordCount, word)
      ? putKeyValue(wordCount, word, wordCount[word] + 1)
      : putKeyValue(wordCount, word, 1),
      {}
    );
  }
}

const containsKey = (obj, key) => Object.keys(obj).includes(key);
const putKeyValue = (obj, key, value) => ({ ...obj, [key]: value });
