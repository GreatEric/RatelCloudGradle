export default function ({ $http }, inject) {
  const apiFile = {
    async upload(formdata){
      try {
        return await $http.post("/fmsOss/upload",formdata);
      } catch(e){
        console.log(e);
      }
    }
  }
  inject('apiFile', apiFile)
}
