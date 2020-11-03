import { NgModule } from '@angular/core';
import { AuthenticationRoutingModule } from './authentication-routing.module';
import { AuthenticationComponent } from './components/authentication.component';

/*google repatcha: start*/
import { RECAPTCHA_V3_SITE_KEY, RecaptchaV3Module } from 'ng-recaptcha';
/*google repatcha: end*/

import {AntdesignModule} from "../antdesign.module";
import {CommonsModule} from "../commons.module";
import {NgxUiLoaderModule} from "ngx-ui-loader";
import {ngxUiLoaderConfig} from "../core/globalconfig";

@NgModule({
  declarations: [AuthenticationComponent],
  imports: [
    CommonsModule,
    AntdesignModule,
    NgxUiLoaderModule.forRoot(ngxUiLoaderConfig),
    AuthenticationRoutingModule,
    RecaptchaV3Module
  ],
  exports: [],
  providers: [
    { provide: RECAPTCHA_V3_SITE_KEY, useValue: '6LeHs-UUAAAAAMhPIow2CLNBlgyuZTV2UXWBD5po' }
  ],
})
export class AuthenticationModule { }
