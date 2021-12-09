/**
 * @param {number[]} nums
 * @return {number}
 */

// My solution
// First, sort the array in order
// Then add all the even indexed element of the array (ex nums[0] + nums[2] + nums[4])
const arrayPairSum = function(nums) {
    const copy = Array(nums.length);
    for (let i = 0; i < copy.length; i++) {
        copy[i] = nums[i];
    }
    const devideSort = (start, end) => {
        if (end - start <= 1) {
            if (nums[start] > nums[end]) {
                let tmp = nums[end];
                nums[end] = nums[start];
                nums[start] = tmp;
            }
        } else {
            let middle = Math.floor( (end - start) / 2 );
            devideSort(start, middle);
            devideSort(middle + 1, end);
            let i = start;
            let j = middle + 1;
            for (let k = start; k <= end; k++) {
                if (i > middle) {
                    copy[k] = nums[j++];
                } else if (j > end) {
                    copy[k] = nums[i++];
                } else {
                    if (nums[i] < nums[j]) {
                        copy[k] = nums[i++];
                    } else {
                        copy[k] = nums[j++];
                    }
                }
            }
            for (let k = start; k <= end; k++) {
                nums[k] = copy[k];
            }
        }
    };
    devideSort(0,nums.length-1);
    let sum = 0;
    for (let i = 0; i < nums.length; i += 2) {
        sum += nums[i];
    }
    return sum;
};

console.log(arrayPairSum([1,2,3,4]));