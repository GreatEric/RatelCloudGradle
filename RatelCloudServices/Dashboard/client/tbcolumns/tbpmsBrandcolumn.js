const columns = [
    {
      title: 'Id',
      dataIndex: 'id',
      key: 'id',
      scopedSlots: {
        customRender: 'id',
        filterDropdown: 'idfilterDropdown',
        filterIcon: 'filterIcon'
      }
  },
  {
      title: 'NameZh',
      dataIndex: 'nameZh',
      key: 'nameZh',
      scopedSlots: {
        customRender: 'nameZh',
        filterDropdown: 'nameZhfilterDropdown',
        filterIcon: 'filterIcon'
      }
  },
  {
      title: 'NameEn',
      dataIndex: 'nameEn',
      key: 'nameEn',
      scopedSlots: {
        customRender: 'nameEn',
        filterDropdown: 'nameEnfilterDropdown',
        filterIcon: 'filterIcon'
      }
  },
  {
      title: 'Icon',
      dataIndex: 'icon',
      key: 'icon',
      scopedSlots: {
        customRender: 'icon',
        filterDropdown: 'iconfilterDropdown',
        filterIcon: 'filterIcon'
      }
  },
  {
      title: 'Initial',
      dataIndex: 'initial',
      key: 'initial',
      scopedSlots: {
        customRender: 'initial',
        filterDropdown: 'initialfilterDropdown',
        filterIcon: 'filterIcon'
      }
  },
  {
      title: 'Seq',
      dataIndex: 'seq',
      key: 'seq',
      scopedSlots: {
        customRender: 'seq',
        filterDropdown: 'seqfilterDropdown',
        filterIcon: 'filterIcon'
      }
  },
  {
      title: 'CreateTime',
      dataIndex: 'createTime',
      key: 'createTime',
      scopedSlots: {
        customRender: 'createTime',
        filterDropdown: 'createTimefilterDropdown',
        filterIcon: 'filterIcon'
      }
  },
  {
      title: 'ModifyTime',
      dataIndex: 'modifyTime',
      key: 'modifyTime',
      scopedSlots: {
        customRender: 'modifyTime',
        filterDropdown: 'modifyTimefilterDropdown',
        filterIcon: 'filterIcon'
      }
  },
];
export default columns;
