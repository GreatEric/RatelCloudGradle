<template>
  <a-card hoverable class="container">
    <div class="cover" slot="cover" :style="{backgroundImage:'url('+cover+')'}">
      <div class="left">
        <h1>Welcome!</h1>
        <span>Cheryleric0828@gmail.com <i class="iconfont iconbianji"></i></span>
        <a-button class="btn">WebSite Settings <i class="iconfont iconbianji"></i></a-button>
      </div>
    </div>
    <a-card-meta title="Europe Street beat">
      <template slot="description">
        www.instagram.com
      </template>
    </a-card-meta>
  </a-card>
</template>

<script>
export default {
  components: {
  },
  layout: 'dashboard1',
  data: () => ({
    cover: require('~/assets/imgs/bg/19.jpg'),
  }),
  props: {
  },
  created(){
  },
  destroyed(){
  },
  mounted(){

  },
  methods:{

  },
  computed: {

  }
}
</script>

<style lang="scss" scoped>
.container{
  .cover{
    width: 100%;
    height: 400px;
    background-size: cover;
    background-position: center center;
    display: grid;
    grid-template-columns: 30% 70%;
    .left{
      padding: 80px;
      display: flex;
      flex-flow: column;
      justify-content: flex-start;
      align-items: flex-start;
      h1{
        font-size: 40px;
        font-weight: 900;
        color: #fff;
        padding: 0px;
        margin: 0px;
        text-shadow: -1px -1px rgba(255, 255, 255, 1.0), 5px 5px rgba(41, 42, 51, 0.2);
        /*box-shadow: 0px 5px 5px 0px rgba(41, 42, 51, 0.2);*/
      }
      span{
        color: #fff;
        i{
          margin-left: 10px;
        }
        margin-bottom: 20px;
      }
      .btn{
        display: flex;
        justify-content: center;
        align-items: center;
        width:200px;
        i{
          margin-left: 10px;
        }
      }
    }
  }
}
/deep/ .ant-btn.btn{
  border: none;
  background-color: #FDD835;
  transition: color .3s linear;
  color: #212121;
}
/deep/ .ant-btn.btn:hover{
  border: none;
  background-color: #FDD835;
  color: #ffffff;
}
</style>
