import { Component,OnInit} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtclientService } from '@app/services/jwtclient.service';


@Component({
  selector: 'app-doctorregistration',
  templateUrl: './doctorregistration.component.html',
  styleUrl: './doctorregistration.component.css'
})
export class DoctorregistrationComponent implements OnInit{
  doctorRegistrationForm!: FormGroup;
   Submitted = false;
   response:any;

   constructor(private fb: FormBuilder,private jwtClientService: JwtclientService) {
   }

   ngOnInit() {
     this.doctorRegistrationForm = this.fb.group({
       doctorName: ['', [Validators.required]],
       gender: ['', [Validators.pattern('[MF]')]],
       speciality: ['', [Validators.required]],
       experience: ['', [Validators.required]],
       qualification: ['', [Validators.pattern('^[A-Za-z\\s]+$')]],
       designation: [''],
       userName: ['', [Validators.required]],
       password: ['', [Validators.required]],
    
     });
   }

  get f()
   {
     return this.doctorRegistrationForm.controls;
  }

  onSubmit() {
    this.Submitted = true;

    if (this.doctorRegistrationForm.valid) {
      // Assuming you have an AuthService with a register method
      this.jwtClientService.registerDoctor(this.doctorRegistrationForm.value).subscribe(
        (response:any) => {
          // Handle successful registration
          console.log('Registration successful:', response);
          alert('Registration successful');

          // Save the JWT token securely (e.g., in localStorage)
          localStorage.setItem('token', response.token);

          // Redirect to another page or perform other actions
        },
        (error:any) => {
          // Handle registration error
          console.error('Registration failed:', error);
        }
      );
    }
  }  

}
