<template>
  <div>
    <TableFrame title="Brand" :width="400" :onAddSubmit="onAddSubmit" :onEditSubmit="onEditSubmit" :onReload="onReload" :onGlobalSearch="onGlobalSearch" :onBatchDelete="onBatchDelete">
      <a-table slot="table" :columns="tbcolumns" :data-source="tbdata" :pagination="pagination"
               :rowKey='record=>record.id'
               :row-selection="{ selectedRowKeys: selectedRowKeys, onChange: onRowSelectChange }"
               @change="onTableChange">

        <span slot="createTime" slot-scope="createTime">
          <span>{{ createTime | timeconvert }}</span>
        </span>
        <span slot="modifyTime" slot-scope="modifyTime">
          <span>{{ modifyTime | timeconvert }}</span>
        </span>
      </a-table>

      <a-row :gutter="24" slot="addForm">
        <a-col :span="24">
          <a-form-model
            hideRequiredMark
            layout="vertical"
            ref="addForm"
            :model="form"
            :rules="rules">

            <a-form-model-item label="Brand name (Zh)" ref="nameZh" prop="nameZh">
              <a-input v-model="form.nameZh"/>
            </a-form-model-item>

            <a-form-model-item label="Brand name (En)" ref="nameEn" prop="nameEn">
              <a-input v-model="form.nameEn"/>
            </a-form-model-item>

            <a-form-model-item label="Icon">
              <input type="hidden" v-model="form.icon">
              <div class="dropbox">
                <Uploader></Uploader>
              </div>
            </a-form-model-item>

            <a-form-model-item label="Seq">
              <a-input v-model="form.seq"/>
            </a-form-model-item>
          </a-form-model>
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
  import columns from "../../tbcolumns/tbpmsBrandcolumn";
  import TableFrame from "../../components/TableFrame";
  import Uploader from "../../components/Uploader";

  export default {
    components: {
      Uploader,
      TableFrame
    },
    layout: 'dashboard1',
    data: () => ({
      tbdata: [],
      tbcolumns: columns,
      pagination: pagination,
      selectedRowKeys: [],
      labelCol: { span: 8 },
      wrapperCol: { span: 16 },
      form: {
        icon: "www.google.com",
        nameEn: "",
        nameZh: "",
        seq: 1
      },
      rules: {
        nameEn: [
          { required: true, message: 'Please input brand name (En)', trigger: 'change' }
        ],
        nameZh: [
          { required: true, message: 'Please input brand name (Zh)', trigger: 'change' }
        ],
        icon: [
          { required: true, message: 'Please upload icon', trigger: 'change' }
        ]
      }
    }),
    props: {},
    created() {
      this.$nuxt.$on('uploadSuccess', (url) => {
        console.log("图片地址:",url);
      })
    },
    destroyed() {
    },
    mounted() {
      this.fetchTBData();
    },
    methods: {
      onTableChange(pagination, filters, sorter) {
        console.log('params', pagination, filters, sorter);
      },
      onRowSelectChange(selectedRowKeys) {
        this.selectedRowKeys = selectedRowKeys;
      },
      /**
       * Description:
       * 获取表格数据
       */
      fetchTBData(){
        let params = {
          pageNum: 1,
          pageSize: this.pagination.pageSize
        }
        this.$apiProduct.pageBrands(params).then((result)=>{
          if(result.data && result.data.code===1000){
            this.tbdata = result.data.data.page.list;
            console.log("result",result.data.data);
          }
        })
      },
      /**
       * Description:
       * 添加品牌
       */
      onAddSubmit(){
        console.log("添加品牌");
        this.$refs.addForm.validate(valid => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      /**
       * Description:
       * 修改品牌
       */
      onEditSubmit(){
        console.log("修改品牌")
      },
      /**
       * Description:
       * 重新加载
       */
      onReload(){
        console.log("重新加载")
      },
      /**
       * Description:
       * 全局搜索
       */
      onGlobalSearch(){
        console.log("全局搜索")
      },
      /**
       * Description:
       * 批量删除
       */
      onBatchDelete(){
        console.log("批量删除")
      },
      normFile(e) {
        console.log('Upload event:', e);
        if (Array.isArray(e)) {
          return e;
        }
        return e && e.fileList;
      },
    },
    computed: {}
  }
</script>

<style lang="scss" scoped>

</style>
