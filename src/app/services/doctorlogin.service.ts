import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DoctorloginService {

  constructor(private http: HttpClient) { }
   baseURL: string = 'http://localhost:8383/api/';

   getGeneratedToken(requestBody: any) {
     return this.http.post(this.baseURL + "login/doctorlogin", requestBody, { responseType: 'text' as 'json' });
   }
  
   authorizationTestForUser(token: any): Observable<boolean> {
   
     const userAuthorized = !!token; 

     return of(userAuthorized); 
   }
}
