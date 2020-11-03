import {AfterViewInit, Component, ElementRef, OnDestroy, OnInit, ViewChild} from '@angular/core';
import { LayoutService } from '../../layout/services/layout.service';
import { wordCloudOption } from '../../../core/globalconfig';
import {fadeInAnimation} from "../../animations";

/**
 * MangotechGroup
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 2020/5/20
 * @Description: Index主页
 */

/**
 * 初始化echarts插件
 */
declare var echarts: any;

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss'],
  animations: [fadeInAnimation],
  host: { '[@fadeInAnimation]': '' },
})
export class IndexComponent implements OnInit, AfterViewInit, OnDestroy{

  @ViewChild("wordCloud") wordCloudDiv: ElementRef;

  constructor(private layoutService: LayoutService) { }

  ngOnInit() {
  }

  ngAfterViewInit() {
    //this.makeWordCloud1();
  }

  ngOnDestroy() {

  }

  toggleRightBar(){
   this.layoutService.toggleRightBar();
  }

  makeWordCloud1(){
    console.log("WordCloud Div",this.wordCloudDiv.nativeElement);
      const chart = echarts.init(this.wordCloudDiv.nativeElement);

      chart.setOption(wordCloudOption);
      window.onresize = chart.resize;
  }
}
