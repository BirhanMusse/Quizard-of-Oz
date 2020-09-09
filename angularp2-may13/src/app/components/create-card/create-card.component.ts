import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { FlashcardService } from 'src/app/services/flashcard.service';
import { Card } from 'src/app/models/card.model';
import { Topic } from 'src/app/models/topic.model';
import { Router } from '@angular/router';
@Component({
  selector: 'app-create-card',
  templateUrl: './create-card.component.html',
  styleUrls: ['./create-card.component.css']
})
export class CreateCardComponent implements OnInit {

newCardForm: FormGroup;
card: Card;


constructor(private flashcardService:FlashcardService, private router: Router) { 
  this.newCardForm = new FormGroup({
    question: new FormControl(),
    answer: new FormControl(),
    topicName: new FormControl()
   }); 
  }

  onSubmit(): void {
    let num:number;
    let topics = this.newCardForm.value.topicName;
    if(topics = 'Mathematics') {
      num = 2;
    } else if(topics = 'Technology'){
      num =1;
    } else if(topics = 'Geography'){
      num = 3;
        console.log('geo here', num);
    } else {
      num = 0;
    }
    console.log(num);

    let tp = new Topic(num, this.newCardForm.value.topicName);

    let myCard = new Card(0, this.newCardForm.value.question, this.newCardForm.value.answer, tp);

    console.log(myCard);

    this.flashcardService.addCard(myCard).subscribe((creatingCard: any) => { this.card = creatingCard; console.log(this.card); },
    error => { console.log(error); }
   );
  
   this.router.navigate(['/play']);
   }
  
  

  ngOnInit() {
  }

}
