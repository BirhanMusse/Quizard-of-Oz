import { UserPullCardsComponent } from './components/user-pull-cards/user-pull-cards.component';
import { BaseComponent } from './components/base/base.component';
import { NavComponent } from './components/nav/nav.component';
import { FooterComponent } from './components/footer/footer.component';
import { UserInfoComponent } from './components/user-info/user-info.component';
import { CardsComponent } from './components/cards/cards.component';
import { UserHomeComponent } from './components/user-home/user-home.component';
import { AllusersComponent } from './components/allusers/allusers.component';
import { StatsComponent } from './components/stats/stats.component';
import { UpdateInfoComponent } from './components/update-info/update-info.component';
import { UserLoggingComponent } from './components/user-logging/user-logging.component';


//MyModules
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap'; //BootStrap import 
import { ReactiveFormsModule } from '@angular/forms';

import { HttpClientModule } from '@angular/common/http'; 
import { StorageServiceModule } from 'angular-webstorage-service'


//may add Material and Graphics 
//as comments aren't permitted in json, to add Bootstrap you also have to go to the angular.json file and add
// "node_modules/bootstrap/dist/css/bootstrap.min.css" this to the styles section among assets

//Routing
import { AppRoutingModule } from './app-routing.module';

//Good old components
import { AppComponent } from './app.component';

import { AdminHomeComponent } from './components/admin-home/admin-home.component';
import { InfoComponent } from './components/info/info.component';
import { CardModalComponent } from 'modals/card-modal/card-modal.component';
import { CreateCardComponent } from './components/create-card/create-card.component';
import { CreateUserComponent } from './components/create-user/create-user.component';
import { FlipCardComponent } from './components/flip-card/flip-card.component';
import { PlayComponent } from './components/play/play.component';
import { UpdateModalComponent } from './components/update-modal/update-modal.component';
import { AdminStatsComponent } from './components/admin-stats/admin-stats.component';

import { AdminInfoComponent } from './components/admin-info/admin-info.component';
import { AttemptComponent } from './components/attempt/attempt.component';
import { SelectCardComponent } from './components/select-card/select-card.component';
import { SetStudyComponent } from './components/set-study/set-study.component';



//services 

//

@NgModule({
  declarations: [
    AppComponent,
    AdminHomeComponent,
    InfoComponent,
    NavComponent,
    FooterComponent,
    UserInfoComponent,
    CardsComponent,
    UserHomeComponent,
    AllusersComponent,
    StatsComponent,
    UpdateInfoComponent,
    UserLoggingComponent, 
    BaseComponent,
    CardModalComponent,
    CreateUserComponent,
    CreateCardComponent,
    FlipCardComponent,
    PlayComponent,
    UpdateModalComponent,
    AdminStatsComponent,


    UserPullCardsComponent,

    AdminInfoComponent,
    AttemptComponent,

    SelectCardComponent,
    SetStudyComponent,
    


    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    ReactiveFormsModule,
    HttpClientModule, 
    StorageServiceModule

    

  ],
  providers: [UserLoggingComponent],
  //lets ang know root component
  bootstrap: [AppComponent]
})


export class AppModule { }


