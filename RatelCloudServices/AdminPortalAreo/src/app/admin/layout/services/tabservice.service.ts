import { Injectable } from '@angular/core';
import {SysTab} from "../../models/sys_tab";

@Injectable({
  providedIn: 'root'
})
export class TabserviceService {
  tabs = new Array<SysTab>();
  currentTab: SysTab;

  constructor() {
  }

  ngOnInit() {}

  addHistoryTab(tab: SysTab) {
    this.tabs.push(tab);
  }
}
