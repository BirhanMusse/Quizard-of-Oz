import { UserLogging } from './../models/user-logging.model';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})


export class LogoutService {

  //instnace variables 
  endpoint = 'http://localhost:8096/P2/logout';


  //constructor 
  constructor(private httpClient: HttpClient) { }

  public userLogout(): Observable<UserLogging> {
    return this.httpClient.get<UserLogging>(`${this.endpoint}`); 
  }



}
