import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Attempt} from '../models/attempt.model';

@Injectable({
  providedIn: 'root'
})
export class AttemptService {

    readonly URL = 'http://localhost:8096/P2/attempt';

  constructor(private httpClient: HttpClient) { }
  public getAttempts(): Observable<Attempt[]> {
    return this.httpClient.get<Attempt[]>(this.URL+`/all`);
  }
}
