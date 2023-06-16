import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import PatientService from "../../services/PatientService";
import Patient from "./Patient";
import SearchBar from "../SearchBar";

const PatientList = () => {
  const navigate = useNavigate();
  

  const handleSearch = (searchText) => {
    const filtered = patients.filter(
      (patient) =>
        patient.firstName.toLowerCase().includes(searchText.toLowerCase()) ||
        patient.lastName.toLowerCase().includes(searchText.toLowerCase())
    );
    setFilteredPatients(filtered);
  };

  const [loading, setLoading] = useState(true);
  const [patients, setPatients] = useState([]);
  const [filteredPatients, setFilteredPatients] = useState([]);

  const fetchData = async () => {
    setLoading(true);
    try {
      const response = await PatientService.getPatients();
      setPatients(response.data.data); //
    } catch (error) {
      console.log(error);
    }
    setLoading(false);
  };
  useEffect(() => {
   
    fetchData();
  }, []);

  const deletePatient = async (e, id) => {
    e.preventDefault();
   await PatientService.deletePatient(id).then((res) => {
      if (patients) {
        setPatients((prevElement) => {
          return prevElement.filter((Patient) => Patient.id !== id);
        });
      }
    });
    fetchData();
  };

  return (
 
    <div className="container mx-10 my-8">
          <div>
          <SearchBar onSearch={handleSearch} />
            <ul>
              {filteredPatients.map((patient) => (
              <li key={patient.id}>{`${patient.firstName} ${patient.lastName}`}</li>
              ))}
           </ul>
      </div>
      <div className="h-12">
        <div
          className="rounded bg-slate-600 text-white px-6 py-2 font-semibold">
         Patients
        </div>
      </div>
      <div className="flex shadow border-b">
        <table className="min-w-full">
          <thead className="bg-gray-50">
            <tr>
            <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Id
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
               Identification Number
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                First Name
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Last Name
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Complaint Name
              </th>
              <th className="text-right font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Actions
              </th>
            </tr>
          </thead>
          {!loading && (
            <tbody className="bg-white">
              {patients.length !==0 ? patients?.map((patient,i) => (
                <Patient
                  key={i}
                  patient={patient}
                  deletePatient={deletePatient}
                  /> 
              )):(
                <></>
              )}
            </tbody>
          )}
        </table>
     
      </div>
    </div>
  );
};

export default PatientList;