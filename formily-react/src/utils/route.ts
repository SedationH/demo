import { RouteObject } from "react-router-dom"

/**
 * 处理 routes 存在 children 的元素
 * 拼接 path，拉成一层
 */
export const generateFlattenPath = (routes: RouteObject[]) => {
  const res: string[] = []

  const dfs = (currentRoutes: RouteObject[], basePath = "") => {
    currentRoutes.forEach((route) => {
      const path = `${basePath}/${route.path}`
      if (route.children) {
        dfs(route.children, `${basePath}/${route.path}`)
      } else {
        res.push(path)
      }
    })
  }

  dfs(routes)

  return res
}
