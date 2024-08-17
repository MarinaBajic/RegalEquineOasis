import { Component } from '@angular/core';
import { ButtonComponent } from '../button/button.component';

@Component({
  selector: 'app-pony-rides',
  standalone: true,
  imports: [ButtonComponent],
  templateUrl: './pony-rides.component.html',
})
export class PonyRidesComponent {

}
