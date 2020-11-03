const columns = [
  {
    title: 'File Name',
    dataIndex: 'fileName',
    key: 'fileName',
    scopedSlots: {
      customRender: 'fileName',
      filterDropdown: 'fileNamefilterDropdown',
      filterIcon: 'fileNamefilterIcon'
    }
  },
  {
    title: 'File Type',
    dataIndex: 'fileType',
    key: 'fileType',
    scopedSlots: {
      customRender: 'fileType',
      filterDropdown: 'fileTypefilterDropdown',
      filterIcon: 'fileTypefilterIcon'
    }
  },
  {
    title: 'File Extension',
    dataIndex: 'fileExtension',
    key: 'fileExtension',
    scopedSlots: {
      customRender: 'fileExtension',
      filterDropdown: 'filterDropdown',
      filterIcon: 'filterIcon'
    }
  },
  {
    title: 'Folder',
    dataIndex: 'folderPath',
    key: 'folderPath',
    scopedSlots: {
      customRender: 'folderPath',
      filterDropdown: 'filterDropdown',
      filterIcon: 'filterIcon'
    }
  },
  {
    title: 'Status',
    dataIndex: 'deleted',
    key: 'deleted',
    scopedSlots: {
      customRender: 'deleted',
      filterDropdown: 'filterDropdown',
      filterIcon: 'filterIcon'
    }
  },
  /*{
    title: 'EndPoint',
    dataIndex: 'endPoint',
    key: 'endPoint',
    scopedSlots: { customRender: 'endPoint' },
  },*/
  {
    title: 'Bucket Name',
    dataIndex: 'bucketName',
    key: 'bucketName',
    scopedSlots: {
      customRender: 'bucketName',
      filterDropdown: 'filterDropdown',
      filterIcon: 'filterIcon'
    }
  },
  {
    title: 'Encrypted',
    dataIndex: 'isEncrypted',
    key: 'isEncrypted',
    scopedSlots: { customRender: 'isEncrypted' },
  },
  {
    title: 'Create Time',
    dataIndex: 'createTime',
    key: 'createTime',
    scopedSlots: {
      customRender: 'createTime',
      filterDropdown: 'createTimeFilterDropdown',
      filterIcon: 'createTimefilterIcon'
    },
  },
  {
    title: 'Preview',
    key: 'preview',
    scopedSlots: { customRender: 'preview' },
  },
  {
    title: 'Action',
    key: 'action',
    scopedSlots: { customRender: 'action' },
  },
];
export default columns;
