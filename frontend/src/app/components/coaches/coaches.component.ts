import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Coach } from '../../model/Coach';
import { CoachService } from '../../services/coach.service';
import { CoachCardComponent } from '../coach-card/coach-card.component';
import { AsyncPipe, NgForOf } from '@angular/common';

@Component({
  selector: 'app-coaches',
  standalone: true,
  imports: [CoachCardComponent, AsyncPipe, NgForOf],
  templateUrl: './coaches.component.html',
})
export class CoachesComponent {
  coaches!: Observable<Array<Coach>>;

  constructor(private coachService: CoachService) {}

  ngOnInit() {
    this.fetchCoaches();
  }

  fetchCoaches() {
    this.coaches = this.coachService.getCoaches();
  }
}
