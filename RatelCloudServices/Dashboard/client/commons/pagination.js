const pagination = {
  pageSize: 10,
  total:0,
  showSizeChanger: true,
  pageSizeOptions: ['10', '20', '30', '40'],
  showTotal: total => `Total ${total} items`,
  showSizeChange: (current, pageSize) => this.pageSize = pageSize,
};
export default pagination;
