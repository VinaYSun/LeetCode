/**
* 07/03/16
* Reverse String using JavaScript
*
* Getting familiar with JavaScript syntax
* and also review algorithms
*/
var reverseString = function(s) {
    var rst = '';
    if (s == null) {
        return null;
    }
    for (var i = s.length - 1; i >= 0; i--) {
        rst += s[i];
    }
    return rst;
};