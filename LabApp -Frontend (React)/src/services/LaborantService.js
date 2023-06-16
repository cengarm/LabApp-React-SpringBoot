import axios from "axios";

const LABORANT_API_BASE_URL = "http://localhost:8080/api/v1/laborants";

class LaborantService {
    saveLaborant(laborant) {
        return axios.post(LABORANT_API_BASE_URL, laborant);
    }

    getLaborants() {
        return axios.get(LABORANT_API_BASE_URL);
    }
    async deleteLaborant(id) {
        return axios.delete(LABORANT_API_BASE_URL + "/" + id);
    }
    
    getLaborantById(id) {
        return axios.get(LABORANT_API_BASE_URL + "/" + id);
    }
    
    updateLaborant(laborant, id) {
        return axios.put(LABORANT_API_BASE_URL + "/" + id, laborant);
    }
}

export default new LaborantService();