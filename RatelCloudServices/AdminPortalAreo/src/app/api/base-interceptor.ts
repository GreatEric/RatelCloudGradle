import {Injectable} from '@angular/core';
import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse} from '@angular/common/http';

import { catchError, mergeMap, repeat, tap } from 'rxjs/operators';
import { Router } from '@angular/router';
import { Observable, of, throwError } from 'rxjs';
import { ContextService } from "../authentication/services/context.service";

/*
 * http请求拦截器
 */

@Injectable()
export class BaseInterceptor implements HttpInterceptor {

    constructor(private contextService: ContextService, private router: Router) {}

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        //通过Context Service 获取user信息
        const user = this.contextService.getUser();
        let authReq: any;

        /***** 拦截http请求 start*****/
        //如果token不等于null,将token写入请求header,否则请求不带token
        if (user!=null && user.token != null) {
            // authReq = req.clone({
            //     setHeaders: {
            //         'authorization': authToken
            //     }
            // });
            authReq = req.clone({
                headers: req.headers.set('token', user.token)
            });
        } else {
            authReq = req.clone();
        }
        /***** 拦截http请求 end*****/

        /***** 拦截http响应 start*****/
        return next.handle(authReq).pipe(
            tap((ev: HttpEvent<any>) => {
                if (ev instanceof HttpResponse) {
                    if (ev.status === 200) {

                    }
                }
            }),
            catchError(response => {
                if (response instanceof HttpErrorResponse) {
                }
                return throwError(response);
            })
        );
        /***** 拦截http响应 end*****/

        // return next.handle(authReq).pipe(
        //     mergeMap(event => {
        //         // 返回response
        //         if (event instanceof HttpResponse) {
        //             if (event.status === 200) {
        //                 // 若返回JWT过期但refresh token未过期,返回新的JWT 状态码为1005
        //                 if (event.body.meta.code === 1005) {
        //                     const jwt = event.body.data.jwt;
        //                     // 更新AuthorizationToken
        //                     this.authService.updateAuthorizationToken(jwt);
        //                     // clone request 重新发起请求
        //                     // retry(1);
        //                     authReq = req.clone({
        //                         setHeaders: {
        //                             'authorization': jwt,
        //                             'appId': uid
        //                         }
        //                     });
        //                     return next.handle(authReq);
        //
        //                 }
        //                 // jwt过期  清空本地信息跳转登录界面
        //                 if (event.body.meta.code === 1006) {
        //                     this.authService.logout();
        //                 }
        //                 // err jwt 情况本地信息跳转登录界面
        //                 if (event.body.meta.code === 1007) {
        //                     this.authService.logout();
        //                 }
        //             }
        //             if (event.status === 404) {
        //                 // go to 404 html
        //                 this.router.navigateByUrl('/404');
        //             }
        //             if (event.status === 500) {
        //                 // go to 500 html
        //                 this.router.navigateByUrl('/500');
        //             }
        //         }
        //         console.log(event);
        //         // 返回正常情况的可观察对象
        //         return of(event);
        //     }),
        //     catchError(this.handleError)
        // );
    }
    // private handleError(error: HttpErrorResponse) {
    //     if (error.error instanceof ErrorEvent) {
    //         // A client-side or network error occurred. Handle it accordingly.
    //         console.error('An error occurred:', error.error.message);
    //     } else {
    //         console.error( `Backend returned code ${error.status}, ` +
    //             `body was: ${error.error}`);
    //     }
    //     repeat(1);
    //     return new ErrorObservable('亲请检查网络');
    //
    // }
}
