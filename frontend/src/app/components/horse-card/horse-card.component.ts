import { Component, Input } from '@angular/core';
import { Horse } from '../../model/Horse';

@Component({
  selector: 'app-horse-card',
  standalone: true,
  imports: [],
  templateUrl: './horse-card.component.html',
})
export class HorseCardComponent {
  @Input()
  horse!: Horse;
}
