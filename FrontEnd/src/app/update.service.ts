import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export default class UpdateService {

  constructor(private http:HttpClient) { }
  updateStocks(stock: string, username : string): Observable<any>
  {
    // let queryParams = new HttpParams();
    // queryParams = queryParams.append("stock",stock);
    // queryParams = queryParams.append("username",username);
    console.log(stock,username);
    var url = "http://localhost:8080/api/user/update/"+stock+"/"+username;
    console.log(url);
    return this.http.get<any>(url);
    

  }
}
