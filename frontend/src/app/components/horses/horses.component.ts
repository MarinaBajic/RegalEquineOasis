import { Component } from '@angular/core';
import { HorseService } from '../../services/horse.service';
import { Observable } from 'rxjs';
import { Horse } from '../../model/Horse';

@Component({
  selector: 'app-horses',
  standalone: true,
  imports: [],
  templateUrl: './horses.component.html',
})
export class HorsesComponent {
  horses: Observable<Array<Horse>> | undefined;

  constructor(private horseService: HorseService) {}

  ngOnInit() {
    this.fetchHorses();
  }

  fetchHorses() {
    this.horses = this.horseService.getHorses();
  }
}
