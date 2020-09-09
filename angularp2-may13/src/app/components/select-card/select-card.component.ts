import { Component, OnInit } from '@angular/core';
import { UserType } from 'src/app/models/user-type.model';
import { LoginCreds } from 'src/app/models/login-creds.model';
import { User } from 'src/app/models/user.model';
import { Topic } from 'src/app/models/topic.model';
import { FlashcardService } from 'src/app/services/flashcard.service';
import { FormGroup, FormControl } from '@angular/forms';
import { UserCard } from 'src/app/models/user-card.model';
import { Card } from 'src/app/models/card.model';

@Component({
  selector: 'app-select-card',
  templateUrl: './select-card.component.html',
  styleUrls: ['./select-card.component.css']
})
export class SelectCardComponent implements OnInit {

  flashcards: Card[];
  flashcard: Card;
  studySetForm: FormGroup;
  userCard: UserCard;
  

  constructor(private flashcardService: FlashcardService) {
    this.studySetForm = new FormGroup({
      flashcard: new FormControl()
      
      
    });
   }

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

  onCardSelect(): void {

    let uType = new UserType(1, 'learner');

    let creds = new LoginCreds(2, 'JJones', 'juniper');
    
    let myUser = new User(69, 'John', 'Jones', 'JJones@futuretech.com', uType, creds, 0);
    
    let topic = new Topic(3, 'Geography');

    // let myCard = new Card();
    this.flashcardService.addCard



  }

  ngOnInit() {
    this.loadFlashCards();
  }

}



// $("input:checkbox[name=type]:checked").each(function(){
//   yourArray.push($(this).val());
// });