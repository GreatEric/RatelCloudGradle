<template>
  <div>
    <div :style="{ padding: '24px', background: '#fff', minHeight: '360px' }">
      <a-card title="System Contacts" style="width: 100%" :bordered="false">
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
      title="Create a new Contact"
      :width="720"
      :visible="showAdd"
      :body-style="{ paddingBottom: '80px' }"
      @close="closeAddForm">
      <a-form :form="form" layout="vertical" hide-required-mark>
        <a-row :gutter="16">
          <a-col :span="12">
            <a-form-item label="First Name">
              <a-input v-model="form.firstName" placeholder="enter first name"
              />
            </a-form-item>
          </a-col>
          <a-col :span="12">
            <a-form-item label="Last Name">
              <a-input v-model="form.lastName" placeholder="enter last name"/>
            </a-form-item>
          </a-col>
        </a-row>
        <a-row :gutter="16">
          <a-col :span="12">
            <a-form-item label="Gender">
              <a-radio-group :options="optGenger" v-model="form.gender"/>
            </a-form-item>
          </a-col>
          <a-col :span="12">
            <a-form-item label="Email">
              <a-input v-model="form.email" placeholder="enter email"/>
            </a-form-item>
          </a-col>
        </a-row>
        <a-row :gutter="16">
          <a-col :span="12">
            <a-form-item label="Crown Code">
              <a-select v-model="form.crownCode" placeholder="choose the crown code">
                <a-select-option value="61">
                  +61
                </a-select-option>
                <a-select-option value="86">
                  +86
                </a-select-option>
              </a-select>
            </a-form-item>
          </a-col>
          <a-col :span="12">
            <a-form-item label="Mobile">
              <a-input v-model="form.mobile" placeholder="enter mobile"/>
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
      title="Edit Contact"
      :width="720"
      :visible="showEdit"
      :body-style="{ paddingBottom: '80px' }"
      @close="closeEditForm">
      <a-form :form="editForm" layout="vertical" hide-required-mark>
        <a-row :gutter="16">
          <a-col :span="12">
            <a-form-item label="First Name">
              <a-input v-model="editForm.firstName" placeholder="enter first name"
              />
            </a-form-item>
          </a-col>
          <a-col :span="12">
            <a-form-item label="Last Name">
              <a-input v-model="editForm.lastName" placeholder="enter last name"/>
            </a-form-item>
          </a-col>
        </a-row>
        <a-row :gutter="16">
          <a-col :span="12">
            <a-form-item label="Gender">
              <a-radio-group :options="optGenger" v-model="editForm.gender"/>
            </a-form-item>
          </a-col>
          <a-col :span="12">
            <a-form-item label="Email">
              <a-input v-model="editForm.email" placeholder="enter email"/>
            </a-form-item>
          </a-col>
        </a-row>
        <a-row :gutter="16">
          <a-col :span="12">
            <a-form-item label="Crown Code">
              <a-select v-model="editForm.crownCode" placeholder="choose the crown code">
                <a-select-option value="61">
                  +61
                </a-select-option>
                <a-select-option value="86">
                  +86
                </a-select-option>
              </a-select>
            </a-form-item>
          </a-col>
          <a-col :span="12">
            <a-form-item label="Mobile">
              <a-input v-model="editForm.mobile" placeholder="enter mobile"/>
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
import columns from "../../tbcolumns/tbcontactscols";
import pagination from "../../commons/pagination";
import opt_gender from "../../commons/options-gender";
export default {
  components: {},
  layout: 'dashboard1',
  data: () => ({
    tbdata:[],
    tbcolumns: columns,
    pagination: pagination,
    form: {
      gender:"1",
      firstName:"",
      lastName:"",
      avatar:"",
      email:"",
      mobile:"",
      crownCode:""
    },
    showAdd: false,
    showEdit: false,
    editForm:{},
    optGenger: opt_gender
  }),
  props: {
  },
  created(){
  },
  destroyed(){
  },
  mounted(){
    this.listAllContacts();
  },
  methods:{
    login() {
      const credentials = {
        email: "admin@domain.com",
        password: "admin"
      }
      this.$apiUser.login(credentials).then((result)=>{
        console.log("登录结果:",result);
      })
    },
    add() {
      this.$apiUser.addContact(this.form).then((result)=>{
        if(result.code===1000){
          this.showAdd = false;
          this.listAllContacts();
        }
      });
    },
    edit(){
      delete this.editForm.createTime;
      delete this.editForm.updateTime;
      delete this.editForm.status;
      this.editForm.id = this.editForm.key;
      this.$apiUser.editContact(this.editForm).then((result)=>{
        if(result.code===1000){
          this.showEdit = false;
          this.listAllContacts();
        }
      });
    },
    disable(id){
      this.$apiUser.disableContact(id).then((result)=>{
        if(result.code===1000){
          this.listAllContacts();
        }
      });
      console.log("失效:",id);
    },
    enable(id){
      this.$apiUser.enableContact(id).then((result)=>{
        if(result.code===1000){
          this.listAllContacts();
        }
      });
      console.log("失效:",id);
    },
    editRow(record){
      this.editForm = record;
      this.showEdit = true;
    },
    listAllContacts(){
      const params = {
        pageNum: 1,
        pageSize: this.pagination.pageSize
      }
      this.$apiUser.listAllContacts(params).then((result)=>{
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
    showAddForm() {
      this.showAdd = true;
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
