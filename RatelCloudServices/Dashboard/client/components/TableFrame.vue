<template>
  <client-only>
    <fullscreen ref="fullscreen" @change="fullscreenChange" class="fullScreen">
      <a-card :bordered="false" ref="tableFrame">
        <TableControllPanel slot="title"
                            :onAdd="onAdd"
                            :onEdit="onEdit"
                            :onDel="onBatchDelete"
                            :onSearch="onGlobalSearch"
                            :onFullScreen="onFullScreen"
                            :onScreenShot="onScreenShot"
                            :onReload="onReload">
        </TableControllPanel>

        <div ref="screenShot">
          <slot name="table"></slot>
        </div>

        <FormFrame :title="'Add '+frameTitle" v-bind:width="frameWidth" :submitCallback="onAddSubmit" ref="addForm">
          <div slot="form">
            <slot name="addForm"></slot>
          </div>
        </FormFrame>


        <FormFrame :title="'Edit '+frameTitle" v-bind:width="frameWidth" :submitCallback="onEditSubmit" ref="editForm">
          <div slot="form">
            <slot name="editForm"></slot>
          </div>
        </FormFrame>

      </a-card>
    </fullscreen>
  </client-only>
</template>

<script>

  export default {
    name: "TableFrame",
    components: {

    },
    props: {
      title: String,
      width: Number,
      onAddSubmit: Function,
      onEditSubmit: Function,
      onReload: Function,
      onGlobalSearch: Function,
      onBatchDelete: Function
    },
    data() {
      return {
        fullscreen: false
      }
    },
    created(){
    },
    destroyed(){
    },
    mounted(){

    },
    methods:{
      onAdd(){
        this.$refs.addForm.show();
      },
      onEdit(){
        this.$refs.editForm.show();
      },
      onFullScreen(){
        this.$refs['fullscreen'].toggle()
      },
      onScreenShot(){
        let node = this.$refs.screenShot;

        this.$htmlToImage.toPng(node).then((dataUrl)=>{
          this.$download(dataUrl, this.frameTitle+'.png');
        }).catch((error)=>{
          console.error('oops, something went wrong!', error);
        });
      },
      fullscreenChange (fullscreen) {
        this.fullscreen = fullscreen
      }
    },
    watch: {

    },
    computed: {
      frameTitle() {
        return this.title;
      },
      frameWidth() {
        return this.width;
      }
    }
  }
</script>

<style lang="scss" scoped>
.right{
  display: flex;
  flex-flow: row-reverse;
}
.fullscreen{
  background-color: #f7f8fb !important;
}
.fullScreen::-webkit-scrollbar-track {
  -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.1) !important;
  border-radius: 0px !important;
  background-color: #F5F5F5 !important;
}
.fullScreen::-webkit-scrollbar {
  width: 3px !important;
  background-color: #F5F5F5 !important;
}
.fullScreen::-webkit-scrollbar-thumb {
  border-radius: 0px !important;
  -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.1) !important;
  background-color: #F5F5F5 !important;
}
.fullScreen::-webkit-scrollbar-thumb:hover {background-color:rgba(19,21,26,0.5) !important;}
.fullScreen::-webkit-scrollbar-thumb:active {background-color:rgba(19,21,26,0.5) !important;}
</style>
