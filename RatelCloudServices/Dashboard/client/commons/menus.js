const menus = [
  {
    key: '1',
    title: 'Dashboard',
    path: '/dashboard',
    icon:'iconfont icondashboard'
  },
  {
    key: '4',
    title: 'Product',
    path: '',
    icon:'iconfont iconweixindianshangjiaoyi',
    children:[
      {
        key: '4.1',
        title: 'Brand',
        path: '/product/brand',
        icon:'',
      }
    ]
  },
  {
    key: '8',
    title: 'Order',
    path: '',
    icon:'iconfont icondingdan',
    children:[
      {
        key: '8.1',
        title: 'records',
        path: '/oss/oss',
        icon:'',
      }
    ]
  },
  {
    key: '5',
    title: 'Transaction',
    path: '',
    icon:'iconfont iconjiaoyijilu',
    children:[
      {
        key: '5.1',
        title: 'records',
        path: '/oss/oss',
        icon:'',
      }
    ]
  },
  {
    key: '10',
    title: 'Delivery',
    path: '',
    icon:'iconfont iconwuliuxinxi',
    children:[
      {
        key: '10.1',
        title: 'records',
        path: '/oss/oss',
        icon:'',
      }
    ]
  },
  {
    key: '13',
    title: 'Warehouse',
    path: '',
    icon:'iconfont iconcangku_cangchuguanli',
    children:[
      {
        key: '13.1',
        title: 'records',
        path: '/oss/oss',
        icon:'',
      }
    ]
  },
  {
    key: '11',
    title: 'Statement',
    path: '',
    icon:'iconfont icontongji',
    children:[
      {
        key: '11.1',
        title: 'records',
        path: '/oss/oss',
        icon:'',
      }
    ]
  },
  {
    key: '3',
    title: 'Storage',
    path: '',
    icon:'iconfont icontanxingkuaicunchu1',
    children:[
      {
        key: '3.1',
        title: 'storage',
        path: '/oss/oss',
        icon:'',
      }
    ]
  },
  {
    key: '6',
    title: 'Map',
    path: '/dashboard',
    icon:'iconfont iconditu1'
  },
  {
    key: '7',
    title: 'API Docs',
    path: '/code/generator',
    icon:'iconfont iconkuaijierukou_apiwendang'
  },
  {
    key: '2',
    title: 'Code',
    path: '',
    icon:'iconfont icondisplay-code',
    children: [
      {
        key: '2.1',
        title: 'Generator',
        path: '/code/generator',
        icon:''
      },
    ],
  },
  {
    key: '12',
    title: 'Task',
    path: '',
    icon:'iconfont iconfill-task',
    children:[
      {
        key: '12.1',
        title: 'records',
        path: '/oss/oss',
        icon:'',
      }
    ]
  },
  {
    key: '9',
    title: 'Settings',
    path: '',
    icon:'iconfont iconsettings',
    children:[
      {
        key: '9.1',
        title: 'records',
        path: '/oss/oss',
        icon:'',
      }
    ]
  },
];

export default menus;
