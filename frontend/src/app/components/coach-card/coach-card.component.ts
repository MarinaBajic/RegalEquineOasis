import { Component, Input } from '@angular/core';
import { Coach } from '../../model/Coach';

@Component({
  selector: 'app-coach-card',
  standalone: true,
  imports: [],
  templateUrl: './coach-card.component.html',
})
export class CoachCardComponent {
  @Input() coach!: Coach;
}
