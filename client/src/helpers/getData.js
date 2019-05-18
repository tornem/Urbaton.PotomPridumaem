import httpRequest from './httpRequest';

const getData = {
  methods: {
    async getData(api) {
      try {
        const response = await httpRequest.get(`${api}`);
        return response.data.data;
      } catch (err) {
        console.log(err);
        return [];
      }
    },
  },
};

export default getData;
