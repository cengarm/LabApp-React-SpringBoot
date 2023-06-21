import {BrowserRouter, Route, Routes} from 'react-router-dom'
import './App.css';
import AddLaborant from './components/LaborantComponents/AddLaborant';
import Navbar from './components/Navbar';
import LaborantList from "./components/LaborantComponents/LaborantList";
import UpdateLaborant from './components/LaborantComponents/UpdateLaborant';
import AddReport from './components/ReportComponents/AddReport';
import ReportList from './components/ReportComponents/ReportList';
import UpdateReport from './components/ReportComponents/UpdateReport';
import PatientList from './components/PatientComponents/PatientList';
import AddPatient from './components/PatientComponents/AddPatient';
import UpdatePatient from './components/PatientComponents/UpdatePatient';
import HomePage from './components/Homepage';



function App() {
  return (
  <>
  <BrowserRouter>
    <Navbar />
   
    <Routes>
       <Route path="/laborantList" element ={<LaborantList />}/>
       <Route path="/addLaborant" element ={<AddLaborant />}/>
       <Route path="/editLaborant/:id" element={<UpdateLaborant />}/>
       <Route path="/reportList" element ={<ReportList />}/>
       <Route path="/addReport" element ={<AddReport />}/>
       <Route path="/editReport/:id" element={<UpdateReport />}/>
       <Route path="/patientList" element ={<PatientList />}/>
       <Route path="/addPatient" element ={<AddPatient />}/>
       <Route path="/editPatient/:id" element={<UpdatePatient />}/>
       <Route path="/homePage" element ={<HomePage />}/>
       <Route path="/" element ={<HomePage />}/>
    </Routes>
  </BrowserRouter>
  
  </> 
   );
}

export default App;
