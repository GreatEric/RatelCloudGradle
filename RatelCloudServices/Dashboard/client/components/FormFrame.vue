<template>
  <a-drawer
    :title="frameTitle"
    :width="drawerWidth"
    :visible="visible"
    :body-style="{ paddingBottom: `${bodyPadding}ps` }"
    @close="close">
    <span class="drawerLabel" :style="{right: drawerWidth+'px'}" v-if="visible" @dblclick="fullWidth"></span>
    <a-row>

      <slot name="form"></slot>

      <a-row type="flex" justify="end" align="middle">
        <a-col>
          <a-button :style="{ marginRight: '8px' }" @click="cancel">
            Cancel
          </a-button>
          <a-button type="primary" @click="submit">
            Submit
          </a-button>
        </a-col>
      </a-row>
    </a-row>
  </a-drawer>
</template>

<script>
  export default {
    name: "FormFrame",
    props: {
      title: String,
      width: Number,
      padding: Number,
      submitCallback: Function
    },
    data() {
      return {
        originalWith: 420,
        paramWith: this.width,
        isfullWidth: false,
        visible: false
      }
    },
    created(){
    },
    destroyed(){
    },
    mounted(){
      document.onkeydown = (e)=>{
        let key = window.event.keyCode;
        if (key== 83 && event.ctrlKey) {
          window.event.preventDefault();
          console.log("ctrl+s");
        }
      };
    },
    methods:{
      show(){
        this.visible = true
      },
      close(){
        this.visible = false
      },
      submit(){
        this.submitCallback();
      },
      cancel(){
        this.close();
      },
      fullWidth(){
        if (this.isfullWidth) {
          this.paramWith = this.originalWith;
          this.isfullWidth = false;
        } else {
          this.paramWith = document.body.clientWidth - 20;
          this.isfullWidth = true;
        }
      }
    },
    watch: {
      width (v) {
        this.paramWith = v
      }
    },
    computed: {
      frameTitle() {
        return this.title;
      },
      bodyPadding() {
        if(this.padding){
          return this.padding;
        }else{
          return 10;
        }
      },
      /*paramWith(){
        return this.width;
        // get(){
        //   return this.width;
        // },
        // set(val){
        //   this.paramWith = val
        // }
      },*/
      drawerWidth() {
        if(this.paramWith){
          return this.paramWith;
        }else{
          return this.originalWith;
        }
      }
    }
  }
</script>

<style lang="scss" scoped>
  .drawerLabel{
    height: 100px;
    width: 20px;
    display: block;
    background-color: rgba(41,42,51,0.6);
    position: fixed;
    z-index: 999999;
    border-top-left-radius: 5px;
    border-bottom-left-radius: 5px;
    box-shadow: -2px 0 8px rgba(0, 0, 0, 0.15);
    cursor: pointer;
  }
</style>
