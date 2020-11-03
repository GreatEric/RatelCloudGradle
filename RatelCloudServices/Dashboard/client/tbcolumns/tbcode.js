const columns = [
  {
    title: 'Column',
    dataIndex: 'column',
    key: 'column',
    scopedSlots: { customRender: 'column' },
  },
  {
    title: 'Primary?',
    dataIndex: 'id',
    key: 'id',
    scopedSlots: { customRender: 'id' },
  },
  {
    title: 'Auto Increment?',
    dataIndex: 'identity',
    key: 'identity',
    scopedSlots: { customRender: 'identity' },
  },
  {
    title: 'Type',
    dataIndex: 'simpleType',
    key: 'simpleType',
    scopedSlots: { customRender: 'simpleType' },
  },
  {
    title: 'Java Type',
    dataIndex: 'type',
    key: 'type',
    scopedSlots: { customRender: 'type' },
  }
];
export default columns;
