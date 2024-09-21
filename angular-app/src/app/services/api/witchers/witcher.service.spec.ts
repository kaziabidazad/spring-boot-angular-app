import { TestBed } from '@angular/core/testing';

import { WitcherService } from './witcher.service';

describe('WitcherService', () => {
  let service: WitcherService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WitcherService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
