import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CardIndicatorComponent } from './card-indicator.component';

describe('CardIndicatorComponent', () => {
  let component: CardIndicatorComponent;
  let fixture: ComponentFixture<CardIndicatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CardIndicatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CardIndicatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
