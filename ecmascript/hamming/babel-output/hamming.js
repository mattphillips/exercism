'use strict';

Object.defineProperty(exports, '__esModule', {
  value: true
});

var _createClass = (function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ('value' in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; })();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError('Cannot call a class as a function'); } }

var Hamming = (function () {
  function Hamming() {
    _classCallCheck(this, Hamming);
  }

  _createClass(Hamming, [{
    key: 'compute',
    value: function compute(s, t) {
      if (s.length != t.length) {
        throw new Error('DNA strands must be of equal length.');
      }

      return calc(s, t);
    }
  }]);

  return Hamming;
})();

exports['default'] = Hamming;

var calc = function calc(s, t) {
  if (s.length === 0 && t.length === 0) return 0;

  var sHead = s.substring(0, 1);
  var tHead = t.substring(0, 1);
  var sTail = s.substring(1);
  var tTail = t.substring(1);

  return eq(sHead, tHead) + calc(sTail, tTail);
};

var eq = function eq(a, b) {
  return a === b ? 0 : 1;
};
module.exports = exports['default'];