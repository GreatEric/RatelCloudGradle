<template>
  <a-card :bordered="false" class="container">
    <a-steps :current="current">
      <a-step v-for="item in steps" :key="item.title" :title="item.title">
        <i class="iconfont icondatabase-add2" slot="icon" v-if="item.index===0"></i>
      </a-step>
    </a-steps>
    <div class="steps-content">
      <a-row v-if="steps[current].index == 0" type="flex" justify="start" align="top" class="dbConnectFormWrapper">

        <a-col :span="3">
          <a-list size="small" bordered :data-source="connections" class="connList">
            <a-list-item slot="renderItem" slot-scope="item, index">
              <span class="listItem" @click="selectConn(item)">{{ item.schemaName }}</span>
            </a-list-item>
            <div slot="header">
              Connections
            </div>
          </a-list>
        </a-col>

        <a-col :span="21">
          <a-card bordered class="dbConnectForm">
            <a-form :label-col="{ span: 5 }" :wrapper-col="{ span: 6 }">
              <a-form-item label="Configration Name">
                <a-input placeholder="Configration Name" v-model="dbConnForm.configName"/>
              </a-form-item>
              <a-form-item label="Database">
                <a-select
                  default-value="1"
                  v-model="dbConnForm.dbType"
                  placeholder="Select Database"
                  @change="handleDBChange">
                  <a-select-option value="1">
                    Mysql
                  </a-select-option>
                  <a-select-option value="2">
                    Oracle
                  </a-select-option>
                  <a-select-option value="3">
                    PostgreSQL
                  </a-select-option>
                </a-select>
              </a-form-item>
              <a-form-item label="Host Name">
                <a-input placeholder="127.0.0.1" v-model="dbConnForm.hostName"/>
              </a-form-item>
              <a-form-item label="Port">
                <a-input placeholder="3306" v-model="dbConnForm.port"/>
              </a-form-item>
              <a-form-item label="User Name">
                <a-input placeholder="User Name" v-model="dbConnForm.userName"/>
              </a-form-item>
              <a-form-item label="Password">
                <a-input-password placeholder="Password" v-model="dbConnForm.pwd"/>
              </a-form-item>
              <a-form-item label="Schema">
                <a-input placeholder="Schema (database name)" v-model="dbConnForm.schemaName"/>
              </a-form-item>
              <a-form-item label="Save Configration">
                <a-switch default-checked v-model="dbConnForm.saveConfig"/>
              </a-form-item>
              <a-form-item :wrapper-col="{ span: 12, offset: 5 }">
                <a-button type="primary" html-type="submit" style="margin-right: 20px;" @click="testConnection">
                  Test Connection
                </a-button>
                <a-button type="primary" html-type="submit" @click="connect">
                  Connect
                </a-button>
              </a-form-item>
            </a-form>
          </a-card>
        </a-col>
      </a-row>

      <a-row v-if="steps[current].index == 1 ">

        <a-col :span="24" class="btnPanel">
          <a-button type="primary" @click="goNext">next</a-button>
        </a-col>

        <a-col :span="8">
          <a-transfer
            :data-source="tables"
            :target-keys="targetKeys"
            :render="renderItem"
            @change="handleChange"
            :list-style="{
              width: '250px',
              height: '610px'
            }"/>
        </a-col>

        <a-col :span="16">
          <a-card bordered class="dbConnectForm">
            <a-row :gutter="[8,8]" v-for="(item,index) in datasList" :key="index">
              <a-col :span="24"><h3 class="uppercase">{{ item.tbName }}</h3></a-col>
              <a-col :span="24">
                <a-table :pagination="false" :columns="columns" :data-source="item.data">
                  <!--展开区域: start-->
                  <a-row slot="expandedRowRender" slot-scope="record">
                    <a-col :span="24">
                      <h3>字段描述:</h3>
                      <p>{{record.desc}}</p>
                    </a-col>
                  </a-row>
                  <!--展开区域: end-->

                  <span slot="id" slot-scope="id">
                    <a-tag :color="'green'">{{ id | booleanconvert(false,"yes","no") }}</a-tag>
                  </span>
                  <span slot="customTitle"><a-icon type="smile-o" /> Name</span>
                  <span slot="tags" slot-scope="tags">
                    <a-tag
                      v-for="tag in tags"
                      :key="tag"
                      :color="tag === 'loser' ? 'volcano' : tag.length > 5 ? 'geekblue' : 'green'">
                      {{ tag.toUpperCase() }}
                    </a-tag>
                  </span>
                  <span slot="action" slot-scope="text, record">
                    <a>Invite 一 {{ record.name }}</a>
                    <a-divider type="vertical" />
                    <a>Delete</a>
                    <a-divider type="vertical" />
                    <a class="ant-dropdown-link"> More actions <a-icon type="down" /> </a>
                  </span>
                </a-table>
              </a-col>
            </a-row>
          </a-card>
        </a-col>
      </a-row>

      <a-row v-if="steps[current].index == 2 ">
        <a-col :span="6">
          <a-form :label-col="{ span: 20 }" :wrapper-col="{ span: 20 }">
            <a-form-item label="Company">
              <a-input placeholder="Template Path" v-model="buildForm.company"/>
            </a-form-item>

            <a-form-item label="Template Path">
              <a-input placeholder="Template Path" v-model="buildForm.templatePath"/>
            </a-form-item>

            <a-form-item label="Build Path">
              <a-input placeholder="Build Path" v-model="buildForm.buildPath"/>
            </a-form-item>
            <a-form-item label="Package Name">
              <a-input placeholder="Package Name" v-model="buildForm.packageName"/>
            </a-form-item>
            <a-form-item :wrapper-col="{ span: 12, offset: 5 }">
              <a-button type="primary" html-type="submit" style="margin-right: 20px;" @click="submitBuildForm">
                Submit Build
              </a-button>
            </a-form-item>
          </a-form>
        </a-col>
        <a-col :span="18">
          <a-tabs default-active-key="1" tab-position="top">
            <a-tab-pane key="1" tab="POJO">
              Content of Tab 1
            </a-tab-pane>
            <a-tab-pane key="2" tab="Mapper">
              Content of Tab 2
            </a-tab-pane>
            <a-tab-pane key="3" tab="Mapper XML">
              Content of Tab 3
            </a-tab-pane>
            <a-tab-pane key="4" tab="Service">
              Content of Tab 4
            </a-tab-pane>
            <a-tab-pane key="5" tab="Service Impl">
              Content of Tab 5
            </a-tab-pane>
            <a-tab-pane key="6" tab="Controller">
              Content of Tab 6
            </a-tab-pane>
            <a-tab-pane key="7" tab="Vue Template">
            </a-tab-pane>
          </a-tabs>
        </a-col>
      </a-row>
    </div>
    <!--<div class="steps-action">
      <a-button v-if="current < steps.length - 1" type="primary" @click="next">
        Next
      </a-button>
      <a-button
        v-if="current == steps.length - 1"
        type="primary"
        @click="$message.success('Processing complete!')">
        Done
      </a-button>
      <a-button v-if="current > 0" style="margin-left: 8px" @click="prev">
        Previous
      </a-button>
    </div>-->
  </a-card>
</template>

<script>
import columns from "../../tbcolumns/tbcode";

export default {
  components: {

  },
  layout: 'dashboard1',
  data() {
    return {
      current: 0,
      steps: [
        {
          title: 'DB Connection',
          index: 0,
        },
        {
          title: 'Second',
          index: 1,
        },
        {
          title: 'Last',
          index: 2,
        },
      ],
      formLayout: 'horizontal',
      connections: [],
      dbConnForm: {
        "configName":"",
        "dbType": 1,
        "hostName": "",
        "port": 3306,
        "userName": "",
        "pwd":"",
        "schemaName":"",
        "saveConfig": true
      },
      dbTableList:[],
      tables:[],
      targetKeys: [],
      selectedDBTables: [],
      columns: columns,
      datasList: [],
      buildForm: {
        company: "RatelCloud",
        templatePath: "/home/eric/Templates/template",
        buildPath: "/home/eric/Temp/Build",
        packageName: "com.ratel",
        buildTables: {}
      }
    };
  },
  props: {},
  created() {
  },
  destroyed() {
  },
  mounted() {
    this.listAllConnections();
    //this.getMock();
  },
  methods: {
    next() {
      this.current++;
    },
    goNext(){
      this.current++;
    },
    prev() {
      this.current--;
    },
    handleSubmit(e) {
      e.preventDefault();
    },
    handleDBChange(value) {
      console.log(value);
    },
    testConnection(){
      this.$apiCode.testConnection(this.dbConnForm).then((result)=>{
        if(result.code === 1000){
          this.$notification['success']({
            message: 'Connection Success',
            description: result.data.result,
          });
        }
      });
    },
    connect(){
      this.$apiCode.connect(this.dbConnForm).then((result)=>{
        if(result.code === 1000){
          this.current++;
          this.dbTableList = result.data.list;
          this.createList(this.dbTableList);
        }
      });
    },
    listAllConnections(){
      this.$apiCode.listConnections().then((result)=>{
        if(result.code === 1000){
          this.connections = result.data.list;
        }
      });
    },
    selectConn(item){
      this.dbConnForm = item;
    },
    createList(data){
      const listData = [];
      for(let key in data){
        let item = data[key];
        let d = {
          key: item.TableName,
          title: item.TableName,
          description: item.TableName,
          chosen: false
        }
        listData.push(d);
      }
      this.tables = listData;
    },
    renderItem(item) {
      const customLabel = (
        <span class="custom-item">
          {item.title}
        </span>
      );

      return {
        label: customLabel,
        value: item.title,
      };
    },
    handleChange(targetKeys, direction, moveKeys) {
      this.targetKeys = targetKeys;

      this.targetKeys.forEach((v, i) => {
        let found = this.filterByTbName(this.dbTableList, v);
        if(this.selectedDBTables.indexOf(found[0]) <= -1){
          this.selectedDBTables.push(found[0]);
          let dbItem = {
            tbName: v,
            data: found[0].models
          }
          this.datasList.push(dbItem);
        }
      });
    },
    filterByTbName(aim, name) {
      return aim.filter(item => item.TableName == name)
    },
    submitBuildForm(){
      this.buildForm.buildTables = this.selectedDBTables;
      this.$apiCode.build(this.buildForm).then((result)=>{
        if(result.code === 1000){
          console.log("result",result)
        }
      });
    }
  },
  computed: {}
}
</script>

<style lang="scss" scoped>
.container{
  min-height: 80vh;
  .iconfont{
    font-size: 20px;
    display: block;
  }
  .dbConnectFormWrapper{
    height: 70vh;
    padding-top: 40px;
  }
  .connList{
    height: 65vh;
    max-height: 65vh;
    margin-right: 15px;
  }
  .dbConnectForm{
    height: 65vh;
    max-height: 65vh;
    overflow-y: scroll;
  }
  .dbConnectForm::-webkit-scrollbar-track {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.1) !important;
    border-radius: 0px !important;
    background-color: #F5F5F5 !important;
  }
  .dbConnectForm::-webkit-scrollbar {
    width: 0px !important;
    background-color: #F5F5F5 !important;
  }
  .dbConnectForm::-webkit-scrollbar-thumb {
    border-radius: 0px !important;
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.1) !important;
    background-color: #F5F5F5 !important;
  }
  .dbConnectForm::-webkit-scrollbar-thumb:hover {background-color:rgba(19,21,26,0.5) !important;}
  .dbConnectForm::-webkit-scrollbar-thumb:active {background-color:rgba(19,21,26,0.5) !important;}

  .listItem{
    width: 100%;
    cursor: pointer;
  }
  .btnPanel{
    display: flex;
    align-items: center;
    justify-content: flex-end;
    padding-top: 20px;
    padding-bottom: 20px;
  }
}
</style>
