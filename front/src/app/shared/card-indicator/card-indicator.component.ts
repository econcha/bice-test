import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { BUTTON_LOAD_INDICATORS } from 'src/app/core/constants/buttons.constans';
import { ICurrency } from 'src/app/core/constants/globales.constants';
import { DetailIndicatorComponent } from 'src/app/landing/indicators/detail/detail-indicator/detail-indicator.component';

@Component({
  selector: 'app-card-indicator',
  templateUrl: './card-indicator.component.html',
  styleUrls: ['./card-indicator.component.scss']
})
export class CardIndicatorComponent implements OnInit {
  @Input() currency : ICurrency;
  GET_DETAIL_BUTTON  = {... BUTTON_LOAD_INDICATORS};
  constructor(public dialog: MatDialog) {
  }

  ngOnInit() {

  }


  getDetailCurrency = () => {
    const dialogRef = this.dialog.open(DetailIndicatorComponent , {
      data: {
        parameters: {
           indicator : {... this.currency}
        }
      }
    });
  
    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }

}
