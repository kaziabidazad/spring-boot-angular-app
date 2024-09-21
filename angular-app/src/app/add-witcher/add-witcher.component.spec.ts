import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddWitcherComponent } from './add-witcher.component';

describe('AddWitcherComponent', () => {
  let component: AddWitcherComponent;
  let fixture: ComponentFixture<AddWitcherComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AddWitcherComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddWitcherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
