import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WitcherComponent } from './witcher.component';

describe('WitcherComponent', () => {
  let component: WitcherComponent;
  let fixture: ComponentFixture<WitcherComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [WitcherComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WitcherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
