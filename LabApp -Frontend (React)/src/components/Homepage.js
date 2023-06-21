import React from 'react';
import { FaGithub, FaLinkedin } from 'react-icons/fa';

function HomePage() {
  return (
   
    <div  className=' centered-textt background-image' > 
        <div><h1 style={{ fontSize:85 }} className= 'text-gray-800 font-semibold centered-text ' >
            Lab System'e Hoşgeldiniz!</h1>  
             <div><p style={{ fontSize:45 }} className=' text-gray-800 font-semibold centered-text'>
                Bu uygulamada Patient,Report ve Laborant ekleme, silme, güncelleme işlemlerini hızlıca yapabilirsizin. </p>  
                <div className="social-icons">
                    <a href="https://github.com/cengarm/LabApp-React-SpringBoot.git" target="_blank" rel="noopener noreferrer">
                     <FaGithub className="icon" />
                    </a>
                    <a href="https://www.linkedin.com/in/mustafa-cengar-738325238/" target="_blank" rel="noopener noreferrer">
                    <FaLinkedin className="icon" />
                    </a>
                </div>
            </div>
        </div>
     </div>
  );
}

export default HomePage;