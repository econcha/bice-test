import { NgModule, CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { LandingRoutingModule } from './landing-routing.module';
import { IndicatorsComponent } from './indicators/indicators.component';
import { CoreModule } from '../core/core.module';
import { SharedModule } from '../shared/shared.module';
import { HomeComponent } from './home/home.component';
import { DetailIndicatorComponent } from './indicators/detail/detail-indicator/detail-indicator.component';
import { ChartsModule } from 'ng2-charts';


@NgModule({
  imports: [
    SharedModule,
    CoreModule,
    LandingRoutingModule
  ],
  declarations: [
    IndicatorsComponent,
    HomeComponent,
    DetailIndicatorComponent
  ],
  entryComponents : [
    DetailIndicatorComponent
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA]
})
export class LandingModule {}
