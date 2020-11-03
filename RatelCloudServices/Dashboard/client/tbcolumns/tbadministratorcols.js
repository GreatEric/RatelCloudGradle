const columns = [
  {
    title: 'Name',
    dataIndex: 'realname',
    key: 'realname',
  },
  {
    title: 'Accout',
    dataIndex: 'account',
    key: 'account',
  },
  {
    title: 'Role',
    dataIndex: 'role',
    key: 'role',
  },
  {
    title: 'Last login time',
    dataIndex: 'lastLoginTime',
    key: 'lastLoginTime',
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
