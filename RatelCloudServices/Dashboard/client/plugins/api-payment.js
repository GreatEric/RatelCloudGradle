export default function ({ $http }, inject) {
  const apiPayment = {
    async stripeSetupIntent(data) {
      return await $http.$post('/api-payment/stripe/intentSetup',data)
    },
    async stripeSaveCard(data){
      return await $http.$post('/api-payment/stripe/saveCard',data)
    },
    async stripePay(data) {
      return await $http.$post('/api-payment/stripe/stripePay',data)
    },
    async stripeCallBack(callback) {
      return await $http.$get(callback)
    },
    async pageTransactions(params) {
      try {
        return await $http.$post('/api-payment/transaction/pageAll',params);
      } catch(e){
        console.log(e);
      }
    },
    async generateQrCode(params) {
      try {
        return await $http.$post('/api-payment/superior/generateQrCode',params);
      } catch(e){
        console.log(e);
      }
    },
    async superiorCallBack(callback) {
      try {
        return await $http.$get(callback);
      } catch(e){
        console.log(e);
      }
    }
  }
  inject('apiPayment', apiPayment)
}
