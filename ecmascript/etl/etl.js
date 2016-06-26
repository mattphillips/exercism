export default old => Object.keys(old).map(score => {
  return old[score].map(letter => {
    return { [letter.toLowerCase()]: parseInt(score) };
  }).reduce(mergeObjects);
}).reduce(mergeObjects);

const mergeObjects = (obj, next) => Object.assign({}, obj, next);
