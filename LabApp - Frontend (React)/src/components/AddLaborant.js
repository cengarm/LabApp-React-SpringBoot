import React, { useState } from 'react';
import LaborantService from '../services/LaborantService';

const AddLaborant = () => {

    const [laborant, setLaborant] = useState({
        hospitalId: "",
        name: "",
        lastName:"",
    });
    
    const handleChange = (l) => {
        const value = l.target.value;
        setLaborant({...laborant,[l.target.name]: value});

        console.log(value);

    };
      
    
    const saveLaborant = (l) => {
        l.preventDefault();
        LaborantService.saveLaborant(laborant).then((response) => {
                console.log(response)
        } ).catch((error) => {
            console.log(error);
        });
       window.location.reload();
    };

    const reset = (l) => {
        l.preventDefault();
        setLaborant({
          hospitalId: "",
          name: "",
          lastName: "",
        });
      };

  return (
    <div className='flex max-w-2xl mx-auto shadow border-b'>
        <div className='px-8 py-8'>
            <div className='font-thin text-2xl tracking-wider'>
                <h1>Add New Laborant</h1>
            </div>
            <div className='item-center justify-center h-14 w-full my-4'>
                <label className='block text-gray-600 text-sm font-normal'>
                    Hospital Id (7 character)
                    </label>
                <input 
                type= "text"
                name='hospitalId'
                value={laborant.hospitalId}
                onChange={(l) => handleChange(l)}
                className="h-10 w-96 border mt-2 px-2 py-2" ></input>
            </div>
            <div className='item-center justify-center h-14 w-full my-4'>
                <label className='block text-gray-600 text-sm font-normal'>
                    First Name
                    </label>
                <input 
                type= 'text'
                name='name'
                value={laborant.name}
                onChange={(l) => handleChange(l)}
                className='h-10 w-96 border mt-2 px-2 py-2' ></input>
            </div>
            <div className='item-center justify-center h-14 w-full my-4'>
                <label className='block text-gray-600 text-sm font-normal'>
                    Last Name
                    </label>
                <input 
                type= 'text'
                name='lastName'
                value={laborant.lastName}
                onChange={(l) => handleChange(l)}
                className='h-10 w-96 border mt-2 px-2 py-2' ></input>
            </div>

            <div className='item-center justify-center h-14 w-full my-4 space-x-3 pt-4'>
              <button  onClick={saveLaborant} className='rounded text-white font-semibold bg-green-400 hover:bg-green-700 py-2 px-6'>
                Save
                </button>
              <button  onClick={reset}  className='rounded text-white font-semibold bg-red-400 hover:bg-red-700 py-2 px-6'>
                Clear
                </button>
            </div>
        </div>
    </div>
    
  )
}

export default AddLaborant