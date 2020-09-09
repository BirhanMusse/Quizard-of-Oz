import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { UserType } from 'src/app/models/user-type.model';
import { LoginCreds } from 'src/app/models/login-creds.model';

@Component({
  selector: 'app-update-info',
  templateUrl: './update-info.component.html',
  styleUrls: ['./update-info.component.css']
})
export class UpdateInfoComponent implements OnInit {

  updateForm: FormGroup;
  user: User;
  uType: UserType;
  log: LoginCreds;
  
  
  constructor(private userService: UserService, private router: Router) { 
    this.updateForm = new FormGroup({
      firstName: new FormControl(),
      lastName: new FormControl(),
      email: new FormControl()
     }); 
  }
   onSubmit(): void {
    let uType = new UserType(1, 'learner');

    let creds = new LoginCreds(0, this.updateForm.value.uName, this.updateForm.value.pWord);
    
     let myUser = new User(0, this.updateForm.value.firstName, this.updateForm.value.lastName, this.updateForm.value.email, uType, creds, 125);

     this.userService.updateUser(myUser).subscribe((updateingUser: any) => { this.user = updateingUser; console.log(this.user); },
     error => { console.log(error); }
    );
    console.log(this.user);
    //later iterations will have a modal that will pop out and say You have successfully signed up -- but for now it will be a simple redirect
     this.router.navigate(['/adminHome']);
   }
   

  ngOnInit() {
  }

}
