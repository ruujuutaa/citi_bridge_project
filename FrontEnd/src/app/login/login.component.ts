import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthServiceService } from '../auth-service.service';
import { User } from '../user';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user:User=new User();

  formGroup: FormGroup;

  constructor(private authService: AuthServiceService, private router: Router) { }

  ngOnInit(): void {
    this.initForm();
  }

  initForm() {
    this.formGroup = new FormGroup({
      username: new FormControl('',[Validators.required]),
      password: new FormControl('',[Validators.required])
    });
  }
   checkForm(): number{
    if(this.user.password!=""&&this.user.userName!="")
    {
      return 1;
    }
    return 0;
  }
    loginProcess() {
      if(this.checkForm()) {
        console.log(JSON.stringify(this.user));
        this.authService.logIn(this.user).subscribe((res: any) => {
          if(res) {
            console.log(res);
            //alert("login successful");
            this.router.navigate(['/home'],{state:{data:this.user}});
          }
          else {
            console.log(res);
            alert("invalid");


          }
        });
      }
    }  

}

  // submitUser() {
  //   console.log(JSON.stringify(this.user));
  //   console.log("login initiated!");
  // }

/*function loginProcess() {
  throw new Error('Function not implemented.');
}*/
