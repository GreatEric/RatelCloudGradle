import {Inject, Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import { Observable, of } from "rxjs/index";
import { printLog } from "../core/globalconfig";

@Injectable({
    providedIn: 'root'
})
export class BaseService {
  baseUrl = 'http://localhost:8881';

  httpOptions = {
      headers: new HttpHeaders()
      .set('content-type', 'application/json')
  }

  http: HttpClient = null;

  constructor(@Inject(HttpClient) httpClient: HttpClient){
    this.http = httpClient;
  }

  public handleError<T>(operation = 'operation', result?: T) {
      return (error: any): Observable<T> => {
          this.log(`${operation} failed: ${error.message}`);
          return of(result as T);
      };
  }

  public log(message: any) {
    if(printLog) {
        console.log("======================================================================================");
        console.log(message);
        console.log("======================================================================================");
    }
  }
}
