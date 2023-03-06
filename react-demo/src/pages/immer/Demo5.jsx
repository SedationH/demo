import React from "react"

function isPlainObject(value) {
  if (typeof value !== "object" || value === null) {
    return false
  }
  let proto = Object.getPrototypeOf(value)
  if (proto === null || proto === Object.prototype) {
    return true
  }
  return false
}

function produce(state, recipe) {
  let copies = new Map() // Map 的 key 可以是一个对象，非常适合用来缓存被修改的对象

  const handler = {
    get(target, prop) {
      // 增加一个 get 的劫持，返回一个 Proxy
      const value = target[prop]
      return isPlainObject() ? new Proxy(value, handler) : value
    },
    set(target, prop, value) {
      const cur = copies.has(target) ? copies.get(target) : target
      const copy = {
        ...cur,
        [prop]: value,
      } // 浅拷贝
      copies.set(target, copy)
    },
  }

  // 检查对象是否有改变
  function hasChanges(base) {
    if (!isPlainObject(base)) {
      return false
    }
    if (copies.has(base)) {
      return true
    }
    // 深度查找
    const keys = Object.keys(base)
    for (let i = 0; i < keys.length; i++) {
      if (hasChanges(base[keys[i]])) {
        return true
      }
    }
    return false
  }

  /**
   * 增加一个 finalize 函数，遍历初始 state 的 key，
   * 如果被修改过就返回修改后的内容，否则返回原来的内容
   */
  function finalize(state) {
    if (!hasChanges(state)) {
      return state
    }

    const result = copies.has(state) ? copies.get(state) : { ...state }
    Object.keys(state).map((key) => {
      result[key] = finalize(result[key])
    })
    return result
  }

  const draft = new Proxy(state, handler)
  recipe(draft)
  return finalize(state)
}

export const baseState = {
  0: {
    title: "Learn TypeScript",
    done: true,
  },
  1: {
    title: "Try Immer",
    done: false,
  },
}

export const nextState = produce(baseState, (draftState) => {
  draftState[1].done = true
})

console.log(nextState === baseState) // false
console.log(nextState[0] === baseState[0]) // true
console.log(nextState[1] === baseState[1]) // false
console.log(nextState.length === baseState.length) // false

function Demo5() {
  return <div>Demo5</div>
}

export default Demo5
