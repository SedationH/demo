import { Field } from "@formily/core"
import React from "react"

// Input UI组件
export default (props: Field) => (
  <input
    {...(props as any)}
    value={props.value || ""}
    style={{
      border: "2px solid rgb(186 203 255)",
      borderRadius: 6,
      width: "100%",
      height: 28,
      padding: "0 5px",
    }}
  />
)
