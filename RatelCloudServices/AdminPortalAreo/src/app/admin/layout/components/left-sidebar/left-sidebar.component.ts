import {Component, Input, OnInit} from '@angular/core';
import { LayoutService } from '../../services/layout.service';
import {SysmenuService} from "../../../../api/sysmenu/sysmenu.service";
import {SysCategory} from "../../../models/sys_category";
import {NzMessageService} from "ng-zorro-antd";
import {SysMenu} from "../../../models/sys_menu";

@Component({
  selector: 'app-left-sidebar',
  templateUrl: './left-sidebar.component.html',
  styleUrls: ['./left-sidebar.component.scss']
})
export class LeftSidebarComponent implements OnInit {
  @Input('darkLayout') darkLayout: boolean;

  public activeMenu:string = "";

  sysCategoryList = new Array<SysCategory>();

  constructor(private layoutService: LayoutService,private sysMenuService: SysmenuService,private messageService: NzMessageService) { }

  ngOnInit() {
    this.sysMenuService.getSysMenu().subscribe(rep=>{
      let list = rep.data.menuList;
      //递归解析数据
      this.paseSysMenu(list,null);

      //console.log(this.sysCategoryList);
    });
  }

  openItem(item:string){
    if(this.activeMenu == item){
      this.activeMenu = "";
    } else {
      this.activeMenu = item;
    }
  }

  toggleSmallMenu(){
    this.layoutService.toggleLeftBar();
  }

  paseSysMenu(list:any, parent: any): void{
    Object.keys(list).map(key =>{
      let data = list[key];

      switch (data.mtype) {
        case 0: //目录
          let cate = new SysCategory();
          cate.mid = data.mid;
          cate.mname = data.mname;
          cate.morder = data.morder;
          cate.mpid = data.mpid;
          cate.mtype = data.mtype;

          if(data.list && data.list.length>0){
            cate.list = new Array<SysMenu>();
            this.paseSysMenu(data.list,cate);
          }
          this.sysCategoryList.push(cate);
          break;
        case 1: //菜单
          let menu = new SysMenu();
          menu.mid = data.mid;
          menu.mname = data.mname;
          menu.morder = data.morder;
          menu.mpid = data.mpid;
          menu.mtype = data.mtype;
          menu.micon = data.micon;
          menu.mperms = data.mperms;
          menu.murl = data.murl;
          parent.list.push(menu);
          break;
        case 2: //按钮
          break;
      }
    });
  }
}
