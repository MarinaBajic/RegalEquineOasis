import { NgClass } from '@angular/common';
import { booleanAttribute, Component, Input } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-button',
  standalone: true,
  imports: [NgClass, RouterLink, RouterLinkActive, RouterOutlet],
  templateUrl: './button.component.html',
})
export class ButtonComponent {
  @Input() routerLink: string = '';
  @Input() text: string = '';
  @Input() hierarchy: string = '';
}
