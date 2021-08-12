import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },
  getUserId(username) {
    return axios.get('/users/' + username)
  }
}
