import { Component, OnInit, Inject } from '@angular/core';
import { FlashcardService } from 'src/app/services/flashcard.service';
import { Topic } from 'src/app/models/topic.model';
import { Card } from 'src/app/models/card.model';
import { SESSION_STORAGE, StorageService } from 'angular-webstorage-service';

@Component({
  selector: 'app-set-study',
  templateUrl: './set-study.component.html',
  styleUrls: ['./set-study.component.css']
})
export class SetStudyComponent implements OnInit {

  flashcards: Card[];
  flashcard: Card;
  topics: Topic[];
  topic: Topic;
  id: number;
  
  
    
      // constructor(private flashcardService:FlashcardService, @Inject(SESSION_STORAGE) private storage: StorageService) { }

      constructor(private flashcardService:FlashcardService) { }
    
      loadFlashCards(): void{
        this.flashcardService.getSelectedFlashcards(92)
        .subscribe(
        (flashcardList: any) => { this.flashcards = flashcardList;

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