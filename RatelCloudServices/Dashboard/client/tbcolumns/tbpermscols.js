const columns = [
  {
    title: 'Title',
    dataIndex: 'pname',
    key: 'pname',
  },
  {
    title: 'Route Path',
    dataIndex: 'proutePath',
    key: 'proutePath',
  },
  {
    title: 'Access Points',
    dataIndex: 'apiAccessPoint',
    key: 'apiAccessPoint',
  },
  {
    title: 'Display Icon',
    dataIndex: 'picon',
    key: 'picon',
  },
  {
    title: 'Status',
    key: 'status',
    dataIndex: 'status',
    scopedSlots: { customRender: 'status' },
  },
  {
    title: 'Create Time',
    dataIndex: 'createTime',
    key: 'createTime',
  },
  {
    title: 'Update Time',
    dataIndex: 'updateTime',
    key: 'updateTime',
  },
  {
    title: 'Action',
    key: 'action',
    scopedSlots: { customRender: 'action' },
  },
];

export default columns;
