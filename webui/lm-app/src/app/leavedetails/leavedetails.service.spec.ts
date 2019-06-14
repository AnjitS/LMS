import { TestBed, inject } from '@angular/core/testing';

import { LeaveDetailsService } from './leavedetails.service';

describe('LeavedetailsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LeaveDetailsService]
    });
  });

  it('should be created', inject([LeaveDetailsService], (service: LeaveDetailsService) => {
    expect(service).toBeTruthy();
  }));
});
