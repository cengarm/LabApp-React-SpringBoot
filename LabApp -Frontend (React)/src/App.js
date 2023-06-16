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



function App() {
  return (
  <>
  <BrowserRouter>
    <Navbar />
    
    <Routes>
       <Route index element={<LaborantList />}/>
       <Route path="/" element={<LaborantList />} />
       <Route path="/laborantList" element ={<LaborantList />}/>
       <Route path="/addLaborant" element ={<AddLaborant />}/>
       <Route path="/editLaborant/:id" element={<UpdateLaborant />}/>
    </Routes>
    <Routes>
       <Route index element={<ReportList />}/>
       <Route path="/" element={<ReportList />}/>
       <Route path="/reportList" element ={<ReportList />}/>
       <Route path="/addReport" element ={<AddReport />}/>
       <Route path="/editReport/:id" element={<UpdateReport />}/>
    </Routes>
    <Routes>
       <Route index element={<PatientList />}/>
       <Route path="/" element={<PatientList />}/>
       <Route path="/patientList" element ={<PatientList />}/>
       <Route path="/addPatient" element ={<AddPatient />}/>
       <Route path="/editPatient/:id" element={<UpdatePatient />}/>
    </Routes>
  </BrowserRouter>
  </> 
   );
}

export default App;
