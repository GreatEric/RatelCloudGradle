import {AfterViewInit, Component, EventEmitter, HostListener, Input, OnInit, Output, ViewChild} from '@angular/core';
import {ActivatedRoute, NavigationEnd, Route, Router, RouterOutlet} from "@angular/router";
import {filter, map, mergeMap} from "rxjs/operators";
import {SysTab} from "../../../models/sys_tab";
import {LayoutService} from "../../services/layout.service";

import {NavigationService} from "../../services/navigation.service";
import {routerTransition} from "../../../animations/animations";
import {routeAnimation} from "../../../animations";
import {AppReuseStrategy} from "../../../app-reuse-strategy";

@Component({
  selector: 'app-tabpane',
  templateUrl: './tabpane.component.html',
  styleUrls: ['./tabpane.component.scss'],
  /*animations: [
    routeAnimation
  ]*/
  animations: [
    //routeAnimation
    routerTransition(),
  ]
})
export class TabpaneComponent implements OnInit {

  registedRoutes = new Array<Route>();

  currentTab: SysTab;
  //public tabs  = [{'title':'Index','url':'/dashboard/index'}];

  isOpen = false;

  tabs = [];

  currentIndex = -1;

  tabSubscription = null;

  public lastValue: any;
  public newValue: any;
  public animationValue: any;

  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,
              private layoutService: LayoutService,
              private navigationService: NavigationService) {

    this.currentTab = new SysTab();
    this.currentTab.title = 'Index';
    this.currentTab.url = '/dashboard/index';

    Object.keys(this.activatedRoute.routeConfig.children).map(key =>{
      let item = this.activatedRoute.routeConfig.children[key];
      if(item.path != ""){
        this.registedRoutes.push(item);
      }
    });

    this.router.events
        .pipe(filter(event => event instanceof NavigationEnd))
        .pipe(map(() => this.activatedRoute))
        .pipe(map(route => {
          while (route.firstChild) { route = route.firstChild; }
          return route;
        }))
        .pipe(filter(route => route.outlet === 'primary'))
        .pipe(mergeMap(route => route.data))
        .subscribe((event) => {
          const menu = {...event};
          // console.log("*************************************");
          menu.url = this.router.url;
          const url = menu.url;

          const exitMenu = this.tabs.find(info => info.url === url);
          if (!exitMenu) {// 如果不存在那么不添加，
            this.tabs.push(menu);
          }
          this.currentIndex = this.tabs.findIndex(p => p.url === url);

          this.lastValue = this.newValue;
          this.newValue = menu.num;
          this.animationValue = this.getAnimationNumber(this.lastValue, this.newValue);

          this.currentTab.title = menu.title;
          this.currentTab.url = menu.url;
        });

    /*this.router.events
        .pipe(filter(event => event instanceof NavigationEnd))
        .pipe(map(() => this.activatedRoute))
        .pipe(map(route => {
          while (route.firstChild) { route = route.firstChild; }
          return route;
        }))
        .pipe(mergeMap(route => route.data))
        .subscribe((event) => {
          const route = {...event};
          const url = this.router.url;

          this.currentTab.title = route.title;
          this.currentTab.url = url;

        });*/

    // this.tabSubscription = this.navigationService.tabsObservable.subscribe(menu => {
    //   this.tabs = menu;
    // });
  }

  ngOnInit() {}

  closeTab(url: string) {
    const index = this.tabs.findIndex(p => p.url === url);
    if (this.tabs.length === 1) {
      return;
    }
    this.tabs.splice(index, 1);

    AppReuseStrategy.deleteRouteSnapshot(url)

    if (this.currentIndex === index) {
      let menu = this.tabs[index - 1];
      if (!menu) {
        menu = this.tabs[index];
      }
      this.router.navigate([menu.url]);    }
  }

  onSelectChange($event) {
    this.currentIndex = $event.index;
    const menu = this.tabs[this.currentIndex];
    this.router.navigate([menu.url]);
  }

  toggleRightBar(){
    this.layoutService.toggleRightBar();
  }

  prepareRoute(outlet: RouterOutlet) {
    return outlet && outlet.activatedRouteData && outlet.activatedRouteData['animation'];
  }

  getAnimationNumber(lastValue: number, newValue: number) {
    let result = 0;
    if (lastValue && newValue) {
      result = 2;
      if (lastValue) {
        if (newValue > lastValue) {
          result = 2;
        } else {
          result = 1;
        }
      } else {
        result = 1;
      }
    }
    return result;
  }

  getRouteAnimation(outlet) {
    //console.log("animation:",this.navigationService.animationValue)
    return this.animationValue;
  }
}
