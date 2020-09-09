import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Topic } from '../models/topic.model';
import { Card } from '../models/card.model';

@Injectable({
  providedIn: 'root'
})
export class FlashcardService {

  readonly URL = 'http://localhost:8096/P2/card';
  
 //need endpoint
  readonly aURL = '';


  constructor(private http: HttpClient) { }

  public getFlashcards():Observable<Card[]>{
    return  this.http.get<Card[]>(this.URL+'/all');
  }

  public getTopics():Observable<Topic[]>{
    return  this.http.get<Topic[]>(this.URL+'/topic/all');
  }

  public addCard(card:Card): Observable<Card>{
    return this.http.post<Card>(this.URL, card)
  }

  //NEED TO ADD OTHER ENDPOINT
  public getSelectedFlashcards(id: number):Observable<Card[]>{
    return  this.http.get<Card[]>(`${this.aURL}/${id}`);
  } 

}
