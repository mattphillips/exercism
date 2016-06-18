export default (collection, fn) => map(collection, fn);

const map = (xs, f) => {
  if (xs.length === 0) return [];

  const head = xs[0];
  const tail = xs.slice(1, xs.length);

  return [f(head)].concat(map(tail, f));
};
