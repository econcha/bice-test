import { Component, Inject, OnInit, Optional } from '@angular/core';
import { getMatIconFailedToSanitizeUrlError, MAT_DIALOG_DATA } from '@angular/material';
import { LoadingBarService } from '@ngx-loading-bar/core';
import { Currency, ICurrency, IDetailCurrency, IYearStadistics } from 'src/app/core/constants/globales.constants';
import { IndicatorsService } from 'src/app/core/services/indicators.service';

@Component({
  selector: 'app-detail-indicator',
  templateUrl: './detail-indicator.component.html',
  styleUrls: ['./detail-indicator.component.scss']
})
export class DetailIndicatorComponent implements OnInit {
  indicator : ICurrency;
  loading   = true;
  detail    : IDetailCurrency;
  anio : IYearStadistics;
  chart  = { 
    active: false,
    data : [],
    label: []
  }
  // public lineChartData: ChartDataSets[] = [
  //  { data: [65, 59, 80, 81, 56, 55, 40], label: 'Series A' },
  //];
  // public lineChartLabels: Label[] = ['January', 'February', 'March', 'April', 'May', 'June', 'July'];

  constructor(@Optional() @Inject(MAT_DIALOG_DATA)  public data,
              private indicatorService: IndicatorsService) { 
    this.indicator = this.data.parameters.indicator;
  }

  ngOnInit() {
    this.loadDetail();
  }

  loadDetail = () => {
    this.loading= true;
    this.indicatorService.getDetailIndicator(this.indicator.key as Currency).subscribe((detail: IDetailCurrency) => {
      this.detail = detail;
      this.loading= false;
    });
  }

  loadStadistics = () => {
     
      this.chart.data =  [
        { data: this.anio.stadistics.map(item =>  item.stadistic.average.toFixed(2)), label: 'Promedio de valor por mes' },
      ];
      this.chart.label= this.anio.months;
      this.chart.active = true;
  }

}
