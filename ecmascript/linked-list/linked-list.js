export default class LinkedList {
  constructor() {
    this.head = null;
  }

  push(value) {
    if (this.head === null) {
      this.head = new Node(value, null, null);

    } else {
      let current = this.head;
      while (current.next !== null)
        current = current.next;

      current.next = new Node(value, current, null);
    }
  }

  pop() {
    if (this.head === null) {
      throw new Error('Cannot perform pop on empty list');
    }

    let current = this.head;
    while (current.next !== null) {
      current = current.next;
    }

    if (current.previous !== null) {
      current.previous.next = null;
    }

    if (current === this.head) {
      this.head = null;
    }

    return current.value;
  }

  shift() {
    if (this.head === null) {
      throw new Error('Cannot perform shift on empty list');
    }

    const current = this.head;
    this.head = current.next;
    return current.value;
  }

  unshift(value) {
    if (this.head === null) {
      this.head = new Node(value, null, null);

    } else {
      const current = this.head;
      this.head = new Node(value, null, current);
      current.previous = this.head;
    }
  }

  count() {
    let count = 0;
    if (this.head === null) {
      return count;

    } else {
      count++;
      let current = this.head;

      while (current.next !== null) {
        current = current.next;
        count++;
      }

      return count;
    }
  }

  delete(value) {
    if (this.head === null) {
      throw new Error('Cannot perform delete on empty list');
    }

    if (this.count() === 1 & this.head.value === value) {
      this.head = null;

    } else {
      let current = this.head;
      while (current.next !== null) {
        if (current.value === value) {
          if (current.previous === null) {
            current.next.previous = null;
            this.head = current.next;

          } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
          }
        }

        current = current.next;
      }
    }
  }
}

class Node {
  constructor(value, previous, next) {
    this.value = value;
    this.previous = previous;
    this.next = next;
  }
}
