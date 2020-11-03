import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthenticationGuard } from "./authentication/services/authentication-guard.service";
import { FormsModule } from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { registerLocaleData } from '@angular/common';
/*国际化: start*/
import en from '@angular/common/locales/en';
import { NZ_I18N, en_US } from 'ng-zorro-antd/i18n';
import {NgxUiLoaderModule} from "ngx-ui-loader";
import {ngxUiLoaderConfig} from "./core/globalconfig";
import {BaseInterceptor} from "./api/base-interceptor";
import {RouteReuseStrategy} from "@angular/router";
import {AppReuseStrategy} from "./admin/app-reuse-strategy";
/*国际化: end*/

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    NgxUiLoaderModule.forRoot(ngxUiLoaderConfig)
  ],
  exports: [
  ],
  providers: [
      AuthenticationGuard,
      { provide: HTTP_INTERCEPTORS, useClass: BaseInterceptor, multi: true },
      { provide: NZ_I18N, useValue: en_US },
      { provide: RouteReuseStrategy, useClass: AppReuseStrategy }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
