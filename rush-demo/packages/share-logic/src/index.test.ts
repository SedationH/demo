import { expect, test } from "vitest"
import { sum } from "."

test("should work as expected", () => {
  expect(sum(1, 2, 3)).toBe(1 + 2 + 3)
  expect(sum(1, 2, 4)).toBe(1 + 2 + 4)
})
