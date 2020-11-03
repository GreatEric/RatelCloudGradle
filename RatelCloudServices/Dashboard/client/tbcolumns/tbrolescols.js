const columns = [
  {
    title: 'Title',
    dataIndex: 'rname',
    key: 'rname',
  },
  {
    title: 'Remark',
    dataIndex: 'remark',
    key: 'remark',
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
    title: 'Status',
    key: 'status',
    dataIndex: 'status',
    scopedSlots: { customRender: 'status' },
  },
  {
    title: 'Action',
    key: 'action',
    scopedSlots: { customRender: 'action' },
  },
];

export default columns;
