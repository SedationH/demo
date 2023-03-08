// 0. 对于任何一个需要被迭代的对象，需要满足以下特征
const range = {
  from: 1,
  to: 5,
  // 1. 有一个 Symbol.iterator 的 key 和 对应的 function value 「A」
  [Symbol.iterator]: function () {
    // 2. 这个 A 返回一个迭代器 iterator
    // 这个 iterator 有一个 next 方法
    const { from, to } = this;
    let p = from;

    return {
      next: function () {
        // 3. next 方法返回的对象有两个属性
        // 1. done: 表示是否迭代完成
        // 2. value: 表示当前迭代的值
        return {
          done: p > to,
          value: p++
        }
      }
    }
  }
};

// const rangeIterator = range[Symbol.iterator]();
// while (true) {
//   const { done, value } = rangeIterator.next();
//   if (done) break;
//   // 执行你的方法
//   console.log(value);
//   // 你的方法结束
// }

for (const num of range) {
  console.log({ num });
}

// for(const num of range) {
//   console.log(num);
// }

// const arr = [1, 2, 3, 4, 5];
// const funcOfArr = arr[Symbol.iterator]
// const funcOfArrReturn = funcOfArr.bind(arr)();

// while (true) {
//   const { done, value } = funcOfArrReturn.next();
//   if (done) break;
//   console.log(value);
// }

// for (const num of arr) {
//   console.log(num);
// }

