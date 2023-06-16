import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import ReportService from "../../services/ReportService";
import Report from "./Report";

const ReportList = () => {
  const navigate = useNavigate();

  const [loading, setLoading] = useState(true);
  const [reports, setReports] = useState([]);

  const fetchData = async () => {
    setLoading(true);
    try {
      const response = await ReportService.getReports();
      setReports(response.data.data); 
    } catch (error) {
      console.log(error);
    }
    setLoading(false);
  };
  useEffect(() => {
   
    fetchData();
  }, []);

  const deleteReport = async (e, id) => {
    e.preventDefault();
   await ReportService.deleteReport(id).then((res) => {
      if (reports) {
        setReports((prevElement) => {
          return prevElement.filter((Report) => Report.id !== id);
        });
       
      }
    });
    fetchData();
  };

  return (
    <div className="container mx-10 my-10">
      <div className="h-12">
        <div
          className="rounded bg-slate-600 text-white px-6 py-2 font-semibold">
          Reports
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
                Patient Name
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Patient LastName
              </th> 
                <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Patient Identification Number
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Laborant Name
              </th>
             
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                File Number
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Disease Name
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Disease Details
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Report Date
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Rontgen
              </th>
              <th className="text-right font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Actions
              </th>
            </tr>
          </thead>
          {!loading && (
            <tbody className="bg-white">
              {reports.length !==0 ? reports?.map((report,i) => (
                <Report
                  key={i}
                  report={report}
                  deleteReport={deleteReport}
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

export default ReportList;