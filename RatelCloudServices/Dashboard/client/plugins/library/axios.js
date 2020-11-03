export default function ({ $axios }, inject) {
  //创建axios实例
  const http = $axios.create({
    timeout: 1000,
    headers: {
      common: {
        'Accept': 'text/plain, */*',
        'Access-Control-Allow-Origin': '*'
      }
    },
    withCredentials: true
  })
  //设置基地址
  http.setBaseURL(process.env.baseUrl)
  // Change URL only for client
  if (process.client) {
    http.setBaseURL('http://localhost:19080')
  }
  // Change URL only for server
  if (process.server) {
    http.setBaseURL('http://localhost:19080')
  }
  /*
   * 设置请求头
   * Overrides `Authorization` header with new value
   **/
  http.setHeader('Authorization', '123')
  /*
   * 设置请求头
   * Adds header: `Content-Type: application/x-www-form-urlencoded` to only post requests
   **/
  http.setHeader('Content-Type', 'application/x-www-form-urlencoded', [
    'post'
  ])
  /*
   * 设置请求头
   * Removes default Content-Type header from `post` scope
   **/
  http.setHeader('Content-Type', false, ['post'])

  /*
   * 请求拦截
   **/
  http.onRequest(config => {
    /*console.log('Request to ' + config.baseURL);
    console.log('Request to ' + config.url);*/
  })
  /*
   * 响应拦截
   **/
  http.onResponse(response => {
    /*console.log('Response ' + response);*/
  })
  /*
   * 错误拦截
   **/
  http.onError(error => {
    const code = parseInt(error.response && error.response.status)
    if (code === 400) {
      console.log('Request error ' + error)
    }
  })

  //将$http注入到context对象
  inject('http', http)
}
