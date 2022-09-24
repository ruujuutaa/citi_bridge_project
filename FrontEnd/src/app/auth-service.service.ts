import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  public username :string;
  constructor(private http:HttpClient) { }

  logIn(user: User):Observable<any> {

    console.log("I am server");
    console.log(JSON.stringify(user));
    return this.http.post("http://localhost:8080/api/user/login", user);
  }
  setUsername(userName : string) {
    this.username = userName;
  }
  
}
