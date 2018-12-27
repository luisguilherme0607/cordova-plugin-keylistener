var exec = require('cordova/exec');

function KeyListener() {}

KeyListener.prototype.startListening = function(option, successCallback, errorCallback){
  var options = {};
  cordova.exec(successCallback, errorCallback,'KeyListener', 'startListening', [options]);
}

KeyListener.prototype.stopListening = function(result, successCallback, errorCallback){
  var options = {result};
  cordova.exec(successCallback, errorCallback,'KeyListener', 'stopListening', [options]);
}

// Installation constructor that binds ToastyPlugin to window
KeyListener.install = function() {
  if (!window.plugins) {
    window.plugins = {};
  }
  window.plugins.KeyListener = new KeyListener();
  return window.plugins.KeyListener;
};
cordova.addConstructor(KeyListener.install);

module.exports = new KeyListener();
