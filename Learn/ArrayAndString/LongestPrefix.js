/**
 * @param {string[]} strs
 * @return {string}
 */
const longestCommonPrefix = function(strs) {
    const firstStr = strs[0];
    const maxLength = firstStr.length;
    let commonLength = 0;

    const isCommon = (char, index) => {
        for (let i = 1; i < strs.length; i++) {
            if (strs[i][index] !== char) return false;
        }
        return true;
    };

    for (let i = 0; i < maxLength; i++) {
        if (isCommon(firstStr[i], i)) {
            commonLength++;
        } else {
            break;
        }
    }
    return firstStr.slice(0,commonLength);
};