import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { LoadingBarService } from '@ngx-loading-bar/core';
import { ICurrency } from 'src/app/core/constants/globales.constants';
import { IndicatorsService } from 'src/app/core/services/indicators.service';
import { DetailIndicatorComponent } from './detail/detail-indicator/detail-indicator.component';

@Component({
  selector: 'app-indicators',
  templateUrl: './indicators.component.html',
  styleUrls: ['./indicators.component.scss']
})
export class IndicatorsComponent implements OnInit {
  loading = false;
  indicators: Array<ICurrency> = [];

  constructor(private indicatorService: IndicatorsService,
              public loader: LoadingBarService ) { }

  ngOnInit() {
    this.indicatorService.getIndicators().subscribe((indicators: Array<ICurrency>) => {
      this.indicators = indicators;
    });
  }

  loadIndicators = () => {
    this.loading = true;
    this.indicatorService.getIndicators().subscribe((indicators: Array<ICurrency>) => {
      this.loading = false;
      this.indicators = indicators;
    });
  }
}
