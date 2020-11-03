const columns = [
  <#list models as model>
  {
      title: '${model.upperName}',
      dataIndex: '${model.name}',
      key: '${model.name}',
      scopedSlots: {
        customRender: '${model.name}',
        filterDropdown: '${model.name}filterDropdown',
        filterIcon: 'filterIcon'
      }
  },
  </#list>
];
export default columns;
