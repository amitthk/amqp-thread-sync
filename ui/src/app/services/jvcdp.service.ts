import { Injectable, OnInit, OnDestroy } from '@angular/core';
import { HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { AppSettings } from '../../../app.settings';
import { S3LoginModel, BucketInfoModel, BucketDetailsModel } from '../models/index';
import { environment } from '../../../environments/environment';

@Injectable()
export class JvcdpService implements OnInit {
  private apiUrl:string;

  constructor(private http: HttpClient) {
    this.apiUrl=  AppSettings.envEndpoints.get(environment.env) || '/api' ;
  }

  ngOnInit(){

  }

  postS3bucketRequest(loginInfo: S3LoginModel): Observable<BucketInfoModel[]>{
    return this.http.post(this.apiUrl+'buckets', loginInfo, this.getOptions()).pipe(catchError(this.handleError<any>('deleteHero')));
  }

  postS3bucketObjectRequest(loginInfo: S3LoginModel): Observable<BucketDetailsModel[]>{
    return this.http.post(this.apiUrl+'bucketobjects', loginInfo, this.getOptions()).pipe(catchError(this.handleError<any>('deleteHero')));
  }

    private getOptions(): any {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    var options = { 'headers' : headers };
    return options;
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
  
      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
  

}
