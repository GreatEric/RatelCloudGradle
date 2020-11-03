<template>
  <div>
    <div :style="{ padding: '24px', background: '#fff', minHeight: '360px' }">
      <a-card title="Payment Test">

        <a-form layout="vertical" hide-required-mark>
          <a-row :gutter="24">
            <a-col :span="24">
              <a-form-item label="Card Info">
                <div id="card-element" class="input"></div>
                <div id="card-errors" role="alert"></div>
              </a-form-item>
            </a-col>
            <a-col :span="24">
              <a-input v-model="paymentAmt" placeholder="enter payment amount"/>
              <a-button type="primary" @click="payAndSaveCard">
                Pay
              </a-button>
            </a-col>
          </a-row>
        </a-form>
      </a-card>
    </div>
  </div>
</template>

<script>
  export default {
    components: {},
    layout: 'dashboard1',
    data: () => ({
      stripe: {},
      card: {},
      stripeToken:"",
      stripeForm: {
        name: "Saas Eric"
      },
      paymentAmt: 0
    }),
    props: {
    },
    created(){
    },
    destroyed(){
    },
    mounted(){
      this.$vs2.load('https://js.stripe.com/v3/').then(() => {
        this.initStripe();
      });
    },
    methods:{
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
                  billing_details: this.stripeForm
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
                  params.amount = this.paymentAmt;
                  params.payment_method = form.payment_method;

                  this.$apiPayment.stripePay(params).then((result)=>{
                    let callback = result.data.callback;
                    callback += "/1";
                    callback += "/osn1600516257";
                    this.$apiPayment.stripeCallBack(callback).then((result)=>{
                      //console.log("result",result);
                    })
                  });
                });
              }
            });
          }
        });
      },
    },
    computed: {
    }
  }
</script>

<style lang="scss" scoped>
  .drawerPanel{
    display: flex;
    flex-flow: row;
    justify-content: flex-end;
    align-items: center;
  }
</style>
