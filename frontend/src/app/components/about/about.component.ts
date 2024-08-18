import { Component } from '@angular/core';
import { ButtonComponent } from '../button/button.component';

@Component({
  selector: 'app-about',
  standalone: true,
  imports: [ButtonComponent],
  templateUrl: './about.component.html',
})
export class AboutComponent {}
