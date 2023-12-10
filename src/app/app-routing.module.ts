import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ContactusComponent } from './components/contactus/contactus.component';
import { AboutusComponent } from './components/aboutus/aboutus.component';
import { DoctorloginComponent } from './components/doctorlogin/doctorlogin.component';
import { PatientloginComponent } from './components/patientlogin/patientlogin.component';
import { AdminloginComponent } from './components/adminlogin/adminlogin.component';
import { DoctorregistrationComponent } from './components/doctorregistration/doctorregistration.component';
import { PatientregistrationComponent } from './components/patientregistration/patientregistration.component';
import { DoctordashboardComponent } from './components/doctordashboard/doctordashboard.component';
import{DashboardComponent} from './components/dashboard/dashboard.component'
import { CrudprescriptionComponent } from './components/crudprescription/crudprescription.component';
import { PatientdashboardComponent } from './components/patientdashboard/patientdashboard.component';
import { AdmindashboardComponent } from './components/admindashboard/admindashboard.component';

const routes: Routes = [
  {path:'',component:DashboardComponent},
  {path:'home',component: HomeComponent},
  {path:'contactus',component:ContactusComponent},
  {path:'aboutus',component:AboutusComponent},
  {path:'doctorlogin',component:DoctorloginComponent},
  {path:'patientlogin',component:PatientloginComponent},
  {path:'adminlogin',component:AdminloginComponent},
  {path:'doctorregistration',component:DoctorregistrationComponent},
  {path:'patientregistration',component:PatientregistrationComponent},
  {path:'doctordashboard',component:DoctordashboardComponent},
  {path:'crudprescription',component:CrudprescriptionComponent},
  {path:'patientdashboard',component:PatientdashboardComponent},
  {path:'admindashboard',component:AdmindashboardComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
