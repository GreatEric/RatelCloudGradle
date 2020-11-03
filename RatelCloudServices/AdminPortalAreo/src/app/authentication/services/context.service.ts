import { Injectable } from '@angular/core';
import {BehaviorSubject} from 'rxjs';
import {SessionService} from "./session.service";
import {User} from "../models/user";

const defaultUser = null;

@Injectable({
  providedIn: 'root'
})
export class ContextService {

    public user = new BehaviorSubject(defaultUser);

    constructor(private sessionService: SessionService) {
        const data = this.sessionService.getItem('currentUser');
        if (data != null) {
            this.user.next(data);
        }
    }

    public setUser(user: any): void{
        this.sessionService.setItem('currentUser', user);
        this.user.next(user);
    }

    public setLocale(locale: string): void{
        this.sessionService.setItem('locale', locale);
    }

    public getLocale(): any{
        this.sessionService.getItem('locale');
    }

    public getUser(): User{
        return this.sessionService.getItem('currentUser');
    }

    public logout() {
        this.sessionService.removeItem('currentUser');
        this.user.next(defaultUser);
    }
}
