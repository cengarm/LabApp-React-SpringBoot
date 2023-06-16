import axios from "axios";

const REPORT_API_BASE_URL = "http://localhost:8080/api/v1/reports";

class ReportService {
    saveReport(report) {
        return axios.post(REPORT_API_BASE_URL, report);
    }

    getReports() {
        return axios.get(REPORT_API_BASE_URL);
    }
    async deleteReport(id) {
        return axios.delete(REPORT_API_BASE_URL + "/" + id);
    }
    
    getReportById(id) {
        return axios.get(REPORT_API_BASE_URL + "/" + id);
    }
    
    updateReports(report, id) {
        return axios.put(REPORT_API_BASE_URL + "/" + id, report);
    }
}

export default new ReportService();