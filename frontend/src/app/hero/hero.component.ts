import { Component } from '@angular/core';
import { ButtonComponent } from '../button/button.component';

@Component({
  selector: 'app-hero',
  standalone: true,
  imports: [ButtonComponent],
  templateUrl: './hero.component.html',
})
export class HeroComponent {}
