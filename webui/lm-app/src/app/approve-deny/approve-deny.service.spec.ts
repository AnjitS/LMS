import { TestBed, inject } from '@angular/core/testing';

import { ApproveDenyService } from './approve-deny.service';

describe('ApproveDenyService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ApproveDenyService]
    });
  });

  it('should be created', inject([ApproveDenyService], (service: ApproveDenyService) => {
    expect(service).toBeTruthy();
  }));
});
