import { Injectable } from '@angular/core';
import {ActivatedRoute, ActivationEnd, NavigationEnd, Router} from '@angular/router';
import {BehaviorSubject, Observable, Subject} from "rxjs";
import {filter, map, mergeMap} from "rxjs/operators";

@Injectable()
export class NavigationService {

  // private tab = new Subject();
  // tabsObservable =this.tab.asObservable();

  tabs = [];
  tabSubject: BehaviorSubject<any[]> = new BehaviorSubject<any>([]);
  tabsObservable: Observable<any> =  this.tabSubject.asObservable();

  public lastValue: any;
  public newValue: any;
  public animationValue: any;

  /*constructor(private router: Router) {
    this.router.events.subscribe((event) => {
      if (event instanceof ActivationEnd) {
        const snapshot = event.snapshot;
        if (snapshot.data.num) {
          this.lastValue = this.newValue;
          this.newValue = snapshot.data.num;
          this.animationValue = this.getAnimationNumber(this.lastValue, this.newValue);

          // const menu = {...event};
          // // console.log("*************************************");
          // console.log("路由",menu);
          // menu.url = this.router.url;
          // const url = menu.url;
          //
          // this.titleSource.next(title);
        }
      }
    });
  }*/

  constructor(private router: Router,private activatedRoute: ActivatedRoute) {
    // this.router.events
    //     .pipe(filter(event => event instanceof NavigationEnd))
    //     .pipe(map(() => this.activatedRoute))
    //     .pipe(map(route => {
    //       while (route.firstChild) { route = route.firstChild; }
    //       return route;
    //     }))
    //     .pipe(filter(route => route.outlet === 'primary'))
    //     .pipe(mergeMap(route => route.data))
    //     .subscribe((event) => {
    //       const menu = {...event};
    //       //console.log("路由",menu);
    //       menu.url = this.router.url;
    //       //const url = menu.url;
    //       //this.tab.next(menu);
    //
    //       const url = menu.url;
    //
    //       const exitMenu = this.tabs.find(info => info.url === url);
    //       if (!exitMenu) {// 如果不存在那么不添加，
    //         this.tabs.push(menu);
    //       }
    //       this.tabSubject.next(this.tabs);
    //       //this.currentIndex = this.tabs.findIndex(p => p.url === url);
    //
    //       this.lastValue = this.newValue;
    //       this.newValue = menu.num;
    //       this.animationValue = this.getAnimationNumber(this.lastValue, this.newValue);
    //     });
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
}
