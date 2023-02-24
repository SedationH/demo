import { observable, autorun, batch, reaction } from "@formily/reactive"

function testObservable1() {
  // 将一个对象变化可观察的，就是倾听它的set操作
  const obs = observable({
    aa: {
      bb: 123,
    },
    cc: {
      dd: 123,
    },
  })
  autorun(() => {
    // 首次的时候会触发，变化的时候也会触发
    // 总共触发2次
    console.log("normal1", obs.aa.bb)
  })

  //数据进行set操作的时候，就会触发
  obs.aa.bb = 44

  autorun(() => {
    // 当值相同的时候，不会重复触发
    // 这里只会触发1次
    console.log("normal2", obs.cc.dd)
  })

  obs.cc.dd = 123
}

function testObservable2() {
  const obs = observable({
    aa: {
      bb: 123,
    },
    cc: {
      dd: 123,
    },
    ee: {
      ff: 123,
    },
    gg: {
      hh: 123,
    },
  })

  autorun(() => {
    // 整个字段被赋值的话，就会触发
    // 所以，这里触发2次
    console.log("object1", obs.cc)
  })

  obs.cc = { dd: 456 }

  autorun(() => {
    // 这里会触发2次，虽然值相同
    // 但是object的比较是通过引用比较的
    console.log("object2", obs.ee)
  })

  obs.ee = { ff: 123 }

  autorun(() => {
    // 只是倾听aa字段的话，那么子字段的变化是不会触发的
    // 因为obs.aa的引用没有变化
    // 所以这里只触发1次
    console.log("object3", obs.aa)
  })

  console.log("testObservable2 set data")
  obs.aa.bb = 44

  autorun(() => {
    // 主体变化的时候，子的也要变化
    // 所以这里触发2次
    console.log("object4", obs.gg.hh)
  })

  console.log("testObservable2 set data2")
  obs.gg = { hh: 45 }
}

function testObservable3() {
  const obs = observable({
    aa: {
      bb: ["a"],
    },
  })
  autorun(() => {
    // 只倾听bb字段的话，变化的时候也不会触发
    // 因为obs.aa.bb的引用没变化
    console.log("array1", obs.aa.bb)
  })

  autorun(() => {
    // length字段会autorun的时候触发
    // 因为obs.aa.bb的length字段发生变化了
    console.log("array2", obs.aa.bb.length)
  })

  autorun(() => {
    // 即使原来的不存在，也能触发
    // 这里会触发2次，因为的确obs.aa.bb[1]的值变了
    console.log("array3", obs.aa.bb[1])
  })

  console.log("testObservable3 set data")
  obs.aa.bb.push("cc")
}

function testObservable4() {
  const obs = observable({
    aa: {
      bb: ["a"],
    },
    cc: "78",
  })
  autorun(() => {
    // 倾听其他字段的话当然也不会触发
    console.log("other", obs.cc)
  })

  console.log("testObservable4 set data")
  obs.aa.bb.push("cc")
}

function testObservableShadow() {
  const obs = observable.shallow({
    aa: {
      bb: "a",
    },
    cc: {
      dd: "a",
    },
  })

  autorun(() => {
    // 这里只会触发1次，因为是浅倾听set操作
    console.log("shadow1", obs.aa.bb)
  })

  console.log("testObservableShadow set data1")
  obs.aa.bb = "123"

  autorun(() => {
    // 这里会触发2次，aa属于浅倾听的范围
    console.log("shadow2", obs.cc)
  })

  console.log("testObservableShadow set data2")
  obs.cc = { dd: "c" }
}

function testReaction() {
  const obs = observable({
    aa: 1,
    bb: 2,
  })

  const dispose = reaction(() => {
    return obs.aa + obs.bb
  }, console.log)

  batch(() => {
    //不会触发，因为obs.aa + obs.bb值没变
    obs.aa = 2
    obs.bb = 2
  })

  // obs.aa = 4

  dispose()
}

export default function testObservable() {
  // testObservable1()
  // testObservable2()
  // testObservable3()
  // testObservable4()
  // testObservableShadow()
  testReaction()
  return 1
}
