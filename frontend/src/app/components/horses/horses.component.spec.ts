import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HorsesComponent } from './horses.component';

describe('HorsesComponent', () => {
  let component: HorsesComponent;
  let fixture: ComponentFixture<HorsesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HorsesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HorsesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
