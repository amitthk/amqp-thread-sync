import { Injectable, OnInit, OnDestroy } from '@angular/core';
import { HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppSettings } from '../../../app.settings';
import { UserLogin } from '../models/index';
import { environment } from '../../../environments/environment';

@Injectable()
export class AuthService {
  private apiUrl: String;

  constructor(private http: HttpClient) {
    this.apiUrl = AppSettings.API_ENDPOINT + '/auth';
  }

  login(loginInfo: UserLogin): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const options = { 'headers': headers };
    return this.http.post(this.apiUrl + '/login', loginInfo, options);
  }

  logout(): void{
    localStorage.removeItem('authToken');
  }

}
