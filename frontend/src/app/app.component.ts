import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import { HeroComponent } from './components/hero/hero.component';
import { HorsesComponent } from './components/horses/horses.component';
import { PonyRidesComponent } from './components/pony-rides/pony-rides.component';
import { CoachesComponent } from './components/coaches/coaches.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    HeaderComponent,
    HeroComponent,
    HorsesComponent,
    PonyRidesComponent,
    CoachesComponent,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {}
