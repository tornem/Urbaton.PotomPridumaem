import httpRequest from './httpRequest';

const getDataById = {
  methods: {
    async getDataById(api, id) {
      try {
        const response = await httpRequest.get(`${api}/${id}`);
        return response.data.data;
      } catch (err) {
        console.log(err);
        return {};
      }
    },
  },
};

export default getDataById;
