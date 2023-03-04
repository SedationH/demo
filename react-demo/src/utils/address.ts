const user1 = {
  name: "A",
}
const user2 = {
  name: "B",
}
const users = [
  user1,
  user2,
  {
    name: "A",
  },
  user1,
]

console.log(users[0] === users[2])
console.log(users[0] === users[3])

/**
 * 需求是什么？
 *  需要比较很多个引用类型的数据，不想一个一个去 用 == 的方式进行比较
 *  想让他们有一个 string 类型的值，这个值是唯一的，类似于地址
 *
 * 分析
 *  JS 不提供地址的获取方式
 *  是唯一的就好，是不是真实的地址并不重要
 */

const knownObjects = new Map()

function* addressGenerator() {
  let i = 0
  while (true) {
    yield `0x${i.toString(32).padStart(8, "0")}`
    i++
  }
}

const addressGen = addressGenerator()

function getAddress(obj: any) {
  if (knownObjects.has(obj)) {
    return knownObjects.get(obj)
  }
  const address = addressGen.next().value
  console.log(address)
  knownObjects.set(obj, address)
  return address
}

console.log(users.map((user) => getAddress(user)))

