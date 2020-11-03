export default function ({ $http }, inject) {
  const apiCode = {
    async testConnection(params) {
      try {
        return await $http.$post('/codegenerate/testConnection', params);
      }catch (e) {
        console.log(e);
      }
    },
    async connect(params) {
      try {
        return await $http.$post('/codegenerate/connectdb', params);
      }catch (e) {
        console.log(e);
      }
    },
    async listConnections() {
      try {
        return await $http.$get('/codegenerate/listDBConnectConfig');
      }catch (e) {
        console.log(e);
      }
    },
    async build(params) {
      try {
        return await $http.$post('/codegenerate/build',params);
      }catch (e) {
        console.log(e);
      }
    }
  }
  inject('apiCode', apiCode)
}
