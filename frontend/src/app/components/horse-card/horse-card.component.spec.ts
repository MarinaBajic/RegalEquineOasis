import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HorseCardComponent } from './horse-card.component';

describe('HorseCardComponent', () => {
  let component: HorseCardComponent;
  let fixture: ComponentFixture<HorseCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HorseCardComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HorseCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
