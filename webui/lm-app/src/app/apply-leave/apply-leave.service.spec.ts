import { TestBed, inject } from '@angular/core/testing';

import { ApplyLeaveService } from './apply-leave.service';

describe('ApplyLeaveService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ApplyLeaveService]
    });
  });

  it('should be created', inject([ApplyLeaveService], (service: ApplyLeaveService) => {
    expect(service).toBeTruthy();
  }));
});
