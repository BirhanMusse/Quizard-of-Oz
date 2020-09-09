import { CardState } from './card-state.model';
import { Card } from './card.model';
import { User } from './user.model';
//

export class UserCard {

//instnace variables 
id: string; 
user: User; 
card: Card; 
cardState: CardState; 

//constructor 
constructor(id: string, user: User, card: Card, cardState: CardState) {
    this.id = id; 
    this.user = user; 
    this.card = card; 
    this.cardState = cardState; 
}

}
