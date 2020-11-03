<template>
  <div>
    <div>
      <a-card style="width: 100%" :bordered="false">
        <a-row type="flex" slot="title">
          <a-col flex="auto">
            <a-form-model layout="inline">
              <a-form-model-item>
                <a-input-search placeholder="input search text" enter-button @search="onSearch"/>
              </a-form-model-item>
            </a-form-model>
          </a-col>
        </a-row>
        <a-button-group slot="extra">
          <a-button type="primary" @click="showUploadForm"><i class="iconfont iconicon-test2"/>Upload </a-button>
        </a-button-group>

        <a-table :columns="tbcolumns" :data-source="tbdata" :pagination="pagination" :rowKey='record=>record.id'
                 :row-selection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }" @change="onTableChange">

          <!-- filters: start-->
          <a-row slot="fileNamefilterDropdown" slot-scope="{ setSelectedKeys, selectedKeys, confirm, clearFilters, column }">
            <a-col :span="24">
              <a-input-search v-ant-ref="c => (searchInput = c)"
                              :placeholder="`Search ${column.title}`"
                              :value="selectedKeys[0]"
                              enter-button
                              @change="e => setSelectedKeys(e.target.value ? [e.target.value] : [])"
                              @pressEnter="() => handleSearch(selectedKeys, confirm, column.dataIndex)"/>
            </a-col>
          </a-row>
          <a-icon slot="fileNamefilterIcon" slot-scope="filtered" type="search" :style="{ color: filtered ? '#108ee9' : undefined }"/>

          <a-row slot="fileTypefilterDropdown" slot-scope="{ setSelectedKeys, selectedKeys, confirm, clearFilters, column }">
            <a-col :span="24">
              <a-select :placeholder="`Search ${column.title}`" style="width: 150px;">
                <a-select-option :value="item.value" :key="index" v-for="(item, index) in typeEnum">
                  {{item.label}}
                </a-select-option>
              </a-select>
            </a-col>
          </a-row>
          <a-icon slot="fileTypefilterIcon" slot-scope="filtered" type="search" :style="{ color: filtered ? '#108ee9' : undefined }"/>

          <a-row slot="createTimeFilterDropdown" slot-scope="{ setSelectedKeys, selectedKeys, confirm, clearFilters, column }">
            <a-col :span="24">
              <a-range-picker
                :show-time="{ format: 'HH:mm' }"
                format="YYYY-MM-DD HH:mm"
                :placeholder="['Start Time', 'End Time']"
                @change="onChange"
                @ok="onOk"/>
            </a-col>
          </a-row>
          <a-icon slot="createTimefilterIcon" slot-scope="filtered" type="search" :style="{ color: filtered ? '#108ee9' : undefined }"/>
          <!-- filters: end-->

          <!--展开区域: start-->
          <a-row slot="expandedRowRender" slot-scope="record">
            <a-col :span="24">
              <a-descriptions
                title="Details"
                bordered
                layout="vertical">
                <a-descriptions-item label="EndPoint">
                  {{record.endPoint}}
                </a-descriptions-item>
                <a-descriptions-item label="FileName">
                  {{record.fileName}}
                </a-descriptions-item>
                <a-descriptions-item label="BucketName">
                  {{record.bucketName}}
                </a-descriptions-item>
                <a-descriptions-item label="Preview">
                  <a-row>
                    <a-col :span="12">
                      <img class="noselect" :src="`http://${record.url}`"/>
                    </a-col>
                    <a-col :span="2" style="height: 100%;">
                      <div style="display: inline-block;height: 300px;marginLeft: 30px;margin-bottom: 50px;">
                        <a-slider vertical :marks="marks" :default-value="20" reverse @change="onChange" @afterChange="afterChange(record.id)"/>
                      </div>
                      <a-button type="primary" @click="submitZoom" style="display: inline-block;marginLeft: 30px;">
                        Sumit
                      </a-button>
                    </a-col>
                   <!-- <a-col span="1" style="border: 1px solid red;height: 100%;">

                    </a-col>-->
                    <a-col span="10" style="padding:0px 30px 0px 30px;">
                      <div style="display: flex;justify-content: center;align-items: center">
                        <img :style="{width: zoomForm.ratio+'%'}" :src="`http://${record.url}`"/>
                      </div>
                    </a-col>
                  </a-row>
                </a-descriptions-item>
              </a-descriptions>
            </a-col>
          </a-row>
          <!--展开区域: end-->

          <!--字段渲染区域: start-->
          <!--<span slot="fileName" slot-scope="fileName">
            <span @click="copy(fileName)" class="noselect">{{ fileName | filenametruncate(10,'***') }}</span>
          </span>-->
          <span slot="fileName" slot-scope="fileName">
            <ClipBoard :content="fileName">{{ fileName | filenametruncate(10,'***') }}</ClipBoard>
          </span>
          <span slot="fileType" slot-scope="fileType">
            <a-tag :color="'green'" class="uppercase">
              {{ typeEnum.getLabelByValue(fileType) }}
            </a-tag>
          </span>
          <span slot="fileExtension" slot-scope="fileExtension">
            <a-tag :color="'geekblue'">
              {{ fileExtension }}
            </a-tag>
          </span>
          <span slot="deleted" slot-scope="deleted">
            <a-tag :color="'green'">{{ deleted | booleanconvert(true) }}</a-tag>
          </span>
          <span slot="isEncrypted" slot-scope="isEncrypted">
            <a-tag :color="'green'">{{ isEncrypted | booleanconvert(false,"yes","no") }}</a-tag>
          </span>
          <span slot="createTime" slot-scope="createTime">
            <span>{{ createTime | timeconvert }}</span>
          </span>
          <span slot="preview" slot-scope="text, record">
            <img class="preview noselect" :src="`http://${record.url}`" @click="copy(record.url)" />
          </span>
          <!--字段渲染区域: end-->

          <!--操作控件区域: start-->
          <span slot="action" slot-scope="text, record">
            <a-dropdown-button type="dashed" @click="editRow(record)">
              Edit
              <a-menu slot="overlay">
                <a-popconfirm title="Are you sure？" ok-text="Yes" cancel-text="No" @confirm="delObj(record)">
                  <a-menu-item key="1" style="padding:10px;">Delete</a-menu-item>
                </a-popconfirm>
              </a-menu>
            </a-dropdown-button>
          </span>
          <!--操作控件区域: end-->
        </a-table>
      </a-card>
    </div>

    <!--上传表单-->
    <a-drawer
      title="Upload File"
      :width="drawerWidth"
      :visible="showAdd"
      :body-style="{ paddingBottom: '80px' }"
      @close="closeUploadForm">
      <span class="drawerLabel" :style="{right: drawerWidth+'px'}" v-if="showAdd" @dblclick="fullWidth"></span>
      <a-row :gutter="24">
        <a-col :span="24">
          <a-form-item label="Folder Path">
            <a-input v-model="folderPath" placeholder="enter folder path"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-upload
            name="avatar"
            list-type="picture-card"
            class="avatar-uploader"
            :multiple="true"
            :fileList="downloadFiles"
            :remove="handleRemove"
            :customRequest="customRequest"
            :show-upload-list="false"
            :before-upload="beforeUpload"
            @change="handleChange">
            <img v-if="imageUrl" :src="imageUrl" alt="avatar" />
            <div v-else>
              <a-icon :type="loading ? 'loading' : 'plus'" />
              <div class="ant-upload-text">
                Upload
              </div>
            </div>
          </a-upload>
        </a-col>
      </a-row>
    </a-drawer>

    <FormFrame title="FormFrame test" v-bind:width="500" :submitCallback="this.testSubmit" ref="editFrm">
      <a-row :gutter="24">
        <a-col :span="24">
          <a-form-item label="Folder Path">
            <a-input v-model="folderPath" placeholder="enter folder path"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-upload
            name="avatar"
            list-type="picture-card"
            class="avatar-uploader"
            :multiple="true"
            :fileList="downloadFiles"
            :remove="handleRemove"
            :customRequest="customRequest"
            :show-upload-list="false"
            :before-upload="beforeUpload"
            @change="handleChange">
            <img v-if="imageUrl" :src="imageUrl" alt="avatar" />
            <div v-else>
              <a-icon :type="loading ? 'loading' : 'plus'" />
              <div class="ant-upload-text">
                Upload
              </div>
            </div>
          </a-upload>
        </a-col>
      </a-row>
    </FormFrame>
  </div>
</template>

<script>
  import pagination from "../../commons/pagination";
  import columns from "../../tbcolumns/tboss";
  import FileTypeEnum from "../../enums/FileTypeEnum";
  import {
    PreviewResult,
    BoundingBox,
    DraggableArea
  } from 'vue-advanced-cropper';
  import ClipBoard from "../../components/ClipBoard";
  import FormFrame from "../../components/FormFrame";

  export default {
    components: {
      FormFrame,
      ClipBoard,
      PreviewResult,
      BoundingBox,
      DraggableArea
    },
    layout: 'dashboard1',
    data: () => ({
      searchText: '',
      searchInput: null,
      searchedColumn: '',
      tbdata: [],
      tbcolumns: columns,
      pagination: pagination,
      selectedRowKeys: [],
      typeEnum: FileTypeEnum,
      showAdd: false,
      originalWith: 420,
      width: 420,
      isfullWidth: false,
      loading: false,
      imageUrl:"", //require('~/assets/imgs/photo.jpeg'),
      folderPath: "",
      form: null,
      downloadFiles: [],// 已经上传的文件列表
      stencilCoordinates:{},
      marks: {
        20: '20%',
        40: '40%',
        60: '60%',
        80: '80%',
        100: {
          style: {
            color: '#f50',
          },
          label: '100%'
        },
      },
      zoomForm:{
        id: 0,
        ratio: 20
      }
    }),
    props: {
    },
    created(){
    },
    destroyed(){
    },
    mounted(){
      this.pageOss();
    },
    methods:{
      onTableChange(pagination, filters, sorter) {
        console.log('params', pagination, filters, sorter);
      },
      onSelectChange(selectedRowKeys) {
        this.selectedRowKeys = selectedRowKeys;
      },
      copy(orderSerial){
        let placement = 'topRight';
        this.$copyText(orderSerial).then((e)=>{
          this.$notification['success']({
            message: `Copy finished`,
            description: e.text,
            placement
          });
        }, (e)=>{
          console.log('Can not copy')
        })
      },
      showUploadForm() {
        /*this.showAdd = true;*/
        this.$refs.editFrm.show();
      },
      closeUploadForm(){
        this.showAdd = false;
      },
      fullWidth() {
        if (this.isfullWidth) {
          this.width = this.originalWith;
          this.isfullWidth = false;
        } else {
          this.width = document.body.clientWidth - 20;
          this.isfullWidth = true;
        }
      },
      handleRemove(file) {
        const index = this.downloadFiles.indexOf(oss);
        const newFileList = this.downloadFiles.slice();
        newFileList.splice(index, 1);
        this.downloadFiles = newFileList;
      },
      handleChange(info){

      },
      customRequest(data){
        this.saveFile(data)
      },
      saveFile (data){
        const formData = new FormData();
        formData.append('file', data.file);
        formData.append("fileType", '1');
        formData.append("folderPath", this.folderPath);

        this.$apiFile.uploadFile(formData).then((result)=>{
          if(result.code===1000){
            this.pageOss();
          }
        });
      },
      pageOss() {
        const params = {
          pageNum: 1,
          pageSize: this.pagination.pageSize
        }
        this.$apiFile.pageAllOss(params).then((result) => {
          if (result.code === 1000) {
            this.tbdata = result.data.list;
          }
        })
      },
      beforeUpload(file) {
        const isJpgOrPng = oss.type === 'image/jpeg' || oss.type === 'image/png';
        if (!isJpgOrPng) {
          this.$message.error('You can only upload JPG file!');
        }
        const isLt2M = oss.size / 1024 / 1024 < 2;
        if (!isLt2M) {
          this.$message.error('Image must smaller than 2MB!');
        }
        return isJpgOrPng && isLt2M;
      },
      getBase64(img, callback) {
        const reader = new FileReader();
        reader.addEventListener('load', () => callback(reader.result));
        reader.readAsDataURL(img);
      },
      onSearch(value) {
        const params = {
          pageNum: 1,
          pageSize: this.pagination.pageSize,
          fileName: value
        }
        this.$apiFile.pageAllOss(params).then((result) => {
          if (result.code === 1000) {
            this.tbdata = result.data.list;
            console.log(this.tbdata);
          }
        })
        console.log(value);
      },
      delObj(record){
        this.$apiFile.delObj(record.id).then((result) => {
          if (result.code === 1000) {
            console.log("删除结果",result);
          }
        })
      },
      editRow(record){

      },
      onChange(value) {
        this.zoomForm.ratio = value;
        console.log('change: ', this.zoomForm.ratio);

      },
      afterChange(id){
        this.zoomForm.id = id;
        console.log('record: ', this.zoomForm.id);
      },
      submitZoom(){
        this.$apiFile.zoomImg(this.zoomForm.id,this.zoomForm.ratio).then((result) => {
          if (result.code === 1000) {
            console.log("缩放结果",result);
          }
        })
      },
      handleSearch(selectedKeys, confirm, dataIndex) {
        //confirm();
        this.searchText = selectedKeys[0];
        this.searchedColumn = dataIndex;
        console.log("value:",this.searchText);
        console.log("column",this.searchedColumn);
      },
      handleReset(clearFilters) {
        clearFilters();
        this.searchText = '';
      },
      onOk(value) {
        console.log('onOk: ', value);
      },
      testSubmit(){
        console.log("test submit")
      }
    },
    computed: {
      drawerWidth() {
        return this.width;
      },
      style() {
        const { height, width, left, top } = this.stencilCoordinates;
        return {
          position: 'absolute',
          width: `${width}px`,
          height: `${height}px`,
          left: `${left}px`,
          top: `${top}px`
        };
      }
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
  .cropper {
    height: 600px;
    background: #DDD;
  }
  .preview{
    width: 30px;
  }
</style>
