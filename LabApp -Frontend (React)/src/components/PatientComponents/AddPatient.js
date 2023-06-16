import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import PatientService from "../../services/PatientService";

const AddPatient = () => {
  const [patient, setPatient] = useState({
    id: "",
    identificationNumber: "",
    firstName: "",
    lastName: "",
    complaintName: "",
  });

  const navigaye = useNavigate();

  const handleChange = (e) => {
    const value = e.target.value;
    setPatient({ ...patient, [e.target.name]: value });
  };

  const savePatient = (e) => {
    e.preventDefault();
    PatientService.savePatient(patient)
      .then((response) => {
        console.log(response);
        navigaye("/");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const reset = (e) => {
    e.preventDefault();
    setPatient({
        id: "",
        identificationNumber: "",
        firstName: "",
        lastName: "",
        complaintName: "",
    });
  };

  return (
    <div className="flex max-w-2xl mx-auto shadow border-b">
      <div className="px-8 py-8">
        <div className="font-thin text-2xl tracking-wider">
          <h1>Add New Patient</h1>
        </div>
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-600 text-sm font-normal">
          Identification Number
          </label>
          <input
            type="text"
            name="identificationNumber"
            value={patient.identificationNumber}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"></input>
        </div>
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-600 text-sm font-normal">
            First Name
          </label>
          <input
            type="text"
            name="firstName"
            value={patient.firstName}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"></input>
        </div>
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-600 text-sm font-normal">
            Last Name
          </label>
          <input
            type="text"
            name="lastName"
            value={patient.lastName}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"></input>
        </div>
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-600 text-sm font-normal">
          Complaint Name
          </label>
          <input
            type="text"
            name="complaintName"
            value={patient.complaintName}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"></input>
        </div>

        <div className="items-center justify-center h-14 w-full my-4 space-x-4 pt-4">
          <button
            onClick={savePatient}
            className="rounded text-white font-semibold bg-green-400 hover:bg-green-700 py-2 px-6">
            Save
          </button>
          <button
            onClick={reset}
            className="rounded text-white font-semibold bg-red-400 hover:bg-red-700 py-2 px-6">
            Clear
          </button>
        </div>
      </div>
    </div>
  );
};

export default AddPatient;