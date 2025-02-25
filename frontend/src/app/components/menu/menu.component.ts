import { Component } from '@angular/core';
import { ButtonComponent } from '../button/button.component';
import { Router, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { NgIf } from '@angular/common';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [ButtonComponent, RouterLink, RouterLinkActive, RouterOutlet, NgIf],
  templateUrl: './menu.component.html',
})
export class MenuComponent {
  constructor(public authService: AuthService, private router: Router) {}

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/home']);
  }
}
