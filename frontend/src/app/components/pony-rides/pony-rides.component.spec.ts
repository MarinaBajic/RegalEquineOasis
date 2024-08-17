import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PonyRidesComponent } from './pony-rides.component';

describe('PonyRidesComponent', () => {
  let component: PonyRidesComponent;
  let fixture: ComponentFixture<PonyRidesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PonyRidesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PonyRidesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
