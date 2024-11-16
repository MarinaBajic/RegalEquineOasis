import { Component } from '@angular/core';
import { AboutComponent } from '../../components/about/about.component';
import { CoachesComponent } from '../../components/coaches/coaches.component';
import { HeroComponent } from '../../components/hero/hero.component';
import { HorsesComponent } from '../../components/horses/horses.component';
import { PonyRidesComponent } from '../../components/pony-rides/pony-rides.component';
import { PricingComponent } from '../../components/pricing/pricing.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    HeroComponent,
    HorsesComponent,
    AboutComponent,
    PonyRidesComponent,
    CoachesComponent,
    PricingComponent,
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {}
