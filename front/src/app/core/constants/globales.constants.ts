
export enum API_SERVICES {
  LAST_INDICATORS = "bice-indicators/last",
  DETAIL_INDICATOR= "bice-indicators"
}

export interface ICurrency {
  key: string,
  name: string,
  unit: string,
  date: Date,
  value: Number,
  icon : String
}

export interface IDetailCurrency {
  key: string,
  name: string,
  unit: string,
  detail: Array<IYearStadistics>
}

export interface IYearStadistics {
  anio: string,
  months: Array<String>,
  stadistics :Array<IMonthStadistic>
}

export interface IMonthStadistic { 
  month: number,
  stadistic: IStadistic
}

export interface IStadistic { 
  count: number,
  sum: number,
  min: number,
  max: number,
  average: number
}

export enum Currency {
  COBRE = "cobre",
  ORO = "oro",
  PLATA = "plata",
  DOLAR = "dolar",
  EURO = "euro",
  IPC = "ipc",
  IVP = "ivp",
  UF = "uf",
  UTM = "utm",
  YEN = "yen"
}


