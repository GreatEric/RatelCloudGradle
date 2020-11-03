<template>
  <a-modal :title="dialogTitle"
           :visible="visible"
           @ok="crop"
           @cancel="cancel">
    <template slot="footer">
      <a-button key="back" @click="cancel">
        Cancel
      </a-button>
      <a-button key="submit" type="primary" @click="crop" v-if="imgUrl && imgUrl!=''">
        Crop
      </a-button>
    </template>
    <div>
      <a-row :gutter="24">
        <a-col :span="24" v-if="imgUrl && imgUrl!=''">
          <Cropper ref="cropper" class="upload-example-cropper" :src="imgUrl"/>
        </a-col>
        <a-col :span="24" v-else>
          <a-result status="404" title="404" sub-title="Can't access image,please check!">
          </a-result>
        </a-col>
      </a-row>
    </div>
  </a-modal>
</template>

<script>
  export default {
    name: "ImgCropper",
    data: () => ({
      visible: false,
      folderPath: "test",
      fileType: "IMAGE",
      bussinessId: 1
    }),
    props: {
      title: String,
      img: String,
    },
    created(){
      this.$nuxt.$on('showCropper', () => {
        this.visible = true;
      })
    },
    destroyed(){
    },
    mounted(){

    },
    methods:{
      cancel() {
        this.visible = false;
      },
      crop(){
        const result = this.$refs.cropper.getResult();

        let file = this.dataURLtoFile(result.canvas.toDataURL("image/jpeg"), "avatar.png");

        this.saveFile(file);
      },
      dataURLtoFile(dataurl, filename) {
        var arr = dataurl.split(','),
          mime = arr[0].match(/:(.*?);/)[1],
          bstr = atob(arr[1]),
          n = bstr.length,
          u8arr = new Uint8Array(n);
        while (n--) {
          u8arr[n] = bstr.charCodeAt(n);
        }
        return new File([u8arr], filename, { type: mime });
      },
      saveFile (file){
        const formData = new FormData();
        formData.append('bussinessId', this.bussinessId);
        formData.append('file', file);
        formData.append("fileType", this.fileType);
        formData.append("folderPath", this.folderPath);

        this.$apiFile.upload(formData).then((result)=>{;
          if(result.data && result.data.code===1000){
            this.$nuxt.$emit('cropSuccess',result.data.data.result);
            this.$notification['success']({
              message: `Crop successfully`,
              description: `Access Url:${result.data.data.result}`,
              placement: 'topRight'
            });
            this.visible = false;
          }else{
            this.$notification['error']({
              message: `Crop failed`,
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
      dialogTitle() {
        return this.title;
      },
      imgUrl(){
        return this.img;
      }
    }
  }
</script>

<style lang="scss" scoped>

</style>
