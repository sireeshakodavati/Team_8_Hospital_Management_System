import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import {HttpClientModule}  from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import{ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DoctorregistrationComponent } from './components/doctorregistration/doctorregistration.component';
import { HomeComponent } from './components/home/home.component';
import { PatientloginComponent } from './components/patientlogin/patientlogin.component';
import { PatientregistrationComponent } from './components/patientregistration/patientregistration.component';
import { AdminloginComponent } from './components/adminlogin/adminlogin.component';
import { DoctorloginComponent } from './components/doctorlogin/doctorlogin.component';
import {AboutusComponent} from './components/aboutus/aboutus.component';
import {ContactusComponent} from './components/contactus/contactus.component';
import {DashboardComponent} from './components/dashboard/dashboard.component';
import {DoctordashboardComponent} from './components/doctordashboard/doctordashboard.component';
import { CrudprescriptionComponent } from './components/crudprescription/crudprescription.component';
import { AppointmentformComponent } from './components/appointmentform/appointmentform.component';
import { PatientdashboardComponent } from './components/patientdashboard/patientdashboard.component';
import { AdmindashboardComponent } from './components/admindashboard/admindashboard.component';


@NgModule({
  declarations: [
    AppComponent,
    DoctorregistrationComponent,
    HomeComponent,
    PatientloginComponent,
    PatientregistrationComponent,
    AdminloginComponent,
    DoctorloginComponent,
    AboutusComponent,
    ContactusComponent,
    DoctordashboardComponent,
    DashboardComponent,
    CrudprescriptionComponent,
    AppointmentformComponent,
    PatientdashboardComponent,
    AdmindashboardComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
