<template>
  <div>
    <div :style="{ padding: '24px', background: '#fff', minHeight: '360px' }">
      <a-card title="System Roles" style="width: 100%" :bordered="false">
        <a-button-group slot="extra">
          <a-button type="primary" @click="showAddForm"><i class="iconfont iconicon-test2"/>Add </a-button>
          <a-button type="primary" @click="showEditForm"> <i class="iconfont iconicon-test2"/>Edit</a-button>
        </a-button-group>
        <a-table :columns="tbcolumns" :data-source="tbdata" :pagination="pagination">
          <a slot="name" slot-scope="text">{{ text }}</a>
          <span slot="customTitle"><a-icon type="smile-o"/> Name</span>
          <span slot="status" slot-scope="status">
            <a-switch v-model="status"/>
          </span>
          <span slot="action" slot-scope="text, record">
          <a-dropdown-button type="dashed" @click="editRow(record)">
            Edit
            <a-menu slot="overlay">
              <a-popconfirm title="Are you sure？" ok-text="Yes" cancel-text="No" @confirm="disable(record.key)">
                <a-menu-item key="1" style="padding:10px;"> <!--<a-icon type="user" />-->Disable </a-menu-item>
              </a-popconfirm>
              <a-popconfirm title="Are you sure？" ok-text="Yes" cancel-text="No" @confirm="enable(record.key)">
                <a-menu-item key="1" style="padding:10px;"> <!--<a-icon type="user" />-->Enable </a-menu-item>
              </a-popconfirm>
            </a-menu>
          </a-dropdown-button>
        </span>
        </a-table>
      </a-card>
    </div>

    <!--新增表单-->
    <a-drawer
      title="Create a new Role"
      :width="520"
      :visible="showAdd"
      :body-style="{ paddingBottom: '80px' }"
      @close="closeAddForm">
      <a-form :form="form" layout="vertical" hide-required-mark>
        <a-row :gutter="24">
          <a-col :span="24">
            <a-form-item label="Title">
              <a-input v-model="form.rname" placeholder="enter title"
              />
            </a-form-item>
          </a-col>
        </a-row>
        <a-row :gutter="24">
          <a-col :span="24">
            <a-form-item label="Remark">
              <a-textarea
                v-model="form.remark"
                :rows="4"
                placeholder="please enter url description"/>
            </a-form-item>
          </a-col>
        </a-row>
        <a-row :gutter="24">
          <a-col :span="24">
            <a-form-item label="Permissions">
              <a-tree-select
                :multiple="true"
                mode="multiple"
                v-model="form.permList"
                show-search
                style="width: 100%"
                :dropdown-style="{ maxHeight: '400px', overflow: 'auto' }"
                placeholder="Select Role"
                allow-clear
                tree-default-expand-all>
                <a-tree-select-node :value="node.key" :title="node.pname" v-for="(node, index) in permTree" :key="node.key">
                  <a-tree-select-node :value="subnode.key" :title="subnode.pname" v-for="(subnode, subindex) in node.children" :key="subnode.key">
                  </a-tree-select-node>
                </a-tree-select-node>
              </a-tree-select>
            </a-form-item>
          </a-col>
        </a-row>
      </a-form>
      <div class="drawerPanel">
        <a-button :style="{ marginRight: '8px' }" @click="closeAddForm">
          Cancel
        </a-button>
        <a-button type="primary" @click="add">
          Submit
        </a-button>
      </div>
    </a-drawer>

    <!--编辑表单-->
    <a-drawer
      title="Edit Role"
      :width="520"
      :visible="showEdit"
      :body-style="{ paddingBottom: '80px' }"
      @close="closeEditForm">
      <a-form :form="editForm" layout="vertical" hide-required-mark>
        <a-row :gutter="24">
          <a-col :span="24">
            <a-form-item label="Title">
              <a-input v-model="editForm.rname" placeholder="enter title"/>
            </a-form-item>
          </a-col>
        </a-row>
        <a-row :gutter="24">
          <a-col :span="24">
            <a-form-item label="Remark">
              <a-textarea
                v-model="editForm.remark"
                :rows="4"
                placeholder="please enter url description"/>
            </a-form-item>
          </a-col>
        </a-row>
      </a-form>
      <div class="drawerPanel">
        <a-button :style="{ marginRight: '8px' }" @click="closeEditForm">
          Cancel
        </a-button>
        <a-button type="primary" @click="edit">
          Submit
        </a-button>
      </div>
    </a-drawer>
  </div>
</template>

<script>
import columns from "../../tbcolumns/tbrolescols";
import pagination from "../../commons/pagination";
export default {
  components: {},
  layout: 'dashboard1',
  data: () => ({
    tbdata:[],
    tbcolumns: columns,
    pagination: pagination,
    form: {
      rname:"",
      remark:"",
      permList: []
    },
    showAdd: false,
    showEdit: false,
    editForm:{},
    permTree: []
  }),
  props: {
  },
  created(){
  },
  destroyed(){
  },
  mounted(){
    this.listAllRoles();
  },
  methods:{
    add() {
      this.$apiUser.addRole(this.form).then((result)=>{
        if(result.code===1000){
          this.showAdd = false;
          this.listAllRoles();
        }
      });
    },
    edit(){
      delete this.editForm.createTime;
      delete this.editForm.updateTime;
      delete this.editForm.status;
      this.editForm.id = this.editForm.key;
      this.$apiUser.editRole(this.editForm).then((result)=>{
        if(result.code===1000){
          this.showEdit = false;
          this.listAllRoles();
        }
      });
    },
    disable(id){

    },
    enable(id){

    },
    editRow(record){
      this.editForm = record;
      this.showEdit = true;
    },
    listAllRoles(){
      const params = {
        pageNum: 1,
        pageSize: this.pagination.pageSize
      }
      this.$apiUser.listAllRoles(params).then((result)=>{
        if(result.code===1000){
          this.tbdata = result.data.list;
          for(let key in this.tbdata){
            let createTime = this.$moment(this.tbdata[key].createTime).format('YYYY-MM-DD h:mm:ss a');
            let updateTime = this.$moment(this.tbdata[key].updateTime).format('YYYY-MM-DD h:mm:ss a');
            this.tbdata[key].createTime = createTime;
            this.tbdata[key].updateTime = updateTime;
          }
        }
      })
    },
    fetchAllPermsRecursion(){
      this.$apiUser.fetchAllPermsRecursion(0).then((result)=>{
        if(result.code===1000){
          this.permTree = result.data.list;
        }
      })
    },
    showAddForm() {
      this.showAdd = true;
      this.fetchAllPermsRecursion();
    },
    showEditForm() {
      this.showEdit = true;
    },
    closeAddForm() {
      this.showAdd = false;
    },
    closeEditForm(){
      this.showEdit = false;
    }
  },
  computed: {
  }
}
</script>

<style lang="scss" scoped>
.drawerPanel{
  display: flex;
  flex-flow: row;
  justify-content: flex-end;
  align-items: center;
}
</style>
