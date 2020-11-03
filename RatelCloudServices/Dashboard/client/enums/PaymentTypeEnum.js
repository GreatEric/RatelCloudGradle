import Enum from "./Enum";

const PaymentTypeEnum = new Enum()
  .add('STRIPE', 'Stripe', 0)
  .add('SUPERIORPAY', 'Superiorpay', 1);

export default PaymentTypeEnum;
