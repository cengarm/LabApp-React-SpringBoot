import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import ReportServicee from "../../services/ReportService";

const UpdateReport = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [report, setReport] = useState({
    id: "",
    hospitalId: "",
    name: "",
    lastName: "",
  });

  const handleChange = (e) => {
    const value = e.target.value;
    setReport({ ...report, [e.target.name]: value });
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await ReportServicee.getReportById(report.id);
        setReport(response.data);
      } catch (error) {
        console.log(error);
      }
    };
    fetchData();
  }, []);

  const updateReport = (e) => {
    e.preventDefault();
    console.log(report);
    ReportServicee.updateReport(report.id)
      .then((response) => {
        navigate("/");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="flex max-w-2xl mx-auto shadow border-b">
      <div className="px-8 py-8">
        <div className="font-thin text-2xl tracking-wider">
          <h1>Update Report</h1>
          </div>
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-600 text-sm font-normal">
            Report Id
          </label>
          <input
            type="text"
            name="id"
            value={report.reportid}
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
            onClick={updateReport}
            className="rounded text-white font-semibold bg-green-400 hover:bg-green-700 py-2 px-6">
            Update
          </button>
          <button
            onClick={() => navigate("/reportList")}
            className="rounded text-white font-semibold bg-red-400 hover:bg-red-700 py-2 px-6">
            Cancel
          </button>
        </div>
      </div>
    </div>
  );
};

export default UpdateReport;