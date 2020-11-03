import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DemosComponent } from './demos.component';
import { DemosRoutingModule } from "./demos-routing.module";



@NgModule({
  declarations: [DemosComponent],
  imports: [
    CommonModule,
    DemosRoutingModule
  ]
})
export class DemosModule { }
