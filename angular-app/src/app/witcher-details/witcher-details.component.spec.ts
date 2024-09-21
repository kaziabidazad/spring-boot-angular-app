import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WitcherDetailsComponent } from './witcher-details.component';

describe('WitcherDetailsComponent', () => {
  let component: WitcherDetailsComponent;
  let fixture: ComponentFixture<WitcherDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [WitcherDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WitcherDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
