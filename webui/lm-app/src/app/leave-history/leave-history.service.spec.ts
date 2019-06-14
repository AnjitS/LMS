import { TestBed, inject } from '@angular/core/testing';

import { LeaveHistoryService } from './leave-history.service';

describe('LeaveHistoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LeaveHistoryService]
    });
  });

  it('should be created', inject([LeaveHistoryService], (service: LeaveHistoryService) => {
    expect(service).toBeTruthy();
  }));
});
