import React from "react";
import { useNavigate } from "react-router-dom";

  const Laborant = ({ laborant, deleteLaborant }) => {
  const navigate = useNavigate();
  const editLaborant = (e, hospitalid) => {
    e.preventDefault();
    navigate('/editLaborant/${id}');
  };
  

  return (
    <tr >
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{laborant.labId}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{laborant.hospitalid}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{laborant.name}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{laborant.lastName}</div>
      </td>
      <td className="text-right px-6 py-4 whitespace-nowrap font-medium text-sm">
        <a
          onClick={(e, hospitalid) => editLaborant(e, laborant.hospitalid)}
          className="text-indigo-600 hover:text-indigo-800 px-4 hover:cursor-pointer">
          Edit
        </a>
        <a
          onClick={(e, hospitalid) => deleteLaborant(e, laborant.labId)}
          className="text-indigo-600 hover:text-indigo-800 hover:cursor-pointer">
          Delete
        </a>
      </td>
    </tr>
  );
};

export default Laborant;