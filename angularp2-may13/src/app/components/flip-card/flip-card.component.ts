import { Component, OnInit } from '@angular/core';

import { FlashcardService} from 'src/app/services/flashcard.service';
import { Topic } from 'src/app/models/topic.model';
import { Card } from 'src/app/models/card.model';

@Component({
  selector: 'app-flip-card',
  templateUrl: './flip-card.component.html',
  styleUrls: ['./flip-card.component.css']
})
export class FlipCardComponent implements OnInit {
flashcards: Card[];
flashcard: Card;
topics: Topic[];
topic: Topic;

  
    constructor(private flashcardService:FlashcardService) { }
  
    loadFlashCards(): void{
      this.flashcardService.getFlashcards()
      .subscribe(
      (flashcardList: any) => { this.flashcards = flashcardList;
        for (let i = 0 ; i < this.flashcards.length; i ++){
          console.log(this.flashcards[i].id);
        }
        },
      error => { console.log(error); }
      )
  
    }
    loadTopics(): void{
      this.flashcardService.getTopics()
      .subscribe(
        (topicList: any) => {this.topics = topicList;
        console.log(this.topics);
  
      },
      error => { console.log(error); }
      )
      
    }
     flashCatagory='';
     questionsmastered=0;
     StoredId=0;
    Mastered:boolean=true;
    
    questionMastered(flashcard:Card):void{
  this.flashcards = this.flashcards.filter(f => f.id!== flashcard.id)
  this.questionsmastered++;
  console.log(this.questionsmastered);
  //you have mastered "questionmastered" {{flashcard.topic.topicName}} questiong
    }
  
    
    
  
  
    filterFlashCards(filter: string): void{
  
  
      this.flashCatagory= filter;
     
      
      
    }
    
    ngOnInit() {
      this.loadFlashCards();
      this.loadTopics();
  
  
      
    }
  
  }