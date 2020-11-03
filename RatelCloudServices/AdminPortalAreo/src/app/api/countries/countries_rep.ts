import {country} from "./country";

export class countries_rep{
  constructor() {
    this.code = null;
    this.msg = null;
    this.data = null;
  }

  code: number;
  msg: string;
  data: Array<country>
}
