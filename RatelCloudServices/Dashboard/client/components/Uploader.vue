<template>
  <div>
    <a-upload-dragger
      name="files"
      :multiple="true"
      :remove="handleFileRemove"
      :customRequest="uploadRequest"
      :before-upload="beforeUpload"
      @change="handleChange">
      <p class="ant-upload-drag-icon">
        <a-icon type="inbox" />
      </p>
      <p class="ant-upload-text">
        Click or drag file to this area to upload
      </p>
      <p class="ant-upload-hint">
        Support for a single or bulk upload.
      </p>
    </a-upload-dragger>
  </div>
</template>

<script>
  export default {
    name: "Uploader",
    data: () => ({
      folderPath: "test",
      fileType: "IMAGE",
      bussinessId: 1
    }),
    props: {
      content: String
    },
    created(){
    },
    destroyed(){
    },
    mounted(){

    },
    methods:{
      handleFileRemove(file) {
        const index = this.downloadFiles.indexOf(oss);
        const newFileList = this.downloadFiles.slice();
        newFileList.splice(index, 1);
        this.downloadFiles = newFileList;
      },
      uploadRequest(data){
        this.saveFile(data)
      },
      saveFile (data){
        const formData = new FormData();
        formData.append('bussinessId', this.bussinessId);
        formData.append('file', data.file);
        formData.append("fileType", this.fileType);
        formData.append("folderPath", this.folderPath);

        this.$apiFile.upload(formData).then((result)=>{;
          if(result.data && result.data.code===1000){
            console.log("result:",result.data.data.result);
            this.$nuxt.$emit('uploadSuccess',result.data.data.result);
            this.$notification['success']({
              message: `File upload successfully`,
              description: `Access Url:${result.data.data.result}`,
              placement: 'topRight'
            });
          }else{
            this.$notification['error']({
              message: `File upload failed`,
              description: `Error: ${result.data.msg}`,
              placement: 'topRight'
            });
          }
        });
      },
      handleChange({ fileList }){

      },
      beforeUpload(file) {
        const isJpgOrPng = file.type === 'image/jpeg' || file.type === 'image/png';
        if (!isJpgOrPng) {
          this.$message.error('You can only upload JPG file!');
        }
        const isLt2M = file.size / 1024 / 1024 < 2;
        if (!isLt2M) {
          this.$message.error('Image must smaller than 2MB!');
        }
        return isJpgOrPng && isLt2M;
      }
    },
    computed: {

    }
  }
</script>

<style lang="scss" scoped>

</style>
