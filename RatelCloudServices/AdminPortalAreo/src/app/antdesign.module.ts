import { ModuleWithProviders, NgModule, Optional, SkipSelf } from '@angular/core';
import {throwIfAlreadyLoaded} from "./core/module.import.guard";
import { NzInputModule } from "ng-zorro-antd/input";
import { NzMessageModule } from "ng-zorro-antd/message";
import { NzSelectModule } from 'ng-zorro-antd/select';
import { NzIconModule } from 'ng-zorro-antd/icon';
import {
  NzButtonModule,
  NzCardModule,
  NzDropDownModule,
  NzSwitchModule,
  NzTabsModule,
  NzTreeModule
} from "ng-zorro-antd";

@NgModule({
  declarations: [],
  imports: [
    NzMessageModule,
    NzInputModule,
    NzSelectModule,
    NzIconModule,
    NzDropDownModule,
    NzButtonModule,
    NzSwitchModule,
    NzCardModule,
    NzTabsModule,
    NzTreeModule
  ],
  exports: [
    NzMessageModule,
    NzInputModule,
    NzSelectModule,
    NzIconModule,
    NzDropDownModule,
    NzButtonModule,
    NzSwitchModule,
    NzCardModule,
    NzTabsModule,
    NzTreeModule
  ]
})
export class AntdesignModule {
  constructor(@Optional() @SkipSelf() parentModule: AntdesignModule) {
    throwIfAlreadyLoaded(parentModule, 'AntdesignModule');
  }

  static forRoot(): ModuleWithProviders {
    return {
      ngModule: AntdesignModule,
      providers: [],
    };
  }
}
