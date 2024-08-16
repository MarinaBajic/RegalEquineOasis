import { NgClass } from '@angular/common';
import { booleanAttribute, Component, Input } from '@angular/core';

@Component({
  selector: 'app-button',
  standalone: true,
  imports: [NgClass],
  templateUrl: './button.component.html',
})
export class ButtonComponent {
  @Input() text = '';
  @Input({ transform: booleanAttribute }) isPrimary: boolean = true;
}
