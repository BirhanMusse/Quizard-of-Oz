import { UserLogging } from 'src/app/models/user-logging.model';
import { Credentials } from './../models/credentials.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})


export class LoginService {

  //instnace variables 
  endpoint = 'http://localhost:8096/P2/login';

  //constructor 
  constructor(private httpClient: HttpClient) { }

  
  public userLogin(credentials: Credentials): Observable<UserLogging> {
    //this.httpClient.post(`${this.endpoint}`,  );
    console.log("credentials in service: " + credentials)
    //this.httpClient.post<any>(`${this.endpoint}`, credentials).subscribe((data) => {});
    return this.httpClient.post<any>(`${this.endpoint}`, credentials); 
  }
  
  /*
  public userLogin(model: object): void {
  //this.httpClient.post(`${this.endpoint}`,  );
  console.log("model in service: " + model)
  this.httpClient.post<any>(`${this.endpoint}`, body).subscribe((data) => {});
  */

}
