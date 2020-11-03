<template>
  <div>
    <a-row type="flex">
      <a-col flex="auto" class="left">
        <a-form-model layout="inline">
          <a-form-model-item>
            <a-button-group>
              <a-button type="primary" @click="onAddCallback"><i class="iconfont icontianjia"></i></a-button>
              <a-button type="primary" @click="onEditCallback"><i class="iconfont iconbianji1"></i></a-button>
              <a-button type="primary" @click="onDelCallback"><i class="iconfont iconshanchu5"></i></a-button>
            </a-button-group>
          </a-form-model-item>
          <a-form-model-item>
            <a-input-search placeholder="search" enter-button @search="onSearchCallback"/>
          </a-form-model-item>
        </a-form-model>
      </a-col>
      <a-col flex="auto" class="right">
        <a-button-group>
          <a-button type="primary" @click="onFullScreenCallback"><i class="iconfont iconquanping"></i></a-button>
          <a-button type="primary" @click="onScreenShotCallback"><i class="iconfont iconpaizhao1"></i></a-button>
          <a-button type="primary" @click="onReloadCallback"><i class="iconfont iconshuaxin3"></i></a-button>
        </a-button-group>
      </a-col>
    </a-row>
  </div>
</template>

<script>
  export default {
    name: "TableControllPanel",
    props: {
      onAdd: Function,
      onEdit: Function,
      onDel: Function,
      onSearch: Function,
      onFullScreen: Function,
      onScreenShot: Function,
      onReload: Function
    },
    data() {
      return {

      }
    },
    created(){
    },
    destroyed(){
    },
    mounted(){

    },
    methods:{
      onAddCallback(){
        this.onAdd();
      },
      onEditCallback(){
        this.onEdit();
      },
      onDelCallback(){
        this.onDel();
      },
      onSearchCallback(){
        this.onSearch();
      },
      onFullScreenCallback(){
        this.onFullScreen();
      },
      onScreenShotCallback(){
        this.onScreenShot();
      },
      onReloadCallback(){
        this.onReload();
      }
    },
    watch: {

    },
    computed: {

    }
  }
</script>

<style lang="scss" scoped>
.right{
  display: flex;
  flex-flow: row-reverse;
}
</style>
