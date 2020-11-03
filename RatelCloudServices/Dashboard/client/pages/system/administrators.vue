<template>
  <div>
    <div :style="{ padding: '24px', background: '#fff', minHeight: '360px' }">
      <a-card title="System Administrators" style="width: 100%" :bordered="false">
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
      title="Create a new Admin"
      :width="420"
      :visible="showAdd"
      :body-style="{ paddingBottom: '80px' }"
      @close="closeAddForm">
      <a-form :form="form" layout="vertical" hide-required-mark>
        <a-row :gutter="24">
          <a-col :span="24">
            <a-form-item label="Account">
              <a-select
                show-search
                :value="selectedContact"
                placeholder="search contact email"
                style="width: 100%"
                :default-active-first-option="false"
                :show-arrow="false"
                :filter-option="false"
                :not-found-content="null"
                @search="handleSearch"
                @change="handleChange"
                @select="handleSelect">
                <a-select-option v-for="d in data" :key="d.value">
                  {{ d.text }}
                </a-select-option>
              </a-select>
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="Password">
              <a-input-password v-model="form.pwd" placeholder="enter password" />
            </a-form-item>
          </a-col>
        </a-row>
        <a-row :gutter="24">
          <a-col :span="24">
            <a-form-item label="Confirm Password">
              <a-input-password v-model="form.confirmpwd" placeholder="confirm password" />
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="Real Name">
              <a-input v-model="form.realname" placeholder="enter real name"/>
            </a-form-item>
          </a-col>
        </a-row>
        <a-row :gutter="24">
          <a-col :span="24">
            <a-form-item label="Select Roles">
              <a-select
                mode="multiple"
                v-model="form.rolesList"
                style="width: 100%"
                placeholder="Select Roles"
                @change="handleChange">
                <a-select-option v-for="(item,index) in roleslist" :key="item.rid">
                  {{ item.rname }}
                </a-select-option>
              </a-select>
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
      title="Edit Administrator"
      :width="420"
      :visible="showEdit"
      :body-style="{ paddingBottom: '80px' }"
      @close="closeEditForm">
      <a-form :form="editForm" layout="vertical" hide-required-mark>
        <a-row :gutter="24">
          <a-col :span="24">
            <a-form-item label="Acount">
              <a-input v-model="editForm.account" placeholder="enter account"
              />
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="Password">
              <a-input-password v-model="editForm.pwd" placeholder="enter password" />
            </a-form-item>
          </a-col>
        </a-row>
        <a-row :gutter="24">
          <a-col :span="24">
            <a-form-item label="Confirm Password">
              <a-input-password v-model="editForm.confirmpwd" placeholder="confirm password" />
            </a-form-item>
          </a-col>
          <a-col :span="24">
            <a-form-item label="Real Name">
              <a-input v-model="editForm.realname" placeholder="enter real name"/>
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
import columns from "../../tbcolumns/tbadministratorcols";
import pagination from "../../commons/pagination";

export default {
  components: {},
  layout: 'dashboard1',
  data: () => ({
    loadingFinished: false,
    tbdata:[],
    tbcolumns: columns,
    pagination: pagination,
    form: {
      uid:'',
      account:'',
      realname:'',
      pwd:'',
      rolesList:[]
    },
    showAdd: false,
    showEdit: false,
    editForm:{},
    selectedContact:[],
    data: [],
    timeout: 1000,
    currentValue: '',
    roleslist:[]
  }),
  props: {
  },
  created(){
  },
  destroyed(){
  },
  mounted(){
    //this.listAllAdmins();
  },
  methods:{
    add() {
      this.$apiUser.addAdmin(this.form).then((result)=>{
        if(result.code===1000){
          this.showAdd = false;
          this.listAllAdmins();
        }
      });
    },
    edit(){
      delete this.editForm.createTime;
      delete this.editForm.updateTime;
      delete this.editForm.status;
      this.editForm.id = this.editForm.key;
      this.$apiUser.editAdmin(this.editForm).then((result)=>{
        if(result.code===1000){
          this.showEdit = false;
          this.listAllAdmins();
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
    listAllAdmins(){
      const params = {
        pageNum: 1,
        pageSize: this.pagination.pageSize
      }
      this.$apiUser.listAllAdmins(params).then((result)=>{
        if(result.code===1000){
          this.tbdata = result.data.list;
          for(let key in this.tbdata){
            let createTime = this.$moment(this.tbdata[key].createTime).format('YYYY-MM-DD h:mm:ss a');
            let updateTime = this.$moment(this.tbdata[key].updateTime).format('YYYY-MM-DD h:mm:ss a');
            this.tbdata[key].createTime = createTime;
            this.tbdata[key].updateTime = updateTime;
            this.tbdata[key].status = this.tbdata[key].status === 1? true:false;
          }
        }
      })
    },
    fetchAllRoles(){
      this.$apiUser.fetchAllRoles().then((result)=>{
        if(result.code===1000){
          this.roleslist = result.data.list;
        }
      })
    },
    showAddForm() {
      this.showAdd = true;
      this.fetchAllRoles();
    },
    showEditForm() {
      this.showEdit = true;
    },
    closeAddForm() {
      this.showAdd = false;
    },
    closeEditForm(){
      this.showEdit = false;
    },
    fetch(value, callback) {
      if(this.timeout) {
        clearTimeout(this.timeout);
        this.timeout = null;
      }
      this.currentValue = value;

      this.timeout = setTimeout(this.fake, 300);
    },
    fake(){
      this.$apiUser.fetchContactByEmailLike(this.currentValue).then((result)=>{
        if(result.code===1000){
          const data = result.data.list.map(user => ({
            text: `${user.email}`,
            value: user.email,
          }));
          this.data = data;
        }
      });
    },
    handleSearch(value) {
      if(value){
        this.fetch(value, data => (this.data = data));
      }
    },
    handleChange(value) {
      this.value = value;
      this.fetch(value, data => (this.data = data));
    },
    handleSelect(value){
      this.selectedContact.push(value);
      this.form.account = value;
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
