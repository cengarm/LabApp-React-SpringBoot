import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import ReportService from "../../services/ReportService";

const AddReport = () => {
  const [report, setReport] = useState({
    
    fileNumber: "",
    diseaseName: "",
    diseaseDetails: "",
    photoUrl: "",
  });

  const navigaye = useNavigate();

  const handleChange = (e) => {
    const value = e.target.value;
    setReport({ ...report, [e.target.name]: value });
  };

  const saveReport = (e) => {
    e.preventDefault();
    ReportService.saveReport(report)
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
    setReport({
        
        fileNumber: "",
        diseaseName: "",
        diseaseDetails: "",
        photoUrl: "",
    });
  };

  return (
    <div className="flex max-w-2xl mx-auto shadow border-b">
      <div className="px-8 py-8">
        <div className="font-thin text-2xl tracking-wider">
          <h1>Add New Report</h1>
        </div>
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-600 text-sm font-normal">
            Patient Id
          </label>
          <input
            type="text"
            name="patientId"
            value={report.patientId}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"></input>
        </div>
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-600 text-sm font-normal">
            Laborant Id
          </label>
          <input
            type="text"
            name="laborantId"
            value={report.laborantId}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"></input>
        </div>
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-600 text-sm font-normal">
            File Number
          </label>
          <input
            type="text"
            name="fileNumber"
            value={report.fileNumber}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"></input>
        </div>
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-600 text-sm font-normal">
            Disease Name
          </label>
          <input
            type="text"
            name="diseaseName"
            value={report.diseaseName}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"></input>
        </div>
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-600 text-sm font-normal">
           Disease Details
          </label>
          <input
            type="text"
            name="diseaseDetails"
            value={report.diseaseDetails}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"></input>
        </div>
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-600 text-sm font-normal">
            Photo Url
          </label>
          <input
            type="text"
            name="photoUrl"
            value={report.photoUrl}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"></input>
        </div> 

        <div className="items-center justify-center h-14 w-full my-4 space-x-4 pt-4">
          <button
            onClick={saveReport}
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

export default AddReport;