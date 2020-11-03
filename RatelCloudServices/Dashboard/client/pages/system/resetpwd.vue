<template>
  <div class="login-container">
    <div class="login-info">
      <div class="title">Mango SaaS Cloud</div>
      <div class="sub-title">Microservice System</div>
      <div class="desc">1.Start Selling on a Website</div>
      <div class="desc">2.Your free online store is just a few clicks away.</div>
      <div class="desc">3.Sell anywhere</div>
      <div class="desc">4.Grow faster</div>
      <div class="desc">5.Manage simply</div>
    </div>
    <a-form :form="form" layout="vertical" hide-required-mark class="login-form" v-if="!findPwd">
      <a-row :gutter="24">
        <a-col :span="24">
          <a-form-item label="New Password">
            <a-input-password v-model="form.pwd" placeholder="enter new password" />
          </a-form-item>
          <a-form-item label="Confirm New Password">
            <a-input-password v-model="form.pwd" placeholder="confirm password" />
          </a-form-item>
        </a-col>
      </a-row>
      <a-row :gutter="24">
        <a-col :span="24">
          <a-button type="primary" style="width: 100%">
            Submit
          </a-button>
        </a-col>
      </a-row>
    </a-form>
    <span class="login-footer">
      © 2020 <a target="_blank" href="https://www.mangotechgroup.com.au/">Mangotechgroup</a> - SaaS
    </span>
  </div>
</template>

<script>
  export default {
    components: {},
    layout: 'default',
    data: () => ({
      findPwd: false,
      form: {
        account:'',
        pwd:''
      },
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
      login() {
        const credentials = {
          email: "admin@domain.com",
          password: "admin"
        }
        this.$apiUser.login(credentials).then((result)=>{
          console.log("登录结果:",result);
        })
      },
      showFindPwd(){
        this.findPwd = true;
      }
    },
    computed: {
    }
  }
</script>

<style lang="scss" scoped>

  $cursor: #555;

  @supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
    .login-container .el-input input {
      color: $cursor;
    }
  }

  .login-container {
    background: url("~@/assets/imgs/background2.png") 50% no-repeat;
    background-size: cover;
    width: 100%;
    height: 100vh;
    .login-info {
      position: absolute;
      left: 15%;
      top: 44%;
      margin-top: -100px;
      color: #fff;
      font-weight: 600;
      .title {
        font-size: 1.8rem;
        font-weight: 600;
      }
      .sub-title {
        font-size: 1.5rem;
        margin: .3rem 0 .7rem 1rem;
      }
      .desc {
        font-size: .96rem;
        line-height: 1.9rem;
      }
    }
    .login-form {
      position: absolute;
      top: 50%;
      left: 75%;
      margin: -180px 0 0 -160px;
      width: 320px;
      height: 380px;
      padding: 36px;
      background: #fff;
      border-radius: 3px;
      .notification {
        display: block;
        padding-top: 20px;
        padding-bottom: 10px;
      }
    }
    .login-footer {
      position: fixed;
      bottom: 1rem;
      width: 100%;
      text-align: center;
      color: white;
      font-size: .9rem;
      line-height: 1rem;
      height: 1rem;
      font-weight: 600;
    }

    @media only screen and (max-width: 470px) {

    }

    @media screen and (max-width: 1100px) {

    }

    @media screen and (max-width: 970px) {

    }
  }
</style>
