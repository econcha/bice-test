import { Component, OnInit } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { BUTTON_LOAD_INDICATORS } from 'src/app/core/constants/buttons.constans';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  BUTTON_LOAD_INDICATORS  = BUTTON_LOAD_INDICATORS;
  constructor(private router: Router) { }

  ngOnInit() {
  }

  loadIndicators = () => {
    this.BUTTON_LOAD_INDICATORS.active = true;
    setTimeout(() => {
      this.BUTTON_LOAD_INDICATORS.active = false;
      const params: NavigationExtras = { state: { permission: true } };
      this.router.navigate(['indicators'], params);
    }, 3500)
  }

}
