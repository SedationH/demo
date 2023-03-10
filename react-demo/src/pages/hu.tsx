import React, { useState } from "react"

const useDemo = () => {
  const [count, setCount] = React.useState(0)

  const handleCount = () => {
    setCount(count + 1)
  }

  return { count, handleCount }
}

const Demo = () => {
  const [first, setfirst] = useState(0)
  console.log(2)
  return <div onClick={() => setfirst(first + 1)}>{first}</div>
}

function hu() {
  const newLocal = <Demo />
  console.log(1)
  return <div>{newLocal}</div>
}

export default hu
