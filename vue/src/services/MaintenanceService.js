import axios from 'axios';

export default {
    retrieveMaintenances() {
        return axios.get('/maintenances')
    },
    addMaintenanceRequest(maintenances) {
        return axios.post('/maintenances', maintenances)
    },
    retrieveMaintenancesByOwnerId(ownerId) {
        return axios.get('/maintenances/' + ownerId)
    },
    updateMaintenanceStatus(maintenanceId, maintenance) {
        return axios.put("/maintenances/" + maintenanceId, maintenance)
    }
}