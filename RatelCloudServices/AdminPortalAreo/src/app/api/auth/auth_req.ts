export class auth_req {
  constructor() {
    this.userName = null;
    this.password = null;
    this.captcha = null;
    this.locale = null;
  }
  userName: string;
  password: string;
  captcha: string;
  locale: string;
}
