import { Component } from '@angular/core';
import { HorseService } from '../../services/horse.service';
import { Observable } from 'rxjs';
import { Horse } from '../../model/Horse';
import { HorseCardComponent } from '../horse-card/horse-card.component';
import { AsyncPipe, NgForOf } from '@angular/common';

@Component({
  selector: 'app-horses',
  standalone: true,
  imports: [HorseCardComponent, AsyncPipe, NgForOf],
  templateUrl: './horses.component.html',
})
export class HorsesComponent {
  horses!: Observable<Array<Horse>>;

  constructor(private horseService: HorseService) {}

  ngOnInit() {
    this.fetchHorses();
  }

  fetchHorses() {
    this.horses = this.horseService.getHorses();
  }
}
