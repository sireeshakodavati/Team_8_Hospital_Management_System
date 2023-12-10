import { Component,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthRequest } from '@app/model/AuthRequest';
import { JwtclientService } from '@app/services/jwtclient.service';

@Component({
  selector: 'app-patientlogin',
  templateUrl: './patientlogin.component.html',
  styleUrl: './patientlogin.component.css'
})
export class PatientloginComponent implements OnInit{
  response:any;
  token:any;


  authRequest: AuthRequest=new AuthRequest();
  jwtclientService: any;
  

constructor(private jwtService:JwtclientService,private router:Router){}
  
  ngOnInit(): void {
  
    // this.getAccessToken(this.authRequest);
 }
 
 
  readFormData(formData:any){
 
     this.authRequest.username = formData.form.value.username;
     this.authRequest.password = formData.form.value.password;
 
     this.getAccessToken(this.authRequest);
 
  }
 
 public getAccessToken(authRequest:any){
 
  let response =  this.jwtService.getGeneratedToken(authRequest);
 
     response.subscribe( (genToken)=> {  this.token = genToken ;console.log(genToken);  this.accessApi(this.token) });
 
 }
 
 accessApi(token:any){
 
 let response =    this.jwtService.authorizationTest(token);
 
       response.subscribe( responseData => {this.response = responseData; console.log(responseData) ; console.log(token); this.navigatetodoctordashboard();});
 
 }
 navigatetodoctordashboard()
 {
   this.router.navigate(['/patientdashboard']);
 }
 login() {
   this.jwtclientService.getGeneratedToken(this.readFormData).subscribe(
     (token:any) => {
       // Set the token in the JwtclientService
       this.jwtclientService.setToken(token);
     },
     (error:any) => {
       // Handle login error
     }
   );
 }
  
  }
  

