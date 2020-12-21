import { NgModule, CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA, ModuleWithProviders } from "@angular/core";
import { MatButtonModule, MatCardModule, MatCheckboxModule, MatDatepickerModule, MatDialogModule, MatExpansionModule, MatProgressBarModule, MatProgressSpinnerModule, MatSelectModule, MatSlideToggleModule } from "@angular/material";
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { MatProgressButtonsModule } from 'mat-progress-buttons';
import { CardIndicatorComponent } from './card-indicator/card-indicator.component';
import { CoreModule } from "../core/core.module";
import { ChartsModule, ThemeService } from "ng2-charts";
import { ChartComponent } from './chart/chart.component';


const materialModules = [
  MatDialogModule,
  MatProgressSpinnerModule,
  MatCheckboxModule,
  MatProgressBarModule,
  MatExpansionModule,
  MatDatepickerModule,
  MatSlideToggleModule,
  MatCardModule,
  MatButtonModule,
  MatProgressButtonsModule,
  MatSelectModule
];


const sharedComponents = [
  NavbarComponent,
  FooterComponent,
  CardIndicatorComponent,
  ChartComponent
];
const customLibraries = [
  ChartsModule
];

@NgModule({
  imports: [
    CoreModule,
    ...materialModules,
    ...customLibraries
  ],
  declarations: [
    ...sharedComponents,
    CardIndicatorComponent
  ],
  exports: [
    ...materialModules,
    ...customLibraries,
    ...sharedComponents
  ],
  providers : [
    ThemeService
  ],
  entryComponents: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA]
})

export class SharedModule {}
