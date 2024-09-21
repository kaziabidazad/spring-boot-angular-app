import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { WitcherModel } from '../models/witcher-model';

@Injectable({
  providedIn: 'root'
})
export class WitcherService {

  constructor(
    private http: HttpClient
  ) { }

  private witcherBaseUrl: string = 'http://localhost:4201/witchers';

  getAllWitchers(limit: number = 100): Observable<any> {
    const getAllWitchersUrl: string = `${this.witcherBaseUrl}` + '?num=' + `${limit}`;
    console.log('get witchers url: ' + getAllWitchersUrl);
    return this.http.get<Array<WitcherModel>>(getAllWitchersUrl)
  }

  createWitcher(witcher: WitcherModel): Observable<WitcherModel> {
    const saveUrl = this.witcherBaseUrl;
    return this.http.post<WitcherModel>(saveUrl, witcher);
  }
}
