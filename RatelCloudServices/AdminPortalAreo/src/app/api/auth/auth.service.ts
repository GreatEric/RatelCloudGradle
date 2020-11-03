import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs/index";
import {catchError} from "rxjs/operators";
import {tap} from "rxjs/internal/operators";
import {auth_req} from "./auth_req";
import {BaseService} from "../base.service";
import {R} from "../response";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private base: BaseService) {}

  login(req:auth_req): Observable<R> {
    let url:string = this.base.baseUrl + "/sysauth/login";

    return this.base.http.post<R>(url, req, this.base.httpOptions).pipe(
      tap(_ => this.base.log('login:'+url)),
      catchError(this.base.handleError<R>('login'))
    );
  }
}
