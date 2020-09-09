import { LoginCreds } from './../../models/login-creds.model';
import { UserType } from './../../models/user-type.model';
import { UserService } from './../../services/user.service';
import { UserLoggingComponent } from './../user-logging/user-logging.component';
import { Component, OnInit, Inject } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { UserLogging } from 'src/app/models/user-logging.model';
import { SESSION_STORAGE, StorageService } from 'angular-webstorage-service';
import { strictEqual } from 'assert';
import { stringify } from 'querystring';

//let firstname = localStorage.get('key'); 

const firstname = window.localStorage.getItem('key');

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css'],
})
export class UserInfoComponent implements OnInit {


  user: User;
  userLogging: UserLogging; 
  username: string = ""; 
  firstname: string = ""; 
  lastname: string = ""; 
  email: string = ""; 
  usertype: string = ""; 
  id: number; 
  userType: UserType; 
  userTypeId: number; 
  userTypeName: string; 
  loginCreds: LoginCreds; 
  loginCredsId: number; 
  uName: string = ""; 
  pWord: string = ""; 
  userBean: User; 


  constructor(private userService: UserService, private userLoggingComponent: UserLoggingComponent, @Inject(SESSION_STORAGE) private storage: StorageService) {

    this.userLogging = userLoggingComponent.userLogging; 

  }

  ngOnInit(): void {

    console.log(window.localStorage.getItem('username')); 
    this.username = window.localStorage.getItem('username');
    this.firstname = window.localStorage.getItem('firstname');
    this.lastname = window.localStorage.getItem('lastname');
    this.email = window.localStorage.getItem('email');
    this.usertype = window.localStorage.getItem('usertype');
    this.id = Number(window.localStorage.getItem('id'));
    this.userLogging = JSON.parse(window.localStorage.getItem('userLogging'));
    
    console.log('user from window1: ' , this.userLogging); 

    console.log('user from window2: ' , this.userService.fetchUserInformation(Number(this.id))); 

    //console.log('user from window3: ' , this.userService.fetchUserInformation(92)); 

    console.log('user from window3: ' , this.userService.fetchUserInformation(92)); 
    
    console.log('all users from window: ' , this.userService.fetchAllUsers()); 

    this.getUser()


  }
//consult hero detail component 


  getUser(): void {
    console.log("test")
    this.userService.fetchUserInformation(92)
    .subscribe(
      user => this.user = user
      //error => console.log(`Error: ${error} `)
    );
      console.log("test of user: ", this.user); 

    }

}
