<template>
  <div>
    <client-only>
      <vue-element-loading :active="isActive" :is-full-screen="true" spinner="bar-fade-scale" color="#FF6700"/>
    </client-only>
    <a-layout id="layout-trigger" style="min-height: 100vh" v-if="!isActive">
      <a-layout-sider v-model="collapsed" collapsible>
        <a-icon
          slot="trigger"
          class="trigger"
          :type="collapsed ? 'menu-unfold' : 'menu-fold'"
          @click="() => (collapsed = !collapsed)"/>
        <div class="logo">
          <img src="~/assets/imgs/logo/logo-lighttheme.svg"/>
          <span v-if="!collapsed">RatelCloud</span>
        </div>
        <div class="user-info">
          <div class="image" v-if="!collapsed">
            <nuxt-link to="/profile">
              <img src="~/assets/imgs/logo/logo-lighttheme.svg"/>
            </nuxt-link>
          </div>
          <div class="detail">
            <nuxt-link to="/user">
              <h4>Eric</h4>
            </nuxt-link>
            <small v-if="!collapsed">super admin</small>
          </div>
        </div>

        <a-menu theme="dark" mode="inline">
          <template v-for="item in menus">
            <a-menu-item v-if="!item.children" :key="item.key">
              <nuxt-link :to="item.path">
                <i :class="item.icon" />
                <span v-if="!collapsed">{{ item.title }}</span>
              </nuxt-link>
            </a-menu-item>
            <a-sub-menu v-else :key="item.key">
              <template v-for="subitem in item.children">
                <span slot="title"><i :class="item.icon" /><span v-if="!collapsed">{{ item.title }}</span></span>
                <a-menu-item v-if="!subitem.children" :key="subitem.key">
                  <nuxt-link :to="subitem.path">
                    <i :class="subitem.icon" />
                    <span v-if="!collapsed">{{ subitem.title }}</span>
                  </nuxt-link>
                </a-menu-item>
                <a-sub-menu v-else :key="subitem.key">
                  <template v-for="sonitem in subitem.children">
                    <span slot="title"><a-icon type="user" /><span v-if="!collapsed">{{ sonitem.title }}</span></span>
                    <a-menu-item v-if="!sonitem.children" :key="sonitem.key">
                      <nuxt-link :to="sonitem.path">
                        <i :class="sonitem.icon" />
                        <span v-if="!collapsed">{{ sonitem.title }}</span>
                      </nuxt-link>
                    </a-menu-item>
                  </template>
                </a-sub-menu>
              </template>
            </a-sub-menu>
          </template>
        </a-menu>
      </a-layout-sider>
      <a-layout>
        <a-layout-header class="headerBg">
          <a-icon
            class="trigger"
            :type="collapsed ? 'menu-unfold' : 'menu-fold'"
            @click="() => (collapsed = !collapsed)"/>
          <!--<a-menu
            theme="dark"
            mode="horizontal"
            :default-selected-keys="['2']"
            :style="{ lineHeight: '64px' }">
            <a-menu-item key="1" class="noselect">
              nav 1
            </a-menu-item>
            <a-menu-item key="2" class="noselect">
              nav 2
            </a-menu-item>
            <a-menu-item key="3" class="noselect">
              nav 3
            </a-menu-item>
          </a-menu>-->
        </a-layout-header>
        <a-layout-content style="margin: 0 16px">
          <a-breadcrumb style="margin: 16px 0" separator=" ">
            <!--<a-breadcrumb-item>MangoSaas</a-breadcrumb-item>
            <a-breadcrumb-item><a href="">Component</a></a-breadcrumb-item>
            <a-breadcrumb-item>
              <a href="">General</a>
              <a-menu slot="overlay">
                <a-menu-item>
                  <a target="_blank" rel="noopener noreferrer" href="http://www.alipay.com/">
                    General
                  </a>
                </a-menu-item>
                <a-menu-item>
                  <a target="_blank" rel="noopener noreferrer" href="http://www.taobao.com/">
                    Layout
                  </a>
                </a-menu-item>
                <a-menu-item>
                  <a target="_blank" rel="noopener noreferrer" href="http://www.tmall.com/">
                    Navigation
                  </a>
                </a-menu-item>
              </a-menu>
            </a-breadcrumb-item>
            <a-breadcrumb-item>Button</a-breadcrumb-item>-->
            <!--<a-breadcrumb-item>{{ routingInfo.from.title }}</a-breadcrumb-item>
            <a-breadcrumb-item>{{ routingInfo.current.title }}</a-breadcrumb-item>-->
          </a-breadcrumb>
          <nuxt/>
        </a-layout-content>
        <a-layout-footer style="text-align: center">
          RatelCloud ©2020 Created by ...
        </a-layout-footer>
      </a-layout>
    </a-layout>
  </div>
</template>

<script>
  import menus from "../commons/menus";

  export default {
    components: {
    },
    data: () => ({
      menus,
      isActive: true,
      collapsed: false
    }),
    created () {

    },
    mounted(){
      setTimeout(()=>{
        this.isActive = false;
      },500)
      // this.$nextTick(() => {
      //   this.$nuxt.$loading.start()
      //   setTimeout(() => {
      //     this.$nuxt.$loading.finish();
      //     this.loadingFinished = true;
      //   }, 500)
      // })
    },
    destroyed () {
    },
    methods:{

    },
    computed: {
      routingInfo(){
        let current = this.$recursiveSearch(menus,'path',this.$nuxt.$route.path);
        let info = {
          from: this.$store.state.routing.routing.from,
          current: current
        }
        return info;
      }
    },
    watch: {

    }
  }
</script>

<style lang="scss" scoped>
  .iconfont{
    margin-right: 10px;
  }

  #layout-trigger .trigger {
    font-size: 18px;
    line-height: 64px;
    padding: 0 24px;
    cursor: pointer;
    /*transition: color 0.3s;*/
  }

  #layout-trigger .trigger:hover {
    color: #1890ff;
  }

  #layout-trigger .logo {
    height: 32px;
    background: transparent;
    margin: 16px;
    display: flex;
    flex-flow: row;
    align-items: center;
    justify-content: center;
  }
  #layout-trigger .logo img{
    width: 40px;
  }
  #layout-trigger .logo span{
    font-size: 21px;
    font-weight: 700;
    color: white;
  }

  .headerBg{
    padding: 0;
    background-color: #fff;
    /*background: linear-gradient(90deg, rgb(252, 70, 107) 0%, rgb(63, 94, 251) 100%);
    --header-bg: linear-gradient(90deg, #FC466B 0%, #3F5EFB 100%);*/
  }

 .ant-layout{
   /*background: url("~@/assets/imgs/bg/5.jpg") 50% no-repeat;*/
 }


  .user-info{
    display: flex;
    align-items: center;
    justify-content: center;
    border-top: 1px solid #eee;
    border-bottom: 1px solid #eee;
    height: 100px;
  }
  .user-info .image{
    box-shadow: 0px 5px 5px 0px rgba(41,42,51,0.2);
    border-radius: 5px;
    margin-right: 15px;
  }
  .user-info .image img{
    -webkit-border-radius: 8px;
    -moz-border-radius: 8px;
    -ms-border-radius: 8px;
    border-radius: 8px;
    width: 50px;
    background-color: rgba(41,42,51,0.2);
    vertical-align: bottom !important;
    border: 3px solid #fff;
    border-radius: 5px;
  }
  .user-info .detail{
    height: 50px;
    display: flex;
    flex-flow: column;
  }
  .user-info .detail h4{
    display: block;
    font-size: 20px;
  }
  .user-info .detail small{
    font-size: 80%;
    font-weight: 400;
    line-height: 2px;
  }
</style>
