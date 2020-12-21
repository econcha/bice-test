import { Injectable } from '@angular/core';

@Injectable()
export class StorageService {
  private keyToken = 'AuthenticationToken';

  getToken = () : string =>  {
    return sessionStorage.getItem(this.keyToken);
  }

  saveToken = (valueToken: string) : void => {
    sessionStorage.setItem(this.keyToken, valueToken);
  }

  destroyToken = () => {
    sessionStorage.clear();
  }
}
