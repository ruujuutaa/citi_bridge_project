import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(private http:HttpClient) { }

  logIn(data: any):Observable<any> {
    console.log("I am server");
    console.log(JSON.stringify(data));
    return this.http.post("http://localhost:8080/api/user/login", data);
  }
}
