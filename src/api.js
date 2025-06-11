import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080';

export const getEmployees = () => axios.get(`${API_BASE_URL}/employees`);
export const getEmployee = (id) => axios.get(`${API_BASE_URL}/employees/${id}`);
export const addEmployee = (employee) => axios.post(`${API_BASE_URL}/employees`, employee);
export const updateEmployee = (id, employee) => axios.put(`${API_BASE_URL}/employees/${id}`, employee);
export const deleteEmployee = (id) => axios.delete(`${API_BASE_URL}/employees/${id}`);
