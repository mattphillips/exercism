export default class Allergies {
  constructor(score) {
    this.allergens = Object.keys(allergens).filter(allergen => (score & allergens[allergen]) === allergens[allergen]);
  }

  allergicTo(allergen) {
    return this.allergens.includes(allergen);
  }

  list() {
    return this.allergens;
  }
}

const allergens = {
  eggs: 1,
  peanuts: 2,
  shellfish: 4,
  strawberries: 8,
  tomatoes: 16,
  chocolate: 32,
  pollen: 64,
  cats: 128
};
