import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthenticationGuard } from "./authentication/services/authentication-guard.service";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'authentication',
    pathMatch: 'full'
  },
  {
    path: 'authentication',
    loadChildren: () => import('./authentication/authentication.module').then(m => m.AuthenticationModule)
  },
  {
    path: 'dashboard',
    loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule),
    canActivate: [AuthenticationGuard]
  },
  {
    path: 'demos',
    loadChildren: () => import('./demos/demos.module').then(m => m.DemosModule),
    canActivate: [AuthenticationGuard]
  },
  // {
  //     path: 'main',
  //     component: LayoutComponent,
  //     children: [{
  //         path: 'dashboard',
  //         loadChildren: () => import('../@views/dashboard/dashboard.module').then(m => m.DashboardModule),
  //         canActivate: [AuthGuard]
  //     }]
  // },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
