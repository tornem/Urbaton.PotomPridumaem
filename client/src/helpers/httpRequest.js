import axios from 'axios';

const baseURLStr = '';
const token = '';

const httpRequest = axios.create({
  baseURL: baseURLStr,
  headers: {
    'Content-Type': 'application/json',
    Authorization: token || '',
  },
});

export default httpRequest;
