export default {
  keep: (collection, predicate) => filter(collection, predicate),
  discard: (collection, predicate) => filter(collection, negate(predicate)),
};

const negate = p => x => !p(x);

const filter = (xs, p) => {
  if (xs.length === 0) return [];

  const head = xs[0];
  const tail = xs.slice(1);

  if (p(head)) return [head].concat(filter(tail, p));
  else return filter(tail, p);
};
