export default function ({ $http }, inject) {
  const apiProduct = {
    async pageBrands(formdata){
      try {
        return await $http.post("/pmsBrand/pageAll",formdata);
      } catch(e){
        console.log(e);
      }
    }
  }
  inject('apiProduct', apiProduct)
}
