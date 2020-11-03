<template>
  <span class="noselect clipboard" @click="copy">
    <slot></slot>
    <i class="iconfont iconjiandao3"></i>
  </span>
</template>

<script>
  export default {
    name: "ClipBoard",
    data: () => ({
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
      copy(){
        let placement = 'topRight';
        this.$copyText(this.copyContent).then((e)=>{
          this.$notification['success']({
            message: `Copy finished`,
            description: e.text,
            placement
          });
        }, (e)=>{
          console.log('Can not copy')
        })
      }
    },
    computed: {
      copyContent() {
        return this.content;
      }
    }
  }
</script>

<style lang="scss" scoped>
.clipboard{
  padding: 5px;
  border: 1px dashed #7f828b;
}
/*.clipboard i{
  position: relative;
  top: -13px;
  right: -10px;
}*/
</style>
