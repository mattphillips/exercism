export default class Transcriptor {
  toRna(dna) {
    return dna.split('').map(nucleotide => DNA_TO_RNA[nucleotide]).join('');
  }
}

const DNA_TO_RNA = {
  A: 'U',
  C: 'G',
  G: 'C',
  T: 'A'
};
