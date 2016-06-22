export default (numbers) => {
  return {
    to: t => {
      const ns = naturalNumbers(t - 1);
      const multiples = numbers.map(n => filterMultiples(ns, n))
                               .reduce((all, next) => all.concat(next));

      return [...new Set(multiples)].reduce((sum, next) => sum + next);
    },
  };
};

const naturalNumbers = n => {
  if (n < 0) return [];
  return [n].concat(naturalNumbers(n - 1));
};

const filterMultiples = (ns, m) => ns.filter(n => n % m == 0);
