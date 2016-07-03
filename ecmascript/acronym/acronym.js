export default {
  parse: phrase => {
    const words = phrase.split(/\s+|-|[a-z](?=[A-Z])/g);
    return words
            .map(word => word.substring(0, 1))
            .reduce((acronym, next) => acronym + next)
            .toUpperCase();
  },
};
