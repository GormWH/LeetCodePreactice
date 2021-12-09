/**
 * @param {character[]} s
 * @return {void} Do not return anything, modify s in-place instead.
 */
const reverseString = function(s) {
    let i = 0;
    let j = s.length-1;
    while (i < j) {
        let tmp = s[i];
        s[i++] = s[j];
        s[j--] = tmp;
    }
    console.log(s);
};