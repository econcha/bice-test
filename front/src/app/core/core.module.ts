import { CommonModule, DatePipe, TitleCasePipe } from "@angular/common"
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http"
import { NgModule, ModuleWithProviders } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms"
import { RouterModule } from "@angular/router"
import { LoadingBarHttpClientModule } from "@ngx-loading-bar/http-client";
import { ApiService } from "./services/api.service";
import { IndicatorsService } from "./services/indicators.service";
import { StorageService } from "./services/storage.service";


const coreModules = [
  CommonModule,
  HttpClientModule,
  RouterModule,
  ReactiveFormsModule,
  FormsModule
];

const customModules = [
  LoadingBarHttpClientModule
];

const pipes = [
  TitleCasePipe,
  DatePipe
];

const services = [
  StorageService,
  IndicatorsService,
  ApiService  
]


@NgModule({
  imports: [
    ...coreModules,
    ...customModules
  ],
  providers: [
    ...pipes,
    ...services
  ],
  declarations: [],
  exports: [
    ...pipes,
    ...coreModules,
    ...customModules
  ]
})
export class CoreModule {}​​​​
