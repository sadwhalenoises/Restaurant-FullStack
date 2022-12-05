
import "bootstrap/dist/css/bootstrap.min.css"
import "./styles/styles.css";
import { BrowserRouter, Routes, Route } from "react-router-dom"
import Auth from "./js/Auth"
import User from "./js/User";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Auth />} />
        <Route path="/user" element={<User />} />
      </Routes>
    </BrowserRouter>
  )
}


export default App