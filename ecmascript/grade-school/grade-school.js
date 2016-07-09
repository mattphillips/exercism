export default class School {
  constructor() {
    this.db = {};
  }

  roster() {
    return copy(this.db);
  }

  add(name, grade) {
    const updatedGrade = this.db[grade] ? this.db[grade].concat([name]).sort() : [name];
    this.db = {
      ...this.db,
      [grade]: updatedGrade,
    };
  }

  grade(grade) {
    return copy(this.db[`${grade}`] || []);
  }
}

const copy = db => JSON.parse(JSON.stringify(db));
