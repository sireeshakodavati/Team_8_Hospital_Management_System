import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-appointmentform',
  templateUrl: './appointmentform.component.html',
  styleUrl: './appointmentform.component.css'
})
export class AppointmentformComponent {
  appointmentForm!: FormGroup;
  Submitted = false;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.appointmentForm = this.formBuilder.group({
      appointmentDate: ['', [Validators.required, Validators.pattern('\\d{4}-\\d{2}-\\d{2}')]],
      appointmentTime: ['', [Validators.pattern('^(1[0-2]|0?[1-9]):[0-5]\\d+:[0-5]\\d+ (AM|PM)$')]],
      status: ['', [Validators.pattern('[A-Z][a-z]{3,20}')]]
    });
  }
  get f() { return this.appointmentForm.controls; }

  onSubmit() {
    this.Submitted = true;
    if (this.appointmentForm.invalid) {
      return;
    }
    alert('Appointment Details added Successfully');
  }
}

