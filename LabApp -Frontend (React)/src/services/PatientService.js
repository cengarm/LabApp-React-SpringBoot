import axios from "axios";

const LABORANT_API_BASE_URL = "http://localhost:8080/api/v1/patients";

class PatientService {
    savePatient(patient) {
        return axios.post(LABORANT_API_BASE_URL, patient);
    }

    getPatients() {
        return axios.get(LABORANT_API_BASE_URL);
    }
    async deletePatient(id) {
        return axios.delete(LABORANT_API_BASE_URL + "/" + id);
    }
    
    getPatientById(id) {
        return axios.get(LABORANT_API_BASE_URL + "/" + id);
    }
    
    updatePatient(patient, id) {
        return axios.put(LABORANT_API_BASE_URL + "/" + id, patient);
    }
}

export default new PatientService();