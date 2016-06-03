export default class HelloWorld {
  hello(input) {
    const reply = input || 'World';
    return `Hello, ${reply}!`;
  };
}
