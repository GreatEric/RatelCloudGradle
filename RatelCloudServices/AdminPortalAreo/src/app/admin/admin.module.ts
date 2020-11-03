import { NgModule } from '@angular/core';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './layout/components/admin/admin.component';
import { OverlayMenuComponent } from './layout/components/overlay-menu/overlay-menu.component';
import { RightSidebarComponent } from './layout/components/right-sidebar/right-sidebar.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LeftSidebarComponent } from './layout/components/left-sidebar/left-sidebar.component';
import { SettingsComponent } from './layout/components/settings/settings.component';
import { BreadcrumbComponent } from './layout/components/breadcrumb/breadcrumb.component';
import { CommonsModule} from "../commons.module";
import { AntdesignModule } from "../antdesign.module";
import {NgxUiLoaderModule} from "ngx-ui-loader";
import {ngxUiLoaderConfig} from "../core/globalconfig";
import {Ng2ScreenshotModule} from "ng2-screenshot";
import {SysuserComponent} from "./dashboards/system/sysuser/sysuser.component";
import {SysmenuComponent} from "./dashboards/system/sysmenu/sysmenu.component";
import {IndexComponent} from "./dashboards/index/index.component";
import { TabpaneComponent } from './layout/components/tabpane/tabpane.component';
import { SwiperModule } from 'ngx-swiper-wrapper';
import { SWIPER_CONFIG } from 'ngx-swiper-wrapper';
import { SwiperConfigInterface } from 'ngx-swiper-wrapper';
import {NavigationService} from "./layout/services/navigation.service";

const DEFAULT_SWIPER_CONFIG: SwiperConfigInterface = {
    direction: 'horizontal',
    slidesPerView: 'auto'
};

@NgModule({
  declarations: [
      AdminComponent,
      OverlayMenuComponent,
      RightSidebarComponent,
      LeftSidebarComponent,
      SettingsComponent,
      BreadcrumbComponent,
      IndexComponent,
      SysuserComponent,
      SysmenuComponent,
      TabpaneComponent
  ],
  imports: [
    CommonsModule,
    AntdesignModule,
    NgxUiLoaderModule.forRoot(ngxUiLoaderConfig),
    AdminRoutingModule,
    NgbModule,
    Ng2ScreenshotModule,
    SwiperModule
  ],
  providers: [
    {
        provide: SWIPER_CONFIG,
        useValue: DEFAULT_SWIPER_CONFIG
    },
    NavigationService
  ]
})
export class AdminModule { }
