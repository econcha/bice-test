import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_SERVICES, Currency, ICurrency, IDetailCurrency } from '../constants/globales.constants';
import { ApiService } from './api.service';

@Injectable()
export class IndicatorsService {
  private path: string = "http://localhost:8096/";
  
  constructor(private apiService: ApiService) {}


  getIndicators = () : Observable<Array<ICurrency>> =>  {
      return this.apiService.get(API_SERVICES.LAST_INDICATORS,this.path);
  }

  getDetailIndicator = (currency: Currency) : Observable<IDetailCurrency> =>  {
    return this.apiService.get(`${API_SERVICES.DETAIL_INDICATOR}/${currency}/detail` ,this.path);
  }
}
