import axios from 'axios';

export default {
    retrievePayments() {
        return axios.get('/payments')
    },
    addPayment(payment) {
        return axios.post('/payments', payment)
    },

    retrievePaymentsByOwnerId(ownerId) {
        return axios.get('/payments/' + ownerId)
    },
}