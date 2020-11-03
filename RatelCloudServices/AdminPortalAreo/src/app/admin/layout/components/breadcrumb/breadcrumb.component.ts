import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import { LayoutService } from '../../services/layout.service';
import { Ng2ScreenshotAPI } from 'ng2-screenshot';
import { SwiperComponent, SwiperConfigInterface } from "ngx-swiper-wrapper";
import { SysTab } from "../../../models/sys_tab";
import { swipeAnimation } from "../../../animations";

@Component({
  selector: 'app-breadcrumb',
  templateUrl: './breadcrumb.component.html',
  styleUrls: ['./breadcrumb.component.scss'],
  animations: [
    swipeAnimation
  ]
})
export class BreadcrumbComponent implements AfterViewInit{

    currentTab: SysTab;
    public tabs  = [{'title':'Index','url':'/dashboard/index'}];

    isOpen = false;
    api: Ng2ScreenshotAPI;

    @ViewChild(SwiperComponent, { static: false }) componentRef?: SwiperComponent;

    public config: SwiperConfigInterface = {
        a11y: true,
        direction: 'horizontal',
        slidesPerView: 1,
        keyboard: true,
        mousewheel: true,
        scrollbar: false,
        navigation: false,
        pagination: false
    };

    public disabled: boolean = false;

    constructor(private layoutService: LayoutService) {
        this.currentTab = new SysTab();
        this.currentTab.title = 'Index';
        this.currentTab.url = '/dashboard/index';
    }

    ngAfterViewInit(): void {

    }

    public onIndexChange(index: number): void {
        //console.log('Swiper index: ', index);
    }

    public onSwiperEvent(event: string): void {
        //console.log('Swiper event: ', event);
    }

    toggleRightBar(){
        this.layoutService.toggleRightBar();
    }

    isOpenChange($event: boolean) {
        this.isOpen = $event;
        //console.log("isOpenChange",this.isOpen);
    }

    apiInitialized($event: Ng2ScreenshotAPI) {
        this.api = $event;
        //console.log("api",this.api);
    }

    cancel() {
        this.api.cancel();
    }

    download() {
        this.api.download();
    }

    getCurrentTab(emittedTab:SysTab){
        const exitMenu = this.tabs.find(tab => tab.url === emittedTab.url);
        if (!exitMenu) {
            this.tabs.push({'title':emittedTab.title,'url':emittedTab.url});
        }
        this.currentTab = emittedTab;
        let currentTabIndex = this.tabs.findIndex(tab => tab.url === emittedTab.url);
        //this.componentRef.directiveRef.setIndex(currentTabIndex,1000);
        this.isOpen=true;
        console.log("history tabs:",this.tabs);
    }

    onAnimationEvent ( event: AnimationEvent ) {
        // if(event.toState === 'closed'){
        //     this.isOpen=false;
        // }
    }



}