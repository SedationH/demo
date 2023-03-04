import React, { useState } from "react"
import { rawList } from "./Demo1"

function Demo2() {
  const [list, setList] = useState(rawList)

  function handleChange() {
    list[0] = {
      ...list[0],
      title: "JavaScript changed",
    }
    setList([...list])
  }
  // 调用 setList 就会触发这里的 render
  console.log("render", list)

  return (
    <div className="flex-center">
      <div>
        <button onClick={handleChange}>Change Title</button>
        {list.map((subject) => (
          <Item key={subject.name} subject={subject} />
        ))}
        {list.map((subject) => (
          <Item1 key={subject.name} subject={subject} />
        ))}
      </div>
    </div>
  )
}

// 为什么这里的Item组件不会重新渲染呢？
// 因为React.memo()对比的是props，而不是state
const Item = React.memo(({ subject }) => {
  console.log("render Item", subject.title)
  return <div>{subject.title}</div>
})

const Item1 = ({ subject }) => {
  console.log("render Item1", subject.title)
  return <div>{subject.title}</div>
}

export default Demo2
