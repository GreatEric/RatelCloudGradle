<template>
  <div>
    <TableFrame title="generator">
      <a-table slot="table" :columns="tbcolumns" :data-source="tbdata" :pagination="pagination"
               :rowKey='record=>record.id'
               :row-selection="{ selectedRowKeys: selectedRowKeys, onChange: onRowSelectChange }"
               @change="onTableChange">
      </a-table>

      <a-row :gutter="24" slot="addForm">
        <a-col :span="24">

        </a-col>
        <a-col :span="24">

        </a-col>
      </a-row>

      <a-row :gutter="24" slot="editForm">
        <a-col :span="24">

        </a-col>
        <a-col :span="24">
          
        </a-col>
      </a-row>
    </TableFrame>
  </div>
</template>

<script>
  import pagination from "../../commons/pagination";
  import columns from "../../tbcolumns/tboss";
  import TableFrame from "../../components/TableFrame";

  export default {
    components: {
      TableFrame
    },
    layout: 'dashboard1',
    data: () => ({
      tbdata: [],
      tbcolumns: columns,
      pagination: pagination,
      selectedRowKeys: []
    }),
    props: {},
    created() {
    },
    destroyed() {
    },
    mounted() {

    },
    methods: {
      onTableChange(pagination, filters, sorter) {
        console.log('params', pagination, filters, sorter);
      },
      onRowSelectChange(selectedRowKeys) {
        this.selectedRowKeys = selectedRowKeys;
      }
    },
    computed: {}
  }
</script>

<style lang="scss" scoped>

</style>
