import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class JwtclientService {
  prescriptionService: any;
 

  constructor(private http:HttpClient) { }
  private authTokenKey = 'auth_token';

  setToken(token: string): void {
    localStorage.setItem(this.authTokenKey, token);
  }
  
  baseURL:string='http://localhost:8383/api';

  getGeneratedToken(requestBody: any){

      return this.http.post(this.baseURL+"/login/doctorlogin",requestBody,{responseType: 'text' as 'json'});

  }
   registerDoctor(requestBody:any)
   {
   return this.http.post(this.baseURL+"/doctor/add",requestBody,{responseType:'text'as 'json'})
    }
 

  authorizationTest(token:any){

        let tokenString = "Bearer "+token;

       const headers =  new HttpHeaders().set("Authorization",tokenString);

      return this.http.get(this.baseURL+"/prescription/fetchAll",{headers,responseType:'text' as 'json'});

  }
  addPrescription() {
    this.prescriptionService.add(this.prescriptionBody).subscribe(
      (prescription:any) => {
        // Handle successful prescription creation
        console.log('Prescription added:', prescription);
      },
      (error:any) => {
        // Handle prescription creation error
        console.error('Error adding prescription:', error);
      }
    );
  }
  prescriptionBody(prescriptionBody: any) {
    throw new Error('Method not implemented.');
  }
  


}
