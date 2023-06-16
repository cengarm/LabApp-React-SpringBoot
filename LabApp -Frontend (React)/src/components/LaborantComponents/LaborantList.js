import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import LaborantService from "../../services/LaborantService";
import Laborant from "./Laborant";
import SearchBar from "../SearchBar";

const LaborantList = () => {
  const navigate = useNavigate();

  const handleSearch = (searchText) => {
    const filtered = laborants.filter(
      (laborant) =>
        laborant.name.toLowerCase().includes(searchText.toLowerCase()) ||
        laborant.lastName.toLowerCase().includes(searchText.toLowerCase())
    );
    setFilteredLaborants(filtered);
  };

  const [loading, setLoading] = useState(true);
  const [laborants, setLaborants] = useState([]);
  const [filteredLaborants, setFilteredLaborants] = useState([]);

  const fetchData = async () => {
    setLoading(true);
    try {
      const response = await LaborantService.getLaborants();
      setLaborants(response.data.data); //
    } catch (error) {
      console.log(error);
    }
    setLoading(false);
  };
  useEffect(() => {
   
    fetchData();
  }, []);

  const deleteLaborant = async (e, id) => {
    e.preventDefault();
   await LaborantService.deleteLaborant(id).then((res) => {
      if (laborants) {
        setLaborants((prevElement) => {
          return prevElement.filter((Laborant) => Laborant.id !== id);
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
              {filteredLaborants.map((laborant) => (
              <li key={laborant.labId}>{`${laborant.name} ${laborant.lastName}`}</li>
              ))}
           </ul>
      </div>
      <div className="h-12">
        <div
          className="rounded bg-slate-600 text-white px-6 py-2 font-semibold">
         Laborants
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
                Hospital Id
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                First Name
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Last Name
              </th>
              <th className="text-right font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Actions
              </th>
            </tr>
          </thead>
          {!loading && (
            <tbody className="bg-white">
              {laborants.length !==0 ? laborants?.map((laborant,i) => (
                <Laborant
                  key={i}
                  laborant={laborant}
                  deleteLaborant={deleteLaborant}
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

export default LaborantList;