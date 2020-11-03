import {SysMenu} from "./sys_menu";

export class SysCategory {
    mid: number;
    mpid: number;
    mname: string;
    mtype: number;
    morder: number;
    list: Array<SysMenu>;

    constructor() {
        this.mid = null;
        this.mpid = null;
        this.mname = null;
        this.mtype = null;
        this.morder = null;
        this.list = null;
    }
}