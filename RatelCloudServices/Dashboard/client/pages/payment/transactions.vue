<template>
  <div>
    <div :style="{ padding: '24px', background: '#fff', minHeight: '360px' }">
      <a-card title="Transactions" style="width: 100%" :bordered="false">
        <a-button-group slot="extra">
          <a-button type="primary" @click="showAddForm"><i class="iconfont iconicon-test2"/>Add</a-button>
          <a-button type="primary" @click="showEditForm"><i class="iconfont iconicon-test2"/>Edit</a-button>
        </a-button-group>
        <a-table :columns="tbcolumns" :data-source="tbdata" :pagination="pagination" :rowKey='record=>record.id'
                 :row-selection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }">
          <div slot="expandedRowRender" slot-scope="record" style="margin: 0">
            <a-row :gutter="[16,16]">
              <a-col :span="24">
                <span class="collapseColumTitle">Transaction Id:</span>{{ record.transactionId }}
              </a-col>
            </a-row>
            <a-row :gutter="[16,16]">
              <a-col :span="24">
                <span class="collapseColumTitle">Transaction Id:</span>{{ record.declineReason }}
              </a-col>
            </a-row>
          </div>
          <span slot="transactionId" slot-scope="transactionId">
            <span @click="copyTransId(transactionId)" class="noselect">{{ transactionId | strtruncate(15,'***') }}</span>
          </span>
          <span slot="currency" slot-scope="currency">
            <a-tag :color="'green'">
              {{ currency.toUpperCase() }}
            </a-tag>
          </span>
          <span slot="paymentAmt" slot-scope="paymentAmt">{{ paymentAmt | currencyconvert('de-DE') }}</span>
          <span slot="paymentType" slot-scope="paymentType">
            <a-tag :color="'geekblue'">
              {{ typeEnum.getLabelByValue(paymentType) }}
            </a-tag>
          </span>
          <span slot="paymentResult" slot-scope="paymentResult">
            <a-tag :color="'geekblue'">
              {{ resultEnum.getLabelByValue(paymentResult) }}
            </a-tag>
          </span>
          <span slot="orderSerial" slot-scope="orderSerial">
            <ClipBoard><a-tag :color="'geekblue'" slot="header">{{ orderSerial }}</a-tag></ClipBoard>
          </span>
          <span slot="paymentTime" slot-scope="paymentTime">
            <span>{{ paymentTime | timeconvert }}</span>
          </span>
          <span slot="action" slot-scope="text, record">
            <a-dropdown-button type="dashed" @click="editRow(record)">
              Edit
              <a-menu slot="overlay">
                <a-popconfirm title="Are you sure？" ok-text="Yes" cancel-text="No" @confirm="disable(record.key)">
                  <a-menu-item key="1" style="padding:10px;"> <!--<a-icon type="user" />-->Disable </a-menu-item>
                </a-popconfirm>
                <a-popconfirm title="Are you sure？" ok-text="Yes" cancel-text="No" @confirm="enable(record.key)">
                  <a-menu-item key="1" style="padding:10px;"> <!--<a-icon type="user" />-->Enable </a-menu-item>
                </a-popconfirm>
              </a-menu>
            </a-dropdown-button>
          </span>
        </a-table>
      </a-card>
    </div>

    <!--新增表单-->
    <a-drawer
      title="Create a new Contact"
      :width="drawerWidth"
      :visible="showAdd"
      :body-style="{ paddingBottom: '80px' }"
      @close="closePaymentForm">
      <span class="drawerLabel" :style="{right: drawerWidth+'px'}" v-if="showAdd" @dblclick="fullWidth"></span>
      <a-card
        :bordered="false"
        style="width:100%"
        :tab-list="paymenttabs"
        :active-tab-key="tabKey"
        @tabChange="key => onPaymentMethodTabChange(key, 'tabKey')">
        <p v-if="tabKey === 'stripe'">
          <a-form :form="stripeForm" layout="vertical" hide-required-mark>
            <a-row :gutter="24">
              <a-col :span="24">
                <a-form-item label="Card Info">
                  <div ref="cardWrapper"></div>
                  <!--<div id="card-element" class="input"></div>
                  <div id="card-errors" role="alert"></div>-->
                </a-form-item>
              </a-col>
              <a-col :span="24">
                <a-form-item label="Payment Amount">
                  <a-input v-model="stripeForm.amt" placeholder="payment amount"/>
                </a-form-item>
              </a-col>
            </a-row>
          </a-form>
        </p>
        <p v-else-if="tabKey === 'superior'">
          <a-form :form="superiorForm" layout="vertical" hide-required-mark>
            <a-row :gutter="24">
              <a-col :span="24">
                <a-form-item label="User Id">
                  <a-input v-model="superiorForm.userId" placeholder="enter user id"/>
                </a-form-item>
              </a-col>
              <a-col :span="24">
                <a-form-item label="Currency">
                  <a-input v-model="superiorForm.currency" placeholder="enter currency"/>
                </a-form-item>
              </a-col>
              <a-col :span="24">
                <a-form-item label="CallBack">
                  <a-input v-model="superiorForm.redirectUrl" placeholder="enter callback url"/>
                </a-form-item>
              </a-col>
              <a-col :span="24">
                <a-form-item label="Order No.">
                  <a-input v-model="superiorForm.orderNo" placeholder="enter order number"/>
                </a-form-item>
              </a-col>
              <a-col :span="24">
                <a-form-item label="Description.">
                  <a-input v-model="superiorForm.description" placeholder="enter description"/>
                </a-form-item>
              </a-col>
              <a-col :span="24">
                <a-form-item label="Channel">
                  <a-radio-group name="radioGroup" :default-value="1" v-model="superiorForm.platform">
                    <a-radio :value="1">
                      Ali pay
                    </a-radio>
                    <a-radio :value="2">
                      Wechat pay
                    </a-radio>
                  </a-radio-group>
                </a-form-item>
              </a-col>
            </a-row>
          </a-form>
        </p>
      </a-card>

      <div class="drawerPanel">
        <a-button :style="{ marginRight: '8px' }" @click="closePaymentForm">
          Cancel
        </a-button>
        <a-button type="primary" @click="pay">
          Submit
        </a-button>
      </div>
    </a-drawer>

  </div>
</template>

<script>
  import columns from "../../tbcolumns/tbtransactions";
  import pagination from "../../commons/pagination";
  import PaymentTypeEnum from "../../enums/PaymentTypeEnum";
  import PaymentResultEnum from "../../enums/PaymentResultEnum";
  import ClipBoard from "../../components/ClipBoard";

  export default {
    components: {ClipBoard},
    layout(context) {
      return 'dashboard1'
    },
    data: () => ({
      originalWith: 420,
      width: 420,
      isfullWidth: false,
      tbdata: [],
      tbcolumns: columns,
      pagination: pagination,
      typeEnum: PaymentTypeEnum,
      resultEnum: PaymentResultEnum,
      selectedRowKeys: [],
      paymenttabs: [
        {
          key: 'stripe',
          tab: 'stripe',
        },
        {
          key: 'superior',
          tab: 'superior',
        }
      ],
      tabKey: 'stripe',
      type: 1,
      stripeForm: {
        amt: 0,
        customer: {
          name: "Saas Eric"
        }
      },
      superiorForm: {
        userId: "",
        orderNo: "osn1600516257",
        platform: "1",
        currency: "",
        description: "",
        redirectUrl: "http://localhost:4100/system/transactions"
      },
      showAdd: false,
      stripe: {},
      card: {},
      stripeToken:""
    }),
    props: {},
    created() {
    },
    destroyed() {
    },
    mounted() {
      let result = this.getQueryVariable("result");
      if(result){
        let callback = "/api-payment/superior/callback/"+result;
        this.$apiPayment.superiorCallBack(callback).then((result)=>{
          this.pageTransactions();
        })
      }
      this.$vs2.load('https://js.stripe.com/v3/').then(() => {
      });
      this.pageTransactions();
    },
    methods: {
      copyTransId(orderSerial){
        let placement = 'topRight';
        this.$copyText(orderSerial).then((e)=>{
          console.log('Copied',e.text)

          this.$notification['success']({
            message: `订单编号已复制`,
            description: e.text,
            placement
          });
        }, (e)=>{
          console.log('Can not copy')
        })
      },
      createCardDom(){
        let cardWrapper = this.$refs.cardWrapper;

        let cardDom = document.createElement('div');
        cardDom.classList.add('input');
        cardDom.id = "card-element";

        let cardErrorDom = document.createElement('div');
        cardErrorDom.classList.add('input');
        cardErrorDom.id = "card-errors";

        cardWrapper.appendChild(cardDom);
        cardWrapper.appendChild(cardErrorDom);

        this.initStripe();
      },
      initStripe() {
        this.stripe = Stripe('pk_test_7bCOtrjIgPQHDnQTmJ2LAsex00Ls5UyUPo');

        let elements = this.stripe.elements({locale: 'auto'});
        let style = {
          base: {
            fontSize: "16px",
            color: "#32325d",
            fontFamily:
              "-apple-system, BlinkMacSystemFont, Segoe UI, Roboto, sans-serif",
            fontSmoothing: "antialiased",
            "::placeholder": {
              color: "rgba(0,0,0,0.4)"
            }
          }
        };

        this.card = elements.create("card", { style: style });
        this.card.mount("#card-element");

        this.card.on("focus", function() {
          var el = document.getElementById("card-element");
          el.classList.add("focused");
        });

        this.card.on("blur", function() {
          var el = document.getElementById("card-element");
          el.classList.remove("focused");
        });
      },
      payAndSaveCard(){
        //测试卡号 4000 0025 0000 3155,需要3d secure 验证
        //测试卡号 4242 4242 4242 4242,不需要3d secure验证
        let params = {
          mode:"test",
          usage:"off_session"
        };
        //第一步获取client Secret
        this.$apiPayment.stripeSetupIntent(params).then((result)=>{
          if(result.code===1000){
            //第二步,调用stripe.confirmCardSetup,获取payment_method
            this.stripe.confirmCardSetup(
              result.data.clientSecret, {
                payment_method: {
                  card: this.card,
                  billing_details: this.stripeForm.customer
                },
              }
            ).then((result)=>{
              if (result.error) {
                console.log("error",result.error);
              } else {
                let form = {};

                form.payment_method = result.setupIntent.payment_method;
                form.email = "eric@mangotechgroup.com.au";
                form.name = "Saas Eric";
                form.phone = "0452667430";
                form.description = "Saas Test";

                this.$apiPayment.stripeSaveCard(form).then((result)=>{
                  let params = {};
                  params.customer_id = result.data.customerId;
                  params.descr = "Saas Test";
                  params.amount = this.stripeForm.amt;
                  params.payment_method = form.payment_method;

                  this.$apiPayment.stripePay(params).then((result)=>{
                    let callback = result.data.callback;
                    callback += "/1";
                    callback += "/osn1600516257";
                    this.$apiPayment.stripeCallBack(callback).then((result)=>{
                      this.pageTransactions();
                      this.showAdd = false;
                    })
                  });
                });
              }
            });
          }
        });
      },
      onSelectChange(selectedRowKeys) {
        console.log('selectedRowKeys changed: ', selectedRowKeys);
        this.selectedRowKeys = selectedRowKeys;
      },
      fullWidth() {
        if (this.isfullWidth) {
          this.width = this.originalWith;
          this.isfullWidth = false;
        } else {
          this.width = document.body.clientWidth - 20;
          this.isfullWidth = true;
        }
      },
      closePaymentForm() {
        this.showAdd = false;
      },
      pay() {
        if (this.type === 1) {
          this.payAndSaveCard();
        } else if (this.type === 2) {
          this.$apiPayment.generateQrCode(this.superiorForm).then((result) => {
            if (result.code === 1000) {
              this.showAdd = false;
              let w = window.open();
              w.location.href = result.data.qrCode.payUrl;
            }
          });
        }
      },
      onPaymentMethodTabChange(key, type) {
        if (key === 'stripe') {
          this.type = 1
        } else if (key === 'superior') {
          this.type = 2;
        }
        this[type] = key;
      },
      getQueryVariable(variable) {
        var query = window.location.search.substring(1);
        var vars = query.split("&");
        for (var i=0;i<vars.length;i++) {
          var pair = vars[i].split("=");
          if(pair[0] == variable){return pair[1];}
        }
        return(false);
      },
      login() {
        const credentials = {
          email: "admin@domain.com",
          password: "admin"
        }
        this.$apiUser.login(credentials).then((result) => {
          console.log("登录结果:", result);
        })
      },
      add() {
        this.$apiUser.addContact(this.form).then((result) => {
          if (result.code === 1000) {
            this.showAdd = false;
            this.listAllContacts();
          }
        });
      },
      edit() {
        delete this.editForm.createTime;
        delete this.editForm.updateTime;
        delete this.editForm.status;
        this.editForm.id = this.editForm.key;
        this.$apiUser.editContact(this.editForm).then((result) => {
          if (result.code === 1000) {
            this.showEdit = false;
            this.listAllContacts();
          }
        });
      },
      disable(id) {
        this.$apiUser.disableContact(id).then((result) => {
          if (result.code === 1000) {
            this.listAllContacts();
          }
        });
        console.log("失效:", id);
      },
      enable(id) {
        this.$apiUser.enableContact(id).then((result) => {
          if (result.code === 1000) {
            this.listAllContacts();
          }
        });
        console.log("失效:", id);
      },
      editRow(record) {
        this.editForm = record;
        this.showEdit = true;
      },
      pageTransactions() {
        const params = {
          pageNum: 1,
          pageSize: this.pagination.pageSize
        }
        this.$apiPayment.pageTransactions(params).then((result) => {
          if (result.code === 1000) {
            this.tbdata = result.data.list;
            for (let key in this.tbdata) {
              let createTime = this.$moment(this.tbdata[key].createTime).format('YYYY-MM-DD h:mm:ss a');
              let timestamp = this.tbdata[key].paymentTime;
              //this.$moment.unix(this.tbdata[key].paymentTime/1000).format("YYYY-MM-DD h:mm:ss a");
              //this.$moment(this.$moment.unix(this.tbdata[key].paymentTime)).format('YYYY-MM-DD h:mm:ss a')
              //this.$moment_timezone(timestamp).utc().format("YYYY-MM-DD h:mm:ss a");
              //let paymentTime = this.$moment_timezone(timestamp).tz('Australia/Melbourne').format("YYYY-MM-DD h:mm:ss a");
              //this.tbdata[key].createTime = createTime;
              //this.tbdata[key].paymentTime = paymentTime;
            }
          }
        })
      },
      showAddForm() {
        this.showAdd = true;
        setTimeout(()=>{
          this.createCardDom();
        },500);
      },
      showEditForm() {
        this.showEdit = true;
      },
      closeAddForm() {
        this.showAdd = false;
      },
      closeEditForm() {
        this.showEdit = false;
      }
    },
    computed: {
      drawerWidth() {
        return this.width;
      }
    }
  }
</script>

<style lang="scss" scoped>
  .drawerPanel {
    display: flex;
    flex-flow: row;
    justify-content: flex-end;
    align-items: center;
  }

  .collapseColumTitle {
    margin-right: 10px;
    font-weight: 500;
  }

  .ant-drawer-right.ant-drawer-open .ant-drawer-content-wrapper::after {
    content: " - Remember this";
  }
</style>
