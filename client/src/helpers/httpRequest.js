import axios from 'axios';

const baseURLStr = 'https://achiever-spring.herokuapp.com/';

const httpRequest = axios.create({
  baseURL: baseURLStr,
  headers: {
    'Content-Type': 'application/json',
  },
});

export default httpRequest;
