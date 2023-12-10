import { Component,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrl: './adminlogin.component.css'
})
export class AdminloginComponent implements OnInit{
  Submitted: boolean = false;

  registerFormGroup!: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router) {
    console.log(this.router.config);
  }

  ngOnInit(): void {
    this.registerFormGroup = this.formBuilder.group({
      userName: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.maxLength(8)]]
    });
  }

  get f() {
    return this.registerFormGroup.controls;
  }

  onSubmit() {
    this.Submitted = true;
    if (this.registerFormGroup.invalid) {
      return;
    }

    alert('Admin-Login Successful');
  }


}
