import Enum from "./Enum";

const PaymentResultEnum = new Enum()
  .add('FAILED', 'failed', 0)
  .add('SUCCEED', 'succeed', 1)
  .add('PROCESSING', 'processing', 2);

export default PaymentResultEnum;
