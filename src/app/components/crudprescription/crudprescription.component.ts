import { Component} from '@angular/core';
import { Prescription } from '@app/model/prescription';
import { PrescriptionService } from '@app/services/prescription.service';

@Component({
  selector: 'app-crudprescription',
  templateUrl: './crudprescription.component.html',
  styleUrl: './crudprescription.component.css'
})
export class CrudprescriptionComponent {

   constructor(private  prescriptionService:PrescriptionService){}
  ngOnInit(): void {
  }
 addPrescription(data:Prescription){
    
    this.prescriptionService.add(data)
      .subscribe(
         (prescription)=>{console.log('Added Prescription  is: '+prescription);}
         );
  

       }

        
  
}

