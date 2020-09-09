import { UserLogging } from './../../models/user-logging.model';
import { Router } from '@angular/router';
import { LogoutService } from './../../services/logout.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})


//start of class definition
export class NavComponent implements OnInit {

  //instance variables 
  isNavbarCollapsed=true;
  userLogging: UserLogging; 
  
  constructor(private LogoutService: LogoutService, private router: Router) { }

  // logging out method
  userLogout() {
    this.LogoutService.userLogout().subscribe(
      (userLogging: UserLogging) => { this.userLogging = userLogging; console.log(this.userLogging); },
      error => { console.log(error); }
      
    );

  this.router.navigate(['/base']);

  }

  // OnInit mehtod
  ngOnInit() {

  }

}
