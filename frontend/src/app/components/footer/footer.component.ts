import { Component } from '@angular/core';
import { ButtonComponent } from '../button/button.component';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [ButtonComponent],
  templateUrl: './footer.component.html',
})
export class FooterComponent {}
