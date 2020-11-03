import {SysCategory} from "./sys_category";

export class SysMenu extends SysCategory{
    murl: string;
    mperms: Array<string>;
    micon: string;

    constructor() {
        super();
        this.murl = null;
        this.mperms = null;
        this.micon = null;
    }
}