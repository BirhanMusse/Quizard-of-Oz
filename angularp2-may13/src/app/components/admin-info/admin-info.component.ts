
import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/user.model';
 
@Component({
  selector: 'app-admin-info',
  templateUrl: './admin-info.component.html',
  styleUrls: ['./admin-info.component.css']
})
export class AdminInfoComponent implements OnInit {


  user: User;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getUserInfo();
  }
//consult hero detail component 

  getUserInfo(): void {
    this.userService.fetchUserInformation(92) //hard coded to check --> need to grab from session
      .subscribe(
        user => this.user = user);
    //     (userId: any) => { this.user = userId; console.log(this.user); },
    //     error => { console.log(error + 'testing'); }
    //   );
    // console.log('singular user');
    // console.log(this.user);
  
  }

  

}
