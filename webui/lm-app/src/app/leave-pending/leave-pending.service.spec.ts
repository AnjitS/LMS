import { TestBed, inject } from '@angular/core/testing';

import { LeavePendingService } from './leave-pending.service';

describe('LeavePendingService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LeavePendingService]
    });
  });

  it('should be created', inject([LeavePendingService], (service: LeavePendingService) => {
    expect(service).toBeTruthy();
  }));
});
