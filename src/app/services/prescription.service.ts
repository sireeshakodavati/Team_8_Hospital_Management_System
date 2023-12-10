import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Prescription } from '../model/prescription';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PrescriptionService {

  // constructor(private http:HttpClient) { }

  // baseURL:string = 'http://localhost:8383/api/prescription/';
  // add(body:Prescription):Observable<Prescription>{

  //   console.log(body);

  //     return this.http.post<Prescription>(this.baseURL+"add",body);

  // }

  constructor(private http: HttpClient) {}
  private authToken: string | null = null;

  setAuthToken(token: string): void {
    this.authToken = token;
  }

  private getHeaders(): HttpHeaders {
    // Check if authToken is available
    if (!this.authToken) {
      throw new Error('Auth token is missing.');
    }

    return new HttpHeaders({
      Authorization: `Bearer ${this.authToken}`,
    });
  }


  baseURL: string = 'http://localhost:8383/api/prescription/';

  add(body: Prescription): Observable<Prescription> {
    // Include the Authorization token in the request headers
    const headers = { Authorization: `Bearer ${this.authToken}` };

    return this.http.post<Prescription>(this.baseURL + 'add', body, { headers });
  }
}

