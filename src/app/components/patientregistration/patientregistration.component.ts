import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-patientregistration',
  templateUrl: './patientregistration.component.html',
  styleUrl: './patientregistration.component.css'
})
export class PatientregistrationComponent {
  registrationForm!: FormGroup;
  Submitted = false;

  constructor(private fb: FormBuilder) {}
  ngOnInit() {
    this.registrationForm = this.fb.group({
      userName: ['', [Validators.required, Validators.pattern('[A-Z][a-z]{3,20}')]],
      password: ['', [Validators.required]],
      patientName: ['', [Validators.required, Validators.pattern('[A-Z][a-z]{3,20}')]],
      dateOfBirth: ['', [Validators.pattern('\\d{4}-\\d{2}-\\d{2}')]],
      gender: ['', [Validators.pattern('[MF]')]],
      mobileNumber: ['', [Validators.pattern('\\d{10}')]],
      disease: ['', [Validators.required]],
      natureOfVisit: [''],
      preferredDate: ['', [Validators.pattern('\\d{4}-\\d{2}-\\d{2}')]],
      preferredTime: ['', [Validators.pattern('^(1[0-2]|0?[1-9]):[0-5]\\d+:[0-5]\\d+ (AM|PM)$')]],
      
    });
  }
  get f() {
    return this.registrationForm.controls;
  }

  onSubmit() {
    this.Submitted = true;

    if (this.registrationForm.valid) {
    
      return;

    }
    //alert('Patient Registration Successfull');
  }

}
