import { Card } from 'src/app/models/card.model';
import { CardService } from './../../services/card.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-user-pull-cards',
  templateUrl: './user-pull-cards.component.html',
  styleUrls: ['./user-pull-cards.component.css']
})

export class UserPullCardsComponent implements OnInit {

  //instance variables 
  cards: Card[];
  card: Card;
  userCardList: Card[];

  //constructor 
  constructor(private cardService: CardService) {

  }

  pullCards(): void {
    this.cardService.fetchAllCards()
      .subscribe(
        (cardList: any) => { this.cards = cardList; console.log(this.cards); },
        error => { console.log(error); }
      );
    console.log('populated users');
    console.log(this.cards);

  }

  pullCardsbyUserId() {

  }

  ngOnInit() {
    this.cardService.fetchAllCards()
      .subscribe(
        (cardList: any) => { this.cards = cardList; console.log(this.cards); },
        error => { console.log(error); }

      );
    console.log('these are cards: ', this.cards);
  }

  /*
  userId = 92;

  for(let i = 0; i <this.cards.length; i++) {

  if (this.cards[i].id = userId) {

    this.userCardList.push(this.cards[i]);
  }
}
console.log('Marys cards: ', this.cards);
 */

}

