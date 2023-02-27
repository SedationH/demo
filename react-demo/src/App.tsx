import { Suspense, useMemo } from "react"
import { Link, useRoutes } from "react-router-dom"
import { generateFlattenPath } from "./utils/route"

import routes from "~react-pages"

const App = () => {
  const flattenedRoutes = useMemo(() => generateFlattenPath(routes), [routes])
  return (
    <Suspense fallback={<p>Loading...</p>}>
      {
        <>
          <nav>
            {flattenedRoutes.map((path) => (
              <>
                <Link key={path} to={path}>
                  {path}
                </Link>
                <br />
              </>
            ))}
          </nav>
          {useRoutes(routes)}
        </>
      }
    </Suspense>
  )
}

export default App
