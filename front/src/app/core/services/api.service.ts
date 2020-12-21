import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class ApiService {
  constructor(
    private readonly http: HttpClient
  ) {}


  addHttpParams(params): HttpParams {
    const keys = Object.keys(params);
    let queryParams: HttpParams = new HttpParams();
    for (const key of keys) {
      if (params[key]) {
        queryParams = queryParams.append(key, params[key]);
      }
    }
    return queryParams;
  }

  get(path: string, apiUrl: string, params?: any): Observable<any> {
    return this.http.get(`${apiUrl}${path}`, params);
  }

  put(path: string, body: any = {}, apiUrl: string, params?: any): Observable<any> {
    return this.http.put(`${apiUrl}${path}`, JSON.stringify(body), params);
  }

  post(path: string, body: any = {}, apiUrl: string, params?: any): Observable<any> {
    return this.http.post(`${apiUrl}${path}`, JSON.stringify(body), params);
  }

  delete(path: string, apiUrl: string, params?: any): Observable<any> {
    return this.http.delete(`${apiUrl}${path}`, params);
  }
}
