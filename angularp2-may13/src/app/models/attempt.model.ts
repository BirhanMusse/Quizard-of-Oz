//
import { UserCard } from './user-card.model';
import { Result } from './result.model';

 
export class Attempt {

    //instance variables
    id: number; 
    userCard: UserCard; 
    result: Result; 

    //constructor 
    constructor(id: number, userCard: UserCard, result: Result) {
        this.id = id; 
        this.userCard = userCard; 
        this.result = result; 
    }


}