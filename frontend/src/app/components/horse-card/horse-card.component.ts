import { Component, Input } from '@angular/core';
import { Horse } from '../../model/Horse';
import { AgePipe } from '../../pipes/age.pipe';

@Component({
  selector: 'app-horse-card',
  standalone: true,
  imports: [AgePipe],
  templateUrl: './horse-card.component.html',
})
export class HorseCardComponent {
  @Input()
  horse!: Horse;
}
