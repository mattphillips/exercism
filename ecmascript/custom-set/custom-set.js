export default class Set {
  constructor(values) {
    this.elements = (typeof values === 'undefined')
      ? []
      : values.reduce((arr, value) => {
        if (arr.includes(value)) {
          return arr;
        } else {
          arr.push(value);
          return arr;
        }
      }, []);
    Object.freeze(this);
  }

  delete(value) {
    return new Set(this.elements.filter(element => element !== value));
  }

  eql(other) {
    return normalise(this.elements) === normalise(other.elements);
  }

  difference(other) {
    return new Set(this.elements.filter(element => !other.member(element)));
  }

  disjoint(other) {
    return other.elements.every(element => !this.member(element));
  }

  empty() {
    return new Set();
  }

  intersection(other) {
    return new Set(other.elements.filter(element => this.member(element)));
  }

  member(value) {
    return this.elements.includes(value);
  }

  put(value) {
    return new Set([...this.elements, value]);
  }

  size() {
    return this.elements.length;
  }

  subset(other) {
    return other.elements.every(element => this.member(element));
  }

  toList() {
    return this.elements;
  }

  union(other) {
    return new Set([...this.elements, ...other.elements]);
  }
}

const normalise = map => map.sort().toString();
