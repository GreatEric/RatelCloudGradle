import { Injectable } from '@angular/core';
import {BaseService} from "../base.service";
import {Observable} from "rxjs/index";
import {catchError} from "rxjs/operators";
import {tap} from "rxjs/internal/operators";
import {R} from "../response";

@Injectable({
  providedIn: 'root'
})
export class SysmenuService{

    constructor(private base: BaseService) {}

    getSysMenu(): Observable<R> {
        let url:string = this.base.baseUrl + "/sys/menu/nav";

        return this.base.http.get<R>(url, this.base.httpOptions).pipe(
            tap(_ => this.base.log('get sysmenu list:'+url)),
            catchError(this.base.handleError<R>('get sysmenu list'))
        );
    }
}
