import { ModuleWithProviders, NgModule, Optional, SkipSelf } from '@angular/core';
import { CommonModule } from '@angular/common';
import { throwIfAlreadyLoaded } from "./core/module.import.guard";
import { FormsModule } from "@angular/forms";

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    CommonModule,
    FormsModule
  ]
})
export class CommonsModule {
  constructor(@Optional() @SkipSelf() parentModule: CommonsModule) {
    throwIfAlreadyLoaded(parentModule, 'CommonsModule');
  }

  static forRoot(): ModuleWithProviders {
    return {
      ngModule: CommonsModule,
      providers: [],
    };
  }
}
