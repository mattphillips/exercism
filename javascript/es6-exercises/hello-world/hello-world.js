export default class HelloWorld {
  constructor() {
     this.helloPrefix = 'Hello,';
  }
  hello(input) {
    const reply = input ? `${this.helloPrefix} ${input}` : `${this.helloPrefix} World`
    return `${reply}!`;
  };
}
