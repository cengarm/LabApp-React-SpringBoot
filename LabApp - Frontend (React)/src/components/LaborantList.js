import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import LaborantService from '../services/LaborantService';

const LaborantList = () => {
const navigate = useNavigate();

const [loading, setLoading] = useState(true);
const [laborants, setLaborants] = useState(null);

//for laborant list
useEffect(() => {
  const fetchData = async () => {
    setLoading(true);
    try{
      const response = await LaborantService.getLaborants();
      setLaborants(response.data);
    }catch(error) {
      console.log(error)
    }
    setLoading(false);
  };
   fetchData();
}, []);


  return (
    <div className='container mx-auto my-8 mx-5'>
        <div className='h-12'>
          <button 
          //addLaborantta navigate kullanarak hookladık.
          onClick={() =>navigate("/addLaborant")} 
          className='rounded bg-slate-600 text-white px-6 py-2 font-semibold'>
            Add Laborant
            </button>
        </div>
        <div className='flex shadow border-b'>
          <table className='min-w-full'>
            <thead className='bg-gray-50'>
              <tr>
                <th className='text-left font font-medium text-gray-500 uppercase tracking-wider py-3 px-6'>Hospital Id</th>
                <th className='text-left font font-medium text-gray-500 uppercase tracking-wider py-3 px-6'>First Name</th>
                <th className='text-left font font-medium text-gray-500 uppercase tracking-wider py-3 px-6'>Last Name</th>
                <th className='text-right font font-medium text-gray-500 uppercase tracking-wider py-3 px-6'>Actions</th>
              </tr>
            </thead>
            {!loading &&(
            <tbody className='bg-white'>
              {laborants.map((laborants) => (
              <tr>
                <td className='text-letf px-6 py-4 whitespace-nowrap'> 
                <div className='text-sm text-gray-500'>{laborants.hospitalId}</div>
                </td>
                <td className='text-letf px-6 py-4 whitespace-nowrap'> 
                <div className='text-sm text-gray-500'>{laborants.name}</div>
                </td>
                <td className='text-letf px-6 py-4 whitespace-nowrap'> 
                <div className='text-sm text-gray-500'>{laborants.lastName}</div>
                </td>
                <td className='text-right px-6 py-4 whitespace-nowrap font-medium text-sm'>
                  <a href="#" className='text-indigo-600 hover:text-indigo-800 px-4'> Edit</a>
                  <a href="#" className='text-indigo-600 hover:text-indigo-800 '> Delete</a>
                </td>
              </tr>
              ))}
            </tbody>)}
          </table>
        </div>
    </div>
  )    
}

export default LaborantList;