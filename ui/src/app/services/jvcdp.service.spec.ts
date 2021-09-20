/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { JvcdpService } from './jvcdp.service';

describe('JvcdpService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [JvcdpService]
    });
  });

  it('should ...', inject([JvcdpService], (service: JvcdpService) => {
    expect(service).toBeTruthy();
  }));
});
