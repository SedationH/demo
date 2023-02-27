import React, { useCallback, useState } from "react"
import { Button, Table } from "antd"
import type { ColumnsType } from "antd/lib/table"
import { Tabs, TabsProps } from "antd"

interface DataType {
  key: React.Key
  name: string
  age: number
  address: string
}

const columns: ColumnsType<DataType> = [
  {
    title: "Name",
    dataIndex: "name",
    width: 150,
  },
  {
    title: "Age",
    dataIndex: "age",
    width: 150,
  },
  {
    title: "Address",
    dataIndex: "address",
  },
]

const data: DataType[] = []
for (let i = 0; i < 100; i++) {
  data.push({
    key: i,
    name: `Edward King ${i}`,
    age: 32,
    address: `London, Park Lane no. ${i}`,
  })
}

const onChange = (key: string) => {
  console.log(key)
}

function P1() {
  const [offsetHeader, setOffsetHeader] = useState(0)
  const measuredRef = useCallback((node: any) => {
    if (node !== null) {
      const { top } = node.getBoundingClientRect()
      setOffsetHeader(top - 62 - 1)
    }
  }, [])

  const items: TabsProps["items"] = [
    {
      key: "1",
      label: `Tab 1`,
      children: `Content of Tab Pane 1`,
    },
    {
      key: "2",
      label: `Tab 2`,
      children: `Content of Tab Pane 2`,
    },
    {
      key: "3",
      label: `Tab 3`,
      children: (
        <div
          style={{
            overflow: "auto",
            maxHeight: "calc(100vh - 600px)",
            border: "1px solid blue",
          }}
          id="con"
        >
          <div
            style={{
              position: "sticky",
              top: 0,
              zIndex: 1,
              background: "white",
            }}
          >
            <h1>这是标题</h1>
            <h2>2</h2>
          </div>
          <Table
            ref={measuredRef}
            columns={columns}
            dataSource={data}
            pagination={{
              pageSize: 100,
            }}
            sticky={{
              offsetHeader,
            }}
          />
        </div>
      ),
    },
  ]

  return (
    <div>
      <Tabs defaultActiveKey="3" items={items} onChange={onChange} />
    </div>
  )
}

export default P1
