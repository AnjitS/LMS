import { TestBed, inject } from '@angular/core/testing';

import { MyManagerDetailsService } from './my-manager-details.service';

describe('MyManagerDetailsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MyManagerDetailsService]
    });
  });

  it('should be created', inject([MyManagerDetailsService], (service: MyManagerDetailsService) => {
    expect(service).toBeTruthy();
  }));
});
