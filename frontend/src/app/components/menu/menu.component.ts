import { Component } from '@angular/core';
import { ButtonComponent } from '../button/button.component';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [ButtonComponent, RouterLink, RouterLinkActive, RouterOutlet],
  templateUrl: './menu.component.html',
})
export class MenuComponent {

}
