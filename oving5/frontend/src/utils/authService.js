import axios from 'axios'
import routes from '../router/index.js'

export async function getJwtToken(username, password) {
    try {
      const response = await axios.post('http://localhost:8080/token', {
        username,
        password,
      })

      return response.data
    } catch (error) {
      console.error('Error fetching JWT token:', error)
      return null
    }
  }

export async function userDetails(username, token) {
    try {
      const response = await axios.get(`http://localhost:8080/getLogs/${username}`, {
        headers: { Authorization: `Bearer ${token}` },
      })
      return response.data
    } catch (error) {
      if (error.response.status == 403) {
        alert("Session expired, please log in again");
        routes.push({name: 'Login'});
      }
      else {
        console.error("Error fetching logs: ", error);
      }
    }
  }

export async function calculateExpression(username, operations, token) {
    try {
      const response = await axios.post(`http://localhost:8080/calculator/${username}`, {
        operations,
      }, {
        headers: { Authorization: `Bearer ${token}` },
      })
      return response.data
    } catch (error) {
      console.error('Error calculating expression:', error)
      return null
    }
  }
