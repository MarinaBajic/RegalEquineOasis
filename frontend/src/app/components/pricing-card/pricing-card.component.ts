import { Component, Input } from '@angular/core';
import { SessionType } from '../../model/SessionType';
import { ButtonComponent } from '../button/button.component';

@Component({
  selector: 'app-pricing-card',
  standalone: true,
  imports: [ButtonComponent],
  templateUrl: './pricing-card.component.html',
})
export class PricingCardComponent {
  @Input() sessionType!: SessionType;
}
