let arr = [];
arr.push(6);
arr.push(8);
arr.push(16);
arr.push(3);
arr.push(12);
arr.push(5);
arr.push(22);

let arr2 = arr;
console.log('arr2 === arr', arr2 === arr);

let brr = arr.map((item) => item);
console.log('brr === arr', brr === arr);
console.log(brr);

let crr = arr.map((item) => item * 10);
console.log(crr);

let drr = arr.filter((item) => item > 10);
console.log(drr);
