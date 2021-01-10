import { Component, OnInit } from '@angular/core';
import { RestapiService } from '../restapi.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  message: any

  successMessage: string;
  invalidLogin = false;
  loginSuccess = false;
  
  
  
  constructor(
    private service:RestapiService, 
    private router:Router
    ) { }

  ngOnInit(): void {
  }

  doLogin(){
    console.log(this.username);
    console.log(this.password);
    let resp= this.service.login(this.username,this.password);
    
    resp.subscribe(data=>{
      console.log(data);
      this.message = data;
      this.router.navigate(["/home"])
    })
  }
  findAllUser(){
    let resp= this.service.login("user","password");
    
    resp.subscribe(data=>{
      console.log(data);
      this.message = data;
      this.router.navigate(["/home"])
    })
  }
}
