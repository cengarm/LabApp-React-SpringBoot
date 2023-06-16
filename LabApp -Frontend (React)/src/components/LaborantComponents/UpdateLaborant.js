import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import LaborantServicee from "../../services/LaborantService";

const UpdateLaborant = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [laborant, setLaborant] = useState({
    id: id,
    hospitalId: "",
    name: "",
    lastName: "",
  });

  const handleChange = (e) => {
    const value = e.target.value;
    setLaborant({ ...laborant, [e.target.name]: value });
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await LaborantServicee.getLaborantById(laborant.id);
        setLaborant(response.data);
      } catch (error) {
        console.log(error);
      }
    };
    fetchData();
  }, []);

  const updateLaborant = (e) => {
    e.preventDefault();
    console.log(laborant);
    LaborantServicee.updateLaborant(laborant.id)
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
          <h1>Update Laborant</h1>
        </div>
      
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-600 text-sm font-normal">
            Hospital Id
          </label>
          <input
            type="text"
            name="hospitalId"
            value={laborant.hospitalId}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"></input>
        </div>
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-600 text-sm font-normal">
            First Name
          </label>
          <input
            type="text"
            name="name"
            value={laborant.name}
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
            value={laborant.lastName}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"></input>
        </div>

        <div className="items-center justify-center h-14 w-full my-4 space-x-4 pt-4">
          <button
            onClick={updateLaborant}
            className="rounded text-white font-semibold bg-green-400 hover:bg-green-700 py-2 px-6">
            Update
          </button>
          <button
            onClick={() => navigate("/laborantList")}
            className="rounded text-white font-semibold bg-red-400 hover:bg-red-700 py-2 px-6">
            Cancel
          </button>
        </div>
      </div>
    </div>
  );
};

export default UpdateLaborant;