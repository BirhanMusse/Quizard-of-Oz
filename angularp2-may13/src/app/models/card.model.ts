//
import { Topic } from './topic.model';

export class Card {

    //instance variables 
    id: number; 
    question: string; 
    answer: string; 
    topic: Topic; 

    //constructor
    constructor(id: number, question: string, answer: string, topic: Topic) {
        this.id =  id;
        this.question = question;
        this.answer = answer; 
        this.topic = topic; 
    }

}