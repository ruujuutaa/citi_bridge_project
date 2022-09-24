import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Stock } from './stock';

@Injectable({
  providedIn: 'root'
})
export default class UpdateService {
  
  constructor(private http:HttpClient) { }
  updateStocks(stock: string, username : string)
  {
    // let queryParams = new HttpParams();
    // queryParams = queryParams.append("stock",stock);
    // queryParams = queryParams.append("username",username);
    console.log(stock,username);
    var url = "http://localhost:8080/api/user/update/"+stock+"/"+username;
    console.log(url);
    this.http.get<any>(url).subscribe();
    

  }

  getSavedStocks(username : string) : Observable<any[]>{
    return this.http.get<any[]>("http://localhost:8080/api/user/saved/"+username);
  }
  removeStock(stock: string, username : string){
    return this.http.get("http://localhost:8080/api/user/remove/"+stock+"/"+username).subscribe();
  }
}
