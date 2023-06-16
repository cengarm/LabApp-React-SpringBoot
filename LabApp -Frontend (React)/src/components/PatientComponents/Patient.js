import React from "react";
import { useNavigate } from "react-router-dom";

  const Patient = ({ patient, deletePatient }) => {
  const navigate = useNavigate();
  const editPatient = (e, hospitalid) => {
    e.preventDefault();
    navigate('/editPatient/${id}');
  };
  

  return (
    <tr >
        <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{patient.patientId}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{patient.identificationNumber}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{patient.firstName}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{patient.lastName}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{patient.complaintName}</div>
      </td>
      <td className="text-right px-6 py-4 whitespace-nowrap font-medium text-sm">
        <a
          onClick={(e, id) => editPatient(e, patient.patientId)}
          className="text-indigo-600 hover:text-indigo-800 px-4 hover:cursor-pointer">
          Edit
        </a>
        <a
          onClick={(e, id) => deletePatient(e, patient.patientId)}
          className="text-indigo-600 hover:text-indigo-800 hover:cursor-pointer">
          Delete
        </a>
      </td>
    </tr>
  );
};

export default Patient;