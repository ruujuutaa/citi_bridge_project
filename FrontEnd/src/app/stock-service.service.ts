
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StockServiceService {

  constructor(private http : HttpClient) { }

  getStocks( sector  : string ) : Observable<any[]> {
    return this.http.get<any[]>("http://localhost:8080/"+sector);
  }
}
