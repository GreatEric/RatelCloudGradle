import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from "@angular/router";
import {ContextService} from "./context.service";

@Injectable()
export class AuthenticationGuard implements CanActivate{

  constructor(private router: Router, private contextService: ContextService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
      const user = this.contextService.user.getValue();
      if (user != null) {
          return true;
      }
      this.router.navigate(['/authentication'], { queryParams: { returnUrl: state.url } });
      return false;
  }
}
