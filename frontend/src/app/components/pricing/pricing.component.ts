import { Component } from '@angular/core';
import { PricingCardComponent } from '../pricing-card/pricing-card.component';
import { AsyncPipe, NgForOf } from '@angular/common';
import { Observable } from 'rxjs';
import { SessionType } from '../../model/SessionType';
import { SessionService } from '../../services/session.service';

@Component({
  selector: 'app-pricing',
  standalone: true,
  imports: [PricingCardComponent, AsyncPipe, NgForOf],
  templateUrl: './pricing.component.html',
})
export class PricingComponent {
  sessionTypes!: Observable<Array<SessionType>>;

  constructor(private sessionService: SessionService) {}

  ngOnInit() {
    this.fetchSessionTypes();
  }

  fetchSessionTypes() {
    this.sessionTypes = this.sessionService.getSessionTypes();
  }
}
