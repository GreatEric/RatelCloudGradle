import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './layout/components/admin/admin.component';
import { IndexComponent } from "./dashboards/index/index.component";
import { SysmenuComponent } from "./dashboards/system/sysmenu/sysmenu.component";
import { SysuserComponent } from "./dashboards/system/sysuser/sysuser.component";

const routes: Routes = [
    {
        path: '',
        component: AdminComponent,
        children: [
            { path: 'index', component: IndexComponent, data: { title: 'Index',key: "System Index", animation: 'index', num: 1,isRemove: true,}},
            { path: 'sysmenu', component:  SysmenuComponent, data: { title: 'System Menu',key: "System Menu", animation: 'sysmenu', num: 2,isRemove: true,}},
            { path: 'sysuser', component:  SysuserComponent, data: { title: 'System User',key: "System User", animation: 'sysuser', num: 5,isRemove: true,}}
        ]
    }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
