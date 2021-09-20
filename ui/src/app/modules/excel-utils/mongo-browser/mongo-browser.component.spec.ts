import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MongoBrowserComponent } from './mongo-browser.component';

describe('MongoBrowserComponent', () => {
  let component: MongoBrowserComponent;
  let fixture: ComponentFixture<MongoBrowserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MongoBrowserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MongoBrowserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
