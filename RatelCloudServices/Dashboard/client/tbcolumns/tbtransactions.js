const columns = [
  // {
  //   title: 'Vendor',
  //   dataIndex: 'vendorCode',
  //   key: 'vendorCode'
  // },
  // {
  //   title: 'Customer',
  //   dataIndex: 'userId',
  //   key: 'userId'
  // },
  {
    title: 'Transaction Id',
    dataIndex: 'transactionId',
    key: 'transactionId',
    scopedSlots: { customRender: 'transactionId' },
  },
  {
    title: 'Order Serial',
    dataIndex: 'orderSerial',
    key: 'orderSerial',
    scopedSlots: { customRender: 'orderSerial' },
  },
  {
    title: 'Currency',
    dataIndex: 'currency',
    key: 'currency',
    scopedSlots: { customRender: 'currency' },
  },
  {
    title: 'Amt',
    dataIndex: 'paymentAmt',
    key: 'paymentAmt',
    scopedSlots: { customRender: 'paymentAmt' },
    //width: 120,
  },
  {
    title: 'Method',
    dataIndex: 'paymentType',
    key: 'paymentType',
    scopedSlots: { customRender: 'paymentType' },
  },
  {
    title: 'Payment Time',
    dataIndex: 'paymentTime',
    key: 'paymentTime',
    scopedSlots: { customRender: 'paymentTime' },
  },
  {
    title: 'Result',
    dataIndex: 'paymentResult',
    key: 'paymentResult',
    scopedSlots: { customRender: 'paymentResult' },
  },
  {
    title: 'Create Time',
    dataIndex: 'createTime',
    key: 'createTime',
    //ellipsis: true
  },
  {
    title: 'Action',
    key: 'action',
    // fixed: 'right',
    // width: 100,
    scopedSlots: { customRender: 'action' },
  },
];

export default columns;
