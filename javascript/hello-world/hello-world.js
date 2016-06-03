export default class HelloWorld {
  hello(input) {
    const helloPrefix = 'Hello,';
    const reply = input ? `${helloPrefix} ${input}` : `${helloPrefix} World`
    return `${reply}!`;
  };
}
