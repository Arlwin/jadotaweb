import axios from 'axios'

const client = axios.create({
    baseURL: "https://127.0.0.1/api/v1"
});

console.log(process.env.PORT);

export default client