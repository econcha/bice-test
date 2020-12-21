import { NgModule } from '@angular/core';
import { Routes, RouterModule, PreloadAllModules } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { IndicatorsComponent } from './indicators/indicators.component';

export const routes: Routes = [
    {
      path: '',
      component: HomeComponent
    },
    {
      path: 'indicators',
      component: IndicatorsComponent
    }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LandingRoutingModule { }

