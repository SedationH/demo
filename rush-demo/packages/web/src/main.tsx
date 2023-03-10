import React from 'react'
import ReactDOM from 'react-dom/client'
import { sum } from 'share-logic'
import App from './App'
import './index.css'

console.log(sum())

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
)
