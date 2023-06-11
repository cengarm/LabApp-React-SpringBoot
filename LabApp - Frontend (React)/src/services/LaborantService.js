import axios from "axios";

const LABORANT_API_BASE_URL = "http://localhost:8080/api/laborants/add";

class LaborantService {
    saveLaborant(laborant) {
        return axios.post(LABORANT_API_BASE_URL, laborant)

    }

    getLaborants() {
        return axios.get(LABORANT_API_BASE_URL)
    }
}

export default new LaborantService();