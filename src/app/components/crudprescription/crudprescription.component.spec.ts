import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrudprescriptionComponent } from './crudprescription.component';

describe('CrudprescriptionComponent', () => {
  let component: CrudprescriptionComponent;
  let fixture: ComponentFixture<CrudprescriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CrudprescriptionComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CrudprescriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
