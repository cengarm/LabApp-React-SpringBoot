import React from 'react'
import { useNavigate, Link } from "react-router-dom";


const Navbar = () => {
  const navigate = useNavigate();

  return (
    <div className='bg-gray-800'>
    <div className='h-16 px-8 flex items-center'>
        <p style={{ fontSize: 30 }} className='text-white font-bold'> Lab System</p>
    </div> 
    <div className='h-16 px-8 flex items-center '>
        {/* <p style={{ fontSize: 20 }} className='text-white font-bold'> Search </p>
        <input
          className="rounded bg-white text-black px-5 py-2 w-15 ml-5 font-semibold ">
        </input>
        <Link 
          onClick={() => navigate("/patientList") }
        className="rounded bg-slate-600 hover:bg-slate-950 text-white ml-2 mr-20 px-6 py-2  font-semibold">
          Find
        </Link> */}
        <Link 
          to={"/addLaborant"}
        className="rounded bg-slate-600 hover:bg-slate-950 text-white mx-1 px-5 py-2 font-semibold">
          Add Laborant
        </Link >
        <Link  
          to = {"/LaborantList"}
        className="rounded bg-slate-600 hover:bg-slate-950 text-white mx-1 px-5 py-2 font-semibold">
          Laborant List
        </Link >
        <Link 
         to = "/addReport"
        className="rounded bg-slate-600 hover:bg-slate-950 text-white mx-1 px-5 py-2 font-semibold">
          Add Report
        </Link >
        <Link 
         to ="/ReportList"
        className="rounded bg-slate-600 hover:bg-slate-950 text-white mx-1 px-5 py-2 font-semibold">
          Report List
        </Link>
        <Link 
         to ="/addPatient"
        className="rounded bg-slate-600 hover:bg-slate-950 text-white mx-1 px-5 py-2 font-semibold">
          Add Patient
        </Link>
        <Link 
        to ="/PatientList"
        className="rounded bg-slate-600 hover:bg-slate-950 text-white mx-1 px-5 py-2 font-semibold">
          Patient List
        </Link>
       
        <Link 
        to ="/"
        className="rounded bg-slate-600 hover:bg-slate-950 text-white px-10 py-2 w-15 ml-20 flex font-semibold  ">
          Home Page
          </Link>
       
    </div> 
  </div>
  );
};

export default Navbar