<template>
  <div class="container">
    <a-row>
      <a-col :xs="6" :sm="6" :md="6" :lg="6" :xl="6" class="leftBox">
        <a-card :bordered="false">
          <div class="profileTitleWrapper">
            <h1>Personal Profile</h1>
            <span>Hired on May 24,2019</span>
          </div>
          <div class="avatarWrapper">
            <span class="avatar" @click="showCropper">
              <span class="waves"><i class="iconfont iconbianji"></i></span>
              <img :src="userInfo.avatar"/>
            </span>
          </div>
          <div class="nameWrapper">
            <span><em></em>Profile Verified</span>
            <span>Eric Li</span>
            <span>OS Developer</span>
          </div>
          <div class="progressWrapper">
            <div>
              <span class="uppercase">profile progress</span>
              <span>75%</span>
            </div>
            <div class="progress"><span :style="{ width: profileProgress+'%' }"></span></div>
          </div>
          <div class="infoWrapper">
            <span class="uppercase">Gender</span>
            <span>Not specified</span>
          </div>
          <div class="infoWrapper">
            <span class="uppercase">Email</span>
            <span>Cheryleric0828@gmail.com</span>
          </div>
          <div class="infoWrapper">
            <span class="uppercase">Phone number</span>
            <span>+61 0452667430</span>
          </div>
          <div class="infoWrapper">
            <span class="uppercase">Location</span>
            <span>burwood, Melbourne, VIC, AUS</span>
          </div>
          <div class="infoWrapper">
            <span class="uppercase">Desired position</span>
            <span>Consultant</span>
          </div>
          <div class="infoWrapper">
            <span class="uppercase">Departments</span>
            <span>Develop and design</span>
          </div>
          <div class="infoWrapper">
            <span class="uppercase">Teams</span>
            <span>Mangotechgroup</span>
          </div>
          <div class="reportingWrapper">
            <span class="uppercase title">Reporting person</span>
            <div class="box">
              <img src="http://sasstestbucket.oss-ap-southeast-2.aliyuncs.com/test/oss1601074796268.jpg">
              <div>
                <span class="uppercase">Mariano Rasgado</span>
                <span>Product Manager</span>
              </div>
            </div>
          </div>
        </a-card>
      </a-col>
      <a-col :xs="12" :sm="12" :md="12" :lg="12" :xl="12" class="middleBox">
        <a-card :bordered="false" class="mb10">
          <div slot="title">
            <h3>Objectives</h3>
          </div>
          <div slot="extra">
            <span>All</span>
          </div>
          <div>This widget shows the employee's objectives within the organization</div>
        </a-card>

        <a-card :bordered="false" class="mb10 objective">
          <div slot="title" class="header">
            <span class="title">Personal</span>
            <div class="panel">
              <span><i class="iconfont icontixing3"></i>Skills</span>
              <span>UX Writing</span>
              <div>
                <div class="statusWrapper">
                  <em class="notStarted"></em>Not started
                </div>
              </div>
            </div>
          </div>
          <div class="content">
            <div>
              <span class="uppercase">Start Date</span>
              <span class="uppercase">End Date</span>
            </div>
            <div class="progress"><span :style="{ width: profileProgress+'%' }"></span></div>
            <div>
              <span class="uppercase">11/10/2020</span>
              <span class="uppercase">25/12/2020</span>
            </div>
            <div>
              <span class="uppercase">Report</span>
              <div class="reporter">
                <img src="http://sasstestbucket.oss-ap-southeast-2.aliyuncs.com/test/oss1601074796268.jpg">
                Lisandro Masos
              </div>
              <div>
                <a-button type="primary">
                  Primary
                </a-button>
                <a-button type="primary">
                  Primary
                </a-button>
              </div>
            </div>
          </div>
        </a-card>

        <a-card :bordered="false" class="objective">
          <div slot="title" class="header">
            <span class="title">Organization</span>
            <div class="panel">
              <span><i class="iconfont iconjira"></i>Jira</span>
              <span>Introduct 2 new product concepts by Q4...</span>
              <div>
                <div class="statusWrapper">
                  <em class="inProgress"></em>In progress - 25%
                </div>
              </div>
            </div>
          </div>
          <div class="content">
            <div>
              <span class="uppercase">Start Date</span>
              <span class="uppercase">End Date</span>
            </div>
            <div class="progress"><span :style="{ width: profileProgress+'%' }"></span></div>
            <div>
              <span class="uppercase">11/10/2020</span>
              <span class="uppercase">25/12/2020</span>
            </div>
            <div>
              <span class="uppercase">Report</span>
              <div class="reporter">
                <img src="http://sasstestbucket.oss-ap-southeast-2.aliyuncs.com/test/oss1601074796268.jpg">
                Lisandro Masos
              </div>
              <div>
                <a-button type="primary">
                  Primary
                </a-button>
                <a-button type="primary">
                  Primary
                </a-button>
              </div>
            </div>
          </div>
        </a-card>

        <a-card :bordered="false" class="objective">
          <div slot="title" class="header">
            <div class="panel">
              <span><i class="iconfont icongithub1"></i>Github</span>
              <span>Provide a usable interface on multiplt...</span>
              <div>
                <div class="statusWrapper">
                  <em class="inProgress"></em>In progress - 75%
                </div>
              </div>
            </div>
          </div>
          <div class="content">
            <div>
              <span class="uppercase">Start Date</span>
              <span class="uppercase">End Date</span>
            </div>
            <div class="progress"><span :style="{ width: profileProgress+'%' }"></span></div>
            <div>
              <span class="uppercase">11/10/2020</span>
              <span class="uppercase">25/12/2020</span>
            </div>
            <div>
              <span class="uppercase">Report</span>
              <div class="reporter">
                <img src="http://sasstestbucket.oss-ap-southeast-2.aliyuncs.com/test/oss1601074796268.jpg">
                Lisandro Masos
              </div>
              <div>
                <a-button type="primary">
                  Primary
                </a-button>
                <a-button type="primary">
                  Primary
                </a-button>
              </div>
            </div>
          </div>
        </a-card>

      </a-col>
      <a-col :xs="6" :sm="6" :md="6" :lg="6" :xl="6" class="rightBox">
        <a-card :bordered="false">
          <div class="widgetWrapper">
            <i class="iconfont icontianjiashebei"></i>
            <span>Create skill assessment</span>
            <span>Click here to create an assessment</span>
          </div>

          <div class="widgetWrapper">
            <i class="iconfont icontianjiashebei"></i>
            <span>Create skill assessment</span>
            <span>Click here to create an assessment</span>
          </div>

          <div class="widgetWrapper">
            <i class="iconfont icontianjiashebei"></i>
            <span>Create skill assessment</span>
            <span>Click here to create an assessment</span>
          </div>

          <div class="widgetWrapper">
            <i class="iconfont icontianjiashebei"></i>
            <span>Create skill assessment</span>
            <span>Click here to create an assessment</span>
          </div>

          <div class="widgetWrapper">
            <i class="iconfont icontianjiashebei"></i>
            <span>Create skill assessment</span>
            <span>Click here to create an assessment</span>
          </div>
        </a-card>
      </a-col>
    </a-row>

    <ImgCropper title="Edit Avatar" :img="userInfo.avatar"/>
  </div>
</template>

<script>

  export default {
    components: {},
    layout: 'dashboard1',
    data: () => ({
      profileProgress: 75,
      showEditAvatar: false,
      userInfo:{
        avatar: 'http://sasstestbucket.oss-ap-southeast-2.aliyuncs.com/test/oss1601074796268.jpg'
      }
    }),
    props: {},
    created() {
      this.$nuxt.$on('cropSuccess', (url) => {
        console.log("图片裁剪地址:",url);
      })
    },
    destroyed() {
    },
    mounted() {
      //this.listAllAdmins();
    },
    methods: {
      /**
       * Description:
       * 显示Cropper
       */
      showCropper(){
        this.$nuxt.$emit('showCropper');
      },

      add() {
        this.$apiUser.addAdmin(this.form).then((result) => {
          if (result.code === 1000) {
            this.showAdd = false;
            this.listAllAdmins();
          }
        });
      },
      edit() {
        delete this.editForm.createTime;
        delete this.editForm.updateTime;
        delete this.editForm.status;
        this.editForm.id = this.editForm.key;
        this.$apiUser.editAdmin(this.editForm).then((result) => {
          if (result.code === 1000) {
            this.showEdit = false;
            this.listAllAdmins();
          }
        });
      },
      disable(id) {

      },
      enable(id) {

      },
      editRow(record) {
        this.editForm = record;
        this.showEdit = true;
      },
      listAllAdmins() {
        const params = {
          pageNum: 1,
          pageSize: this.pagination.pageSize
        }
        this.$apiUser.listAllAdmins(params).then((result) => {
          if (result.code === 1000) {
            this.tbdata = result.data.list;
            for (let key in this.tbdata) {
              let createTime = this.$moment(this.tbdata[key].createTime).format('YYYY-MM-DD h:mm:ss a');
              let updateTime = this.$moment(this.tbdata[key].updateTime).format('YYYY-MM-DD h:mm:ss a');
              this.tbdata[key].createTime = createTime;
              this.tbdata[key].updateTime = updateTime;
              this.tbdata[key].status = this.tbdata[key].status === 1 ? true : false;
            }
          }
        })
      },
      fetchAllRoles() {
        this.$apiUser.fetchAllRoles().then((result) => {
          if (result.code === 1000) {
            this.roleslist = result.data.list;
          }
        })
      },
      showAddForm() {
        this.showAdd = true;
        this.fetchAllRoles();
      },
      showEditForm() {
        this.showEdit = true;
      },
      closeAddForm() {
        this.showAdd = false;
      },
      closeEditForm() {
        this.showEdit = false;
      },
      fetch(value, callback) {
        if (this.timeout) {
          clearTimeout(this.timeout);
          this.timeout = null;
        }
        this.currentValue = value;

        this.timeout = setTimeout(this.fake, 300);
      },
      fake() {
        this.$apiUser.fetchContactByEmailLike(this.currentValue).then((result) => {
          if (result.code === 1000) {
            const data = result.data.list.map(user => ({
              text: `${user.email}`,
              value: user.email,
            }));
            this.data = data;
          }
        });
      },
      handleSearch(value) {
        if (value) {
          this.fetch(value, data => (this.data = data));
        }
      },
      handleChange(value) {
        this.value = value;
        this.fetch(value, data => (this.data = data));
      },
      handleSelect(value) {
        this.selectedContact.push(value);
        this.form.account = value;
      }
    },
    computed: {}
  }
</script>

<style lang="scss" scoped>
  $gap: 20px;

  .container {
    .leftBox {
      padding: 0 $gap 0 0px;
      .profileTitleWrapper {
      }
      .avatarWrapper {
        height: 150px;
        display: flex;
        justify-content: center;
        align-items: center;
        .avatar {
          width: 120px;
          height: 120px;
          border-radius: 50%;
          border: 1px solid rgba(238, 241, 243, 0.8);
          box-shadow: 0px 5px 5px 0px rgba(41, 42, 51, 0.2);
          cursor: pointer;
          display: flex;
          justify-content: center;
          align-items: center;
          /*animation: color-loop 18s infinite;*/
        }
        .avatar img {
          width: 110px;
          height: 110px;
          border-radius: 50%;
          border: 1px solid rgba(238, 241, 243, 0.8);
        }
        .avatar .mask {
          position: absolute;
          width: 100px;
          height: 100px;
          border-radius: 50%;
          background-color: red;
          background: linear-gradient(45deg, #ef8f86, #214381);
          opacity: 0.2;
        }
        .avatar .waves {
          display: block;
          position: absolute;
          background: rgba(0, 255, 255, 0.0);
          width: 25px;
          height: 25px;
          border-radius: 50%;
          -webkit-backface-visibility: hidden;
        }
        .avatar .waves .iconfont {
          position: absolute;
          font-size: 25px;
          color: #C62828;
        }
        .avatar .waves:after {
          position: absolute;
          background: rgba(238, 241, 243, 0.8);
          margin-left: -12px;
          margin-top: -12px;
          width: 50px;
          height: 50px;
          content: "";
          display: block;
          border-radius: 50%;
          -webkit-backface-visibility: hidden;
          opacity: 0;
          animation: wave-animate 3s 1.5s infinite ease-out;
        }
      }
      .nameWrapper {
        display: flex;
        flex-flow: column;
        justify-content: center;
        align-items: center;
        span:nth-child(1) {
          background-color: rgba(41, 42, 51, 0.2);
          font-size: 10px;
          padding: 2px 10px 2px 10px;
          border-radius: 20px;
          display: flex;
          justify-content: center;
          align-items: center;
        }
        span:nth-child(1) em {
          width: 10px;
          height: 10px;
          display: block;
          border-radius: 50%;
          background-color: rgb(118, 255, 3);
          margin-right: 5px;
        }
        span:nth-child(2) {
          font-size: 30px;
          font-weight: 900;
        }
      }
      .progressWrapper {
        display: flex;
        flex-flow: column;
        justify-content: center;
        align-items: center;
        margin-top: $gap;
        margin-bottom: $gap;

        div:nth-child(1) {
          width: 100%;
          margin-bottom: 5px;
        }
        div:nth-child(1) span:nth-child(1) {
          float: left;
        }
        div:nth-child(1) span:nth-child(2) {
          float: right;
        }
        .progress {
          width: 100%;
          height: 8px;
          border-radius: 10px;
          background-color: rgba(255, 224, 178, 0.5);
        }
        .progress span {
          display: block;
          background: rgb(255, 167, 38);
          height: 8px;
          border-radius: 10px;
        }
      }
      .infoWrapper {
        width: 100%;
        margin-bottom: $gap;
        padding: 10px 15px 10px 15px;
        background: rgba(238, 241, 243, 0.3);
        display: grid;
        grid-template-columns: 35% 65%;
        span:nth-child(1) {
          display: flex;
          justify-content: flex-start;
          align-items: center;
          font-size: 11px;
          font-weight: 900;
        }
        span:nth-child(2) {
          display: flex;
          justify-content: flex-end;
          align-items: center;
        }
      }
      .reportingWrapper {
        padding: 10px 15px 10px 15px;
        background: rgba(238, 241, 243, 0.3);
        .title {
          display: block;
          margin-bottom: 5px;
          font-weight: 900;
        }
        .box {
          display: grid;
          grid-template-columns: 20% 80%;
          img {
            width: 50px;
            height: 50px;
            border-radius: 50%;
            border: 1px solid rgba(238, 241, 243, 0.8);
          }
          div {
            display: flex;
            flex-flow: column;
            justify-content: center;
            align-items: flex-start;
            span:nth-child(1) {
              font-weight: 900;
              font-size: 16px;
            }
          }
        }
      }
    }
    .middleBox {
      .objective {
        .header {
          display: flex;
          justify-content: center;
          align-items: center;
          .title {
            position: absolute;
            top: -20px;
            background: #fff;
            padding: 5px 20px 5px 20px;
          }
          .panel {
            width: 100%;
            display: grid;
            grid-template-columns: 15% 55% 30%;
            justify-content: flex-start;
            align-items: center;
            background: rgba(238, 241, 243, 0.3);
            padding: 10px 20px 10px 20px;
            .iconfont {
              margin-right: 5px;
            }
            .iconjira {
              color: rgb(38, 132, 255);
            }
            span:nth-child(2) {
              font-weight: 900;
            }
            div {
              display: flex;
              justify-content: flex-end;
              align-items: center;
              .statusWrapper {
                background: rgba(238, 241, 243, 1.0);
                padding: 2px 10px 2px 10px;
                border-radius: 20px;
                em {
                  width: 10px;
                  height: 10px;
                  display: block;
                  border-radius: 50%;
                  margin-right: 5px;
                }
                em.notStarted {
                  background-color: rgb(117, 117, 117);
                }
                em.inProgress {
                  background-color: rgb(2, 136, 209);
                }
              }
            }
          }
        }
        .content {
          div {
            width: 100%;
          }
          div:nth-child(1) {
            display: grid;
            grid-template-columns: 50% 50%;
            margin-bottom: 10px;
            span:nth-child(2) {
              display: flex;
              align-items: center;
              justify-content: flex-end;
            }
          }
          .progress {
            width: 100%;
            height: 8px;
            border-radius: 10px;
            background-color: rgba(255, 224, 178, 0.5);
            margin-bottom: 10px;
          }
          .progress span {
            display: block;
            background: rgb(255, 167, 38);
            height: 8px;
            border-radius: 10px;
          }
          div:nth-child(3) {
            display: grid;
            grid-template-columns: 50% 50%;
            margin-bottom: 10px;
            span:nth-child(2) {
              display: flex;
              align-items: center;
              justify-content: flex-end;
            }
          }
          div:nth-child(4) {
            display: grid;
            grid-template-columns: 10% 30% 60%;
            align-items: center;
            .reporter {
              width: 180px;
              background: rgba(238, 241, 243, 0.3);
              padding: 5px 20px 5px 20px;
              display: flex;
              justify-content: center;
              align-items: center;
              img {
                width: 30px;
                height: 30px;
                border-radius: 50%;
                border: 1px solid rgba(238, 241, 243, 0.8);
              }
            }
            span:nth-child(2) {
              display: flex;
              align-items: center;
              justify-content: flex-end;
            }
          }
        }
      }
    }
    .rightBox {
      padding: 0 0 0 $gap;
      .widgetWrapper {
        display: flex;
        flex-flow: column;
        justify-content: center;
        align-items: center;
        background-color: rgba(238, 241, 243, 0.3);
        padding: 40px 0px 40px 0px;
        margin-bottom: $gap;
        .iconfont {
          font-size: 30px;
          margin-bottom: 15px;
          color: rgb(224, 224, 224);
          transition: color .3s linear;
          cursor: pointer;
        }
        .iconfont:hover {
          color: rgb(117, 117, 117);
        }
      }
    }
  }

  @keyframes wave-animate {
    0% {
      transform: scale(0);
      opacity: 1;
      transform-origin: center;
    }
    100% {
      transform: scale(3);
      opacity: 0;
      transform-origin: center;
    }
  }

  @keyframes color-loop {
    0% {
      background: #2CAB5B;
    }
    25% {
      background: #FABC03;
    }
    50% {
      background: #ED4B40;
    }
    75% {
      background: #4286F3;
    }
    100% {
      background: #2CAB5B;
    }
  }
</style>
