import { Injectable } from '@angular/core';
import { Card } from 'src/app/models/card.model'

import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CardService {

  //instance variables
  endpoint = 'http://localhost:8096/P2/userCard';

  //constrcutor 
  constructor(private httpClient: HttpClient) { }


  //methods
  public fetchAllCards(): Observable<Card[]> {
    return this.httpClient.get<Card[]>(this.endpoint+`/all`);
  }






}
