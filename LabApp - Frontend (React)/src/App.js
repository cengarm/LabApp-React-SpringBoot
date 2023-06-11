import {BrowserRouter, Route, Routes} from 'react-router-dom'
import './App.css';
import AddLaborant from './components/AddLaborant';
import Navbar from './components/Navbar';
import LaborantList from "./components/LaborantList";

function App() {
  return (
  <>
  {/* herzaman router navbarı göstericek */}
  <BrowserRouter>
    <Navbar /> 
    <Routes>
       <Route index element={<LaborantList />}></Route>
       <Route path="/" element={<LaborantList />} ></Route>
       <Route path="/laborantList" element ={<LaborantList />}></Route>
       <Route path="/addLaborant" element ={<AddLaborant />}></Route>
    </Routes>
    {/* <LaborantList />
    <AddLaborant /> */}
  </BrowserRouter>
   
   </> )
}

export default App;
