export default {
  //nuxt源码位置
  srcDir: 'client/',
  //渲染模式: 'spa'->单页应用模式;'universal'->服务器端渲染模式
  mode: 'universal',
  //发布类型: 'server'->服务器端渲染; 'static'->静态网站
  target: 'server',
  env: {
    baseUrl: process.env.BASE_URL || 'http://localhost:7000',
    usingMock: false
  },
  //head
  head: {
    title: process.env.npm_package_name || '',
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: process.env.npm_package_description || '' }
    ],
    script: [

    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' },
      { rel: "stylesheet", href: "https://fonts.googleapis.com/css2?family=Poppins:wght@100&display=swap" },
      { rel: "stylesheet", href: "https://at.alicdn.com/t/font_1571233_h13oqtoruas.css"}
    ]
  },
  loading: false,
  //全局css样式
  css: [
    /*{
      src: '@/assets/theme/theme.less',
      lang: 'less'
      }
    }*/
    /*'ant-design-vue/dist/antd.css',*/
    '@/assets/theme/main.less',
    '@/assets/scss/icons.scss',
    'quill/dist/quill.snow.css',
    'quill/dist/quill.bubble.css',
    'quill/dist/quill.core.css'
  ],
  styleResources: {
    /*less: ['@/assets/theme/theme.less']*/
    scss: ['@/assets/scss/global.scss']
  },
  //自动导入components
  components: true,
  //Nuxt.js dev-modules
  buildModules: [

  ],
  //Nuxt.js 模块
  modules: [
    '@nuxtjs/style-resources',
    '@nuxtjs/axios',
    '@nuxtjs/moment'
  ],
  //挂载app之前需要加载的插件
  plugins: [
    '@/plugins/library/antd-ui',
    {src:'@/plugins/library/loading',ssr:false},
    /*http请求插件*/
    {src:'@/plugins/library/axios',ssr:false},
    /*时间处理插件*/
    {src:'@/plugins/library/moment-timezone-inject',ssr:false},
    /*剪切板插件*/
    {src:'@/plugins/library/vue-clipboard2-inject',ssr:false},
    /*html截图插件*/
    {src:'@/plugins/library/html-toimg-inject',ssr:false},
    /*下载插件*/
    {src:'@/plugins/library/download-inject',ssr:false},
    /*截图插件*/
    {src:'@/plugins/library/cropper-inject',ssr:false},
    /*quill富文本编辑器插件*/
    {src:"@/plugins/library/vue-quill-editor-inject",ssr:false },
    /*全屏插件*/
    {src:"@/plugins/library/vue-fullscreen-inject",ssr:false },
    /*script异步导入插件*/
    {src:'@/plugins/library/vue-script2',ssr:false},
    /*自定义filter插件*/
    {src:'@/plugins/utils/filters',ssr:false},
    /*自定义工具插件*/
    {src:'@/plugins/utils/utils-inject',ssr:false},
    /*api*/
    {src:'@/plugins/api/code/code',ssr:false},
    {src:'@/plugins/api/product/product',ssr:false},
    {src:'@/plugins/api/file/file',ssr:false},
    '@/plugins/api-user',
    '@/plugins/api-payment'
  ],
  router: {
    middleware: 'routing'
  },
  publicRuntimeConfig: {},
  privateRuntimeConfig: {},
  //Build配置
  build: {
    extend(config, ctx) {},
    loaders: {
      less: {
        lessOptions: {
          javascriptEnabled: true
          /*modifyVars: {
            'primary-color': 'rgba(222, 12, 101, 1.0)',
            'component-background': '#ffffff'
          }*/
        }
      }
    }
  }
}
