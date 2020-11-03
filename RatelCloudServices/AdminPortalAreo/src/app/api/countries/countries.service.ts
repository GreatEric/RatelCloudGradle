import { Injectable } from '@angular/core';
import { Observable, of } from "rxjs/index";
import { catchError } from "rxjs/operators";
import { tap} from "rxjs/internal/operators"
import { BaseService } from "../base.service";
import { R} from "../response";

@Injectable({
  providedIn: 'root'
})
export class CountriesService{

    constructor(private base: BaseService) {}

    getCountryList(): Observable<R> {
        let url:string = this.base.baseUrl + "/sysInfo/locales";

        return this.base.http.get<R>(url, this.base.httpOptions).pipe(
            tap(_ => this.base.log('get country list:'+url)),
            catchError(this.base.handleError<R>('get country list'))
        );
    }
}
