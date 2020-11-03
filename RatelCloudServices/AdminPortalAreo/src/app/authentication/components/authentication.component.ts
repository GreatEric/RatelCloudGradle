import {AfterViewInit, Component, OnDestroy, OnInit} from '@angular/core';
import { NgxUiLoaderService } from "ngx-ui-loader";
import { NzMessageService } from "ng-zorro-antd";
import { en_US, NzI18nService } from 'ng-zorro-antd/i18n';
import { OnExecuteData, ReCaptchaV3Service} from 'ng-recaptcha';
import { RouteStateService } from "../services/route-state.service";
import { ContextService } from "../services/context.service";
import { User } from "../models/user";
import { auth_req } from "../../api/auth/auth_req";
import { AuthService } from "../../api/auth/auth.service";
import { Subscription } from "rxjs/index";
import { CountriesService} from "../../api/countries/countries.service";
import { country} from "../../api/countries/country";

declare var ParticleSlider: any;

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.scss']
})
export class AuthenticationComponent implements OnInit, AfterViewInit, OnDestroy {

  userName: string | null;
  password: string | null;
  passwordVisible = false;
  lang: string | null;

  ps: any;
  ptl: any;
  private subscription: Subscription;

  countries: Array<country>;

  constructor(private loaderService: NgxUiLoaderService,
              private messageService: NzMessageService,
              private authService: AuthService,
              private coutriesService: CountriesService,
              private contextService: ContextService,
              private routeStateService: RouteStateService,
              private i18n: NzI18nService,
              private recaptchaV3Service: ReCaptchaV3Service) { }

  ngOnInit(): void {
    this.coutriesService.getCountryList().subscribe(R => {
        this.countries = R.data.locales;
        this.lang = this.countries[0].locale_id;
    });

    this.subscription = this.recaptchaV3Service.onExecute.subscribe((data: OnExecuteData) => {
    });

    this.userName = "admin";
    this.password = "mangotech";
  }

  ngAfterViewInit() {
    // this.ps = new ParticleSlider({
    //     mouseForce: 100,
    //     monochrome: true ,
    //     color: '#000' ,
    //     ptlGap: 1 ,
    //     ptlSize: 1,
    //     width: 160,
    //     height: 110
    // });
    // this.ptl = new this.ps.Particle(this.ps);
    // this.ptl.ttl = 20;
  }

  ngOnDestroy() {
    // this.ps = null;
    // this.ptl = null;
    // ParticleSlider = null;

    if (this.subscription) {
      this.subscription.unsubscribe();
  　}
  }

  onClickLogin(reptchaToken: string) {
    this.loaderService.start();

    const req: auth_req = new auth_req();
    req.userName = this.userName;
    req.password = this.password;
    req.captcha = reptchaToken;
    req.locale = this.lang.substr(0,2);

    this.authService.login(req).subscribe(R => {
        if(R.code === 1000){
            const user: User = new User();
            user.uname = R.data.uname;
            user.uid = R.data.uid;
            user.avatar = R.data.avatar;
            user.token = R.data.token;

            this.contextService.setUser(user);
            this.contextService.setLocale(req.locale);

            this.loaderService.stop();

            this.routeStateService.add('Dashboard', '/dashboard/index', null, true);
            return;
        }else{
            this.loaderService.stop();
            this.messageService.error(R.msg);
            return;
        }
    });
    return;
  }

  public captchaValidate(): void {
    this.recaptchaV3Service.execute('importantAction').subscribe((token) => {
        if(token){
            this.onClickLogin(token);
        }
    });
  }

  switchLanguage() {
    this.i18n.setLocale(en_US);
  }
}
