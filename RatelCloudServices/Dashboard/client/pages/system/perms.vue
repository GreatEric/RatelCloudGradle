<template>
  <div>
    <div :style="{ padding: '24px', background: '#fff', minHeight: '360px' }">
      <a-card title="System Permissions" style="width: 100%" :bordered="false">
        <a-button-group slot="extra">
          <a-button type="primary" @click="showAddForm"><i class="iconfont iconicon-test2"/>Add </a-button>
          <a-button type="primary" @click="showEditForm"> <i class="iconfont iconicon-test2"/>Edit</a-button>
        </a-button-group>
        <a-table :columns="tbcolumns" :data-source="tbdata" :pagination="pagination" :row-selection="rowSelection">
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
                <a-menu-item key="1" style="padding:10px;" @click="shpwAddChild(record.key,record.ptype)"> <!--<a-icon type="user" />-->Add Child </a-menu-item>
              </a-menu>
            </a-dropdown-button>
          </span>
        </a-table>
      </a-card>
    </div>

    <!--新增表单-->
    <a-drawer
      title="Create a new Permission"
      :width="720"
      :visible="showAdd"
      :body-style="{ paddingBottom: '80px' }"
      @close="closeAddForm">
      <a-card
        :bordered="false"
        style="width:100%"
        :tab-list="permstabs"
        :active-tab-key="tabKey"
        @tabChange="key => onTabChange(key, 'tabKey')">
        <p v-if="tabKey === 'api'">
          <a-form :form="apiform" layout="vertical" hide-required-mark>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Title">
                  <a-input v-model="apiform.pname" placeholder="enter title"/>
                </a-form-item>
              </a-col>
              <a-col :span="12">
                <a-form-item label="Parent">
                  <a-tree-select
                    v-model="apiform.pid"
                    show-search
                    style="width: 100%"
                    :dropdown-style="{ maxHeight: '400px', overflow: 'auto' }"
                    placeholder="Please select"
                    allow-clear
                    tree-default-expand-all>
                    <a-tree-select-node key="0-1" value="parent 1" title="parent 1">
                      <a-tree-select-node key="0-1-1" value="parent 1-0" title="parent 1-0">
                        <a-tree-select-node key="random" :selectable="false" value="leaf1" title="my leaf" />
                        <a-tree-select-node key="random1" value="leaf2" title="your leaf" />
                      </a-tree-select-node>
                      <a-tree-select-node key="random2" value="parent 1-1" title="parent 1-1">
                        <a-tree-select-node key="random3" value="sss">
                          <b slot="title" style="color: #08c">sss</b>
                        </a-tree-select-node>
                      </a-tree-select-node>
                    </a-tree-select-node>
                  </a-tree-select>
                </a-form-item>
              </a-col>
            </a-row>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Method">
                  <a-select v-model="apiform.pmethod" placeholder="choose request method">
                    <a-select-option :value="item.value" :key="index" v-for="(item, index) in requesttypes">
                      {{item.label}}
                    </a-select-option>
                  </a-select>
                </a-form-item>
              </a-col>
              <a-col :span="12">
                <a-form-item label="API Accsss Point">
                  <a-input v-model="apiform.paccessPoint" placeholder="enter api access point"/>
                </a-form-item>
              </a-col>
            </a-row>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Permission ID">
                  <a-input v-model="apiform.permid" placeholder="enter permission id"/>
                </a-form-item>
              </a-col>
              <a-col :span="12">
                <a-form-item label="Order">
                  <a-input-number id="inputNumber" v-model="apiform.porder" :min="1" style="width: 100%"/>
                </a-form-item>
              </a-col>
            </a-row>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Status">
                  <a-switch default-checked v-model="statusapi" />
                </a-form-item>
              </a-col>
            </a-row>
          </a-form>
        </p>
        <p v-else-if="tabKey === 'menu'">
          <a-form :form="menuform" layout="vertical" hide-required-mark>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Title">
                  <a-input v-model="menuform.pname" placeholder="enter title"/>
                </a-form-item>
              </a-col>
              <a-col :span="12">
                <a-form-item label="Parent">
                  <a-tree-select
                    v-model="menuform.pid"
                    show-search
                    style="width: 100%"
                    :dropdown-style="{ maxHeight: '400px', overflow: 'auto' }"
                    placeholder="Please select"
                    allow-clear
                    tree-default-expand-all>
                    <a-tree-select-node key="0-1" value="parent 1" title="parent 1">
                      <a-tree-select-node key="0-1-1" value="parent 1-0" title="parent 1-0">
                        <a-tree-select-node key="random" :selectable="false" value="leaf1" title="my leaf" />
                        <a-tree-select-node key="random1" value="leaf2" title="your leaf" />
                      </a-tree-select-node>
                      <a-tree-select-node key="random2" value="parent 1-1" title="parent 1-1">
                        <a-tree-select-node key="random3" value="sss">
                          <b slot="title" style="color: #08c">sss</b>
                        </a-tree-select-node>
                      </a-tree-select-node>
                    </a-tree-select-node>
                  </a-tree-select>
                </a-form-item>
              </a-col>
            </a-row>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Route Params">
                  <a-input v-model="menuform.proutePathParams" placeholder="enter route params"/>
                </a-form-item>
              </a-col>
              <a-col :span="12">
                <a-form-item label="Route Path">
                  <a-input v-model="menuform.proutePath" placeholder="enter route path"/>
                </a-form-item>
              </a-col>
            </a-row>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Permission ID">
                  <a-input v-model="menuform.permid" placeholder="enter permission id"/>
                </a-form-item>
              </a-col>
              <a-col :span="12">
                <a-form-item label="Icon">
                  <a-input v-model="menuform.picon" placeholder="enter icon"/>
                </a-form-item>
              </a-col>
            </a-row>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Order">
                  <a-input-number id="inputNumber2" v-model="menuform.porder" :min="1" style="width: 100%"/>
                </a-form-item>
              </a-col>
              <a-col :span="6">
                <a-form-item label="Status">
                  <a-switch default-checked v-model="statusmenu" />
                </a-form-item>
              </a-col>
              <a-col :span="6">
                <a-form-item label="Visibility">
                  <a-switch default-checked v-model="menuvisibility" />
                </a-form-item>
              </a-col>
            </a-row>
          </a-form>
        </p>
      </a-card>

      <div class="drawerPanel">
        <a-button :style="{ marginRight: '8px' }" @click="closeAddForm">
          Cancel
        </a-button>
        <a-button type="primary" @click="add">
          Submit
        </a-button>
      </div>
    </a-drawer>

    <!--添加子权限-->
    <a-drawer
      title="Create a Sub Permission"
      :width="720"
      :visible="showAddSub"
      :body-style="{ paddingBottom: '80px' }"
      @close="closeAddSubForm">
      <a-card
        :bordered="false"
        style="width:100%"
        :tab-list="permstabs"
        :active-tab-key="tabSubKey"
        @tabChange="key => onSubTabChange(key, 'tabSubKey')">
        <p v-if="tabSubKey === 'api'">
          <a-form :form="apiSubform" layout="vertical" hide-required-mark>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Title">
                  <a-input v-model="apiSubform.pname" placeholder="enter title"/>
                </a-form-item>
              </a-col>
              <a-col :span="12">
                <a-form-item label="Parent">
                  <a-input v-model="apiSubform.pid" :disabled="true"/>
                </a-form-item>
              </a-col>
            </a-row>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Method">
                  <a-select v-model="apiSubform.pmethod" placeholder="choose request method">
                    <a-select-option :value="item.value" :key="index" v-for="(item, index) in requesttypes">
                      {{item.label}}
                    </a-select-option>
                  </a-select>
                </a-form-item>
              </a-col>
              <a-col :span="12">
                <a-form-item label="API Accsss Point">
                  <a-input v-model="apiSubform.paccessPoint" placeholder="enter api access point"/>
                </a-form-item>
              </a-col>
            </a-row>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Permission ID">
                  <a-input v-model="apiSubform.permid" placeholder="enter permission id"/>
                </a-form-item>
              </a-col>
              <a-col :span="12">
                <a-form-item label="Order">
                  <a-input-number id="inputNumber5" v-model="apiSubform.porder" :min="1" style="width: 100%"/>
                </a-form-item>
              </a-col>
            </a-row>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Status">
                  <a-switch default-checked v-model="statusapi" />
                </a-form-item>
              </a-col>
            </a-row>
          </a-form>
        </p>
        <p v-else-if="tabSubKey === 'menu'">
          <a-form :form="menuSubform" layout="vertical" hide-required-mark>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Title">
                  <a-input v-model="menuSubform.pname" placeholder="enter title"/>
                </a-form-item>
              </a-col>
              <a-col :span="12">
                <a-form-item label="Parent">
                  <a-input v-model="menuSubform.pid" :disabled="true"/>
                </a-form-item>
              </a-col>
            </a-row>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Route Params">
                  <a-input v-model="menuSubform.proutePathParams" placeholder="enter route params"/>
                </a-form-item>
              </a-col>
              <a-col :span="12">
                <a-form-item label="Route Path">
                  <a-input v-model="menuSubform.proutePath" placeholder="enter route path"/>
                </a-form-item>
              </a-col>
            </a-row>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Permission ID">
                  <a-input v-model="menuSubform.permid" placeholder="enter permission id"/>
                </a-form-item>
              </a-col>
              <a-col :span="12">
                <a-form-item label="Icon">
                  <a-input v-model="menuSubform.picon" placeholder="enter icon"/>
                </a-form-item>
              </a-col>
            </a-row>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Order">
                  <a-input-number id="inputNumber8" v-model="menuSubform.porder" :min="1" style="width: 100%"/>
                </a-form-item>
              </a-col>
              <a-col :span="6">
                <a-form-item label="Status">
                  <a-switch default-checked v-model="statusmenu" />
                </a-form-item>
              </a-col>
              <a-col :span="6">
                <a-form-item label="Visibility">
                  <a-switch default-checked v-model="menuvisibility" />
                </a-form-item>
              </a-col>
            </a-row>
          </a-form>
        </p>
      </a-card>

      <div class="drawerPanel">
        <a-button :style="{ marginRight: '8px' }" @click="closeAddSubForm">
          Cancel
        </a-button>
        <a-button type="primary" @click="addChild">
          Submit
        </a-button>
      </div>
    </a-drawer>

    <!--编辑表单-->
    <a-drawer
      title="Edit Permission"
      :width="520"
      :visible="showEdit"
      :body-style="{ paddingBottom: '80px' }"
      @close="closeEditForm">
      <a-card
        :bordered="false"
        style="width:100%"
        :tab-list="permstabs"
        :active-tab-key="tabKey"
        @tabChange="key => onTabChange(key, 'tabKey')">
        <p v-if="tabKey === 'api'">
          <a-form :form="editApiForm" layout="vertical" hide-required-mark>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Title">
                  <a-input v-model="editApiForm.pname" placeholder="enter title"/>
                </a-form-item>
              </a-col>
              <a-col :span="12">
                <a-form-item label="Parent">
                  <a-tree-select
                    v-model="editApiForm.pid"
                    show-search
                    style="width: 100%"
                    :dropdown-style="{ maxHeight: '400px', overflow: 'auto' }"
                    placeholder="Please select"
                    allow-clear
                    tree-default-expand-all>
                    <a-tree-select-node key="0-1" value="parent 1" title="parent 1">
                      <a-tree-select-node key="0-1-1" value="parent 1-0" title="parent 1-0">
                        <a-tree-select-node key="random" :selectable="false" value="leaf1" title="my leaf" />
                        <a-tree-select-node key="random1" value="leaf2" title="your leaf" />
                      </a-tree-select-node>
                      <a-tree-select-node key="random2" value="parent 1-1" title="parent 1-1">
                        <a-tree-select-node key="random3" value="sss">
                          <b slot="title" style="color: #08c">sss</b>
                        </a-tree-select-node>
                      </a-tree-select-node>
                    </a-tree-select-node>
                  </a-tree-select>
                </a-form-item>
              </a-col>
            </a-row>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Method">
                  <a-select v-model="editApiForm.pmethod" placeholder="choose request method">
                    <a-select-option :value="item.value" :key="index" v-for="(item, index) in requesttypes">
                      {{item.label}}
                    </a-select-option>
                  </a-select>
                </a-form-item>
              </a-col>
              <a-col :span="12">
                <a-form-item label="API Accsss Point">
                  <a-input v-model="editApiForm.paccessPoint" placeholder="enter api access point"/>
                </a-form-item>
              </a-col>
            </a-row>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Permission ID">
                  <a-input v-model="editApiForm.permid" placeholder="enter permission id"/>
                </a-form-item>
              </a-col>
              <a-col :span="12">
                <a-form-item label="Order">
                  <a-input-number id="inputNumber3" v-model="editApiForm.porder" :min="1" style="width: 100%"/>
                </a-form-item>
              </a-col>
            </a-row>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Status">
                  <a-switch default-checked v-model="statusapi" />
                </a-form-item>
              </a-col>
            </a-row>
          </a-form>
        </p>
        <p v-else-if="tabKey === 'menu'">
          <a-form :form="editMenuForm" layout="vertical" hide-required-mark>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Title">
                  <a-input v-model="editMenuForm.pname" placeholder="enter title"/>
                </a-form-item>
              </a-col>
              <a-col :span="12">
                <a-form-item label="Parent">
                  <a-tree-select
                    v-model="editMenuForm.pid"
                    show-search
                    style="width: 100%"
                    :dropdown-style="{ maxHeight: '400px', overflow: 'auto' }"
                    placeholder="Please select"
                    allow-clear
                    tree-default-expand-all>
                    <a-tree-select-node key="0-1" value="parent 1" title="parent 1">
                      <a-tree-select-node key="0-1-1" value="parent 1-0" title="parent 1-0">
                        <a-tree-select-node key="random" :selectable="false" value="leaf1" title="my leaf" />
                        <a-tree-select-node key="random1" value="leaf2" title="your leaf" />
                      </a-tree-select-node>
                      <a-tree-select-node key="random2" value="parent 1-1" title="parent 1-1">
                        <a-tree-select-node key="random3" value="sss">
                          <b slot="title" style="color: #08c">sss</b>
                        </a-tree-select-node>
                      </a-tree-select-node>
                    </a-tree-select-node>
                  </a-tree-select>
                </a-form-item>
              </a-col>
            </a-row>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Route Params">
                  <a-input v-model="editMenuForm.proutePathParams" placeholder="enter route params"/>
                </a-form-item>
              </a-col>
              <a-col :span="12">
                <a-form-item label="Route Path">
                  <a-input v-model="editMenuForm.proutePath" placeholder="enter route path"/>
                </a-form-item>
              </a-col>
            </a-row>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Permission ID">
                  <a-input v-model="editMenuForm.permid" placeholder="enter permission id"/>
                </a-form-item>
              </a-col>
              <a-col :span="12">
                <a-form-item label="Icon">
                  <a-input v-model="editMenuForm.picon" placeholder="enter icon"/>
                </a-form-item>
              </a-col>
            </a-row>
            <a-row :gutter="16">
              <a-col :span="12">
                <a-form-item label="Order">
                  <a-input-number id="inputNumber4" v-model="editMenuForm.porder" :min="1" style="width: 100%"/>
                </a-form-item>
              </a-col>
              <a-col :span="6">
                <a-form-item label="Status">
                  <a-switch default-checked v-model="statusmenu" />
                </a-form-item>
              </a-col>
              <a-col :span="6">
                <a-form-item label="Visibility">
                  <a-switch default-checked v-model="menuvisibility" />
                </a-form-item>
              </a-col>
            </a-row>
          </a-form>
        </p>
      </a-card>

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
import columns from "../../tbcolumns/tbpermscols";
import pagination from "../../commons/pagination";
import requesttypes from "../../commons/requesttypes";
const rowSelection = {
  onChange: (selectedRowKeys, selectedRows) => {
    console.log(`selectedRowKeys: ${selectedRowKeys}`, 'selectedRows: ', selectedRows);
  },
  onSelect: (record, selected, selectedRows) => {
    console.log("选择",selected)
    console.log(record, selected, selectedRows);
  },
  onSelectAll: (selected, selectedRows, changeRows) => {
    console.log(selected, selectedRows, changeRows);
  },
};

export default {
  components: {},
  layout: 'dashboard1',
  data: () => ({
    tbdata:[],
    tbcolumns: columns,
    pagination: pagination,
    rowSelection,
    apiform: {
      pid:0,
      pname:"",
      ptype:0,
      pmethod:"",
      paccessPoint:"",
      permid:"",
      porder:0,
      status:1
    },
    menuform: {
      pid:0,
      pname:"",
      ptype:0,
      proutePath:"",
      proutePathParams:"",
      picon:"",
      permid:"",
      porder:0,
      status:1,
      visibility:1
    },
    apiSubform: {
      pid:0,
      pname:"",
      ptype:0,
      pmethod:"",
      paccessPoint:"",
      permid:"",
      porder:0,
      status:1
    },
    menuSubform: {
      pid:0,
      pname:"",
      ptype:0,
      proutePath:"",
      proutePathParams:"",
      picon:"",
      permid:"",
      porder:0,
      status:1,
      visibility:1
    },
    showAdd: false,
    showAddSub: false,
    showEdit: false,
    editApiForm:{},
    editMenuForm:{},
    requesttypes: requesttypes,
    permstabs: [
      {
        key: 'api',
        tab: 'API',
      },
      {
        key: 'menu',
        tab: 'Menu',
      }
    ],
    tabKey: 'api',
    tabSubKey: 'api',
    type: 2,
    subType: 2,
    statusapi: true,
    statusmenu: true,
    menuvisibility: true,
    treeExpandedKeys: [],
    value: undefined,
  }),
  props: {
  },
  created(){
  },
  destroyed(){
  },
  mounted(){
    this.listAllPerms();
  },
  methods:{
    add() {
      if(this.type ===2){
        this.apiform.ptype=2;
        this.$apiUser.addPerm(this.apiform).then((result)=>{
          if(result.code===1000){
            console.log("result",result);
            this.showAdd = false;
          }
        });
      }else if(this.type ===1){
        this.menuform.ptype=1;
        this.$apiUser.addPerm(this.menuform).then((result)=>{
          if(result.code===1000){
            this.showAdd = false;
          }
        });
      }
    },
    addChild(){
      if(this.type ===2){
        this.apiSubform.ptype=2;
        this.$apiUser.addPerm(this.apiSubform).then((result)=>{
          if(result.code===1000){
            console.log("result",result);
            this.showAddSub = false;
          }
        });
      }else if(this.type ===1){
        this.menuSubform.ptype=1;
        this.$apiUser.addPerm(this.menuSubform).then((result)=>{
          if(result.code===1000){
            this.showAddSub = false;
          }
        });
      }
    },
    edit(){

    },
    disable(id){

    },
    enable(id){

    },
    editRow(record){
      this.editApiForm = {};
      this.editMenuForm = {};

      if(record.ptype ===1){
        this.editMenuForm = record;
      }else if(record.ptype === 2){
        this.editApiForm = record;
      }
      this.showEdit = true;
    },
    listAllPerms(){
      const params = {
        pageNum: 1,
        pageSize: this.pagination.pageSize,
        pid: 0
      }
      this.$apiUser.listAllPermsRecursion(params).then((result)=>{
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
    showAddForm() {
      this.showAdd = true;
    },
    shpwAddChild(key,type){
      this.apiSubform.pid=key;
      if(type === 2){
        this.tabSubKey='api';
      }else if(type ===1){
        this.tabSubKey='menu';
      }
      this.showAddSub = true;
    },
    showEditForm() {
      this.showEdit = true;
    },
    closeAddForm() {
      this.showAdd = false;
    },
    closeAddSubForm(){
      this.showAddSub = false;
    },
    closeEditForm(){
      this.showEdit = false;
    },
    onTabChange(key, type) {
      if(key==='api'){
        this.type = 2
      }else if(key==='menu'){
        this.type = 1;
      }
      this[type] = key;
    },
    onSubTabChange(key, type) {
      if(key==='api'){
        this.subType = 2
      }else if(key==='menu'){
        this.subType = 1;
      }
      this[type] = key;
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
