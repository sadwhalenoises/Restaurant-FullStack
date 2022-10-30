
import "bootstrap/dist/css/bootstrap.min.css"
import "./styles/styles.css";
import { BrowserRouter, Routes, Route } from "react-router-dom"
import Auth from "./js/Auth"

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/auth" element={<Auth />} />
      </Routes>
    </BrowserRouter>
  )
}


export default App