import axios from 'axios';

export default {
    retrieveProperties() {
        return axios.get('/properties')
    },
    addProperty(property) {
        return axios.post('/properties', property)
    },
    applyProperty(application) {
        return axios.post('/applications', application)
    },
    retrieveApplications() {
        return axios.get('/applications')
    },
    retrieveApplicationsByOwnerId(ownerId) {
        return axios.get('/applications/' + ownerId)
    },
    retrievePropertiesByUserId(userId) {
        return axios.get('/properties/' + userId)
    },
    getPropertiesForUser(userId) {
        return axios.get('/userProperties/' + userId)
    },
    updateApplicationStatus(propertyId, application) {
        return axios.put("/changeApplicationStatus/" + propertyId, application)

    },
    removeProperty(propertyId) {
        return axios.delete("/properties/" + propertyId)
    }
}