import { createForm } from "@formily/core"
import { Field, FormProvider } from "@formily/react"
import { Button, Input } from "antd"

const form = createForm()

export default () => {
  form.setInitialValues({ input: "1" })
  return (
    <FormProvider form={form}>
      <Field name="input" component={[Input, { placeholder: "Please Input", height: 100 }]} />

      <Button onClick={() => {}}>提交</Button>
    </FormProvider>
  )
}
