import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';



const baseUrl : string = 'http://localhost:8081/jett_core';

export class RestapiService {

  public username: String;
  public password: String;

  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'

  constructor(private http:HttpClient) { }

  login(username: string, password: string){
    //  const headers = new HttpHeaders({Authorization: 'Basic '+ window.btoa(username+":"+password)})
    //  console.log({headers,responseType: 'text' as 'json'});
    // return this.http.get(`http://localhost:8081/jett_core/userAccount/findById/1`,
    //   { 
    //     headers: { authorization: this.createBasicAuthToken(username, password) } }).pipe(map((res) => {
    //     this.username = username;
    //     this.password = password;
    //     this.registerSuccessfulLogin(username, password);
    //   }));
    console.log('login');
    const headers=new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)});
    return this.http.get(baseUrl + '/userAccount/findAll',{headers});
  
  }

  getUser(){
    let username="user";
    let password="P@ssw0rd";
    const headers=new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)});
    return this.http.get("http://localhost:8081/jett_core/userAccount/findAll",{headers});

  }
  
  createBasicAuthToken(username: String, password: String) {
    return 'Basic ' + window.btoa(username + ":" + password)
  }

  registerSuccessfulLogin(username, password) {
    sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, username)
  }

  logout() {
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    this.username = null;
    this.password = null;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return false
    return true
  }

  getLoggedInUserName() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return ''
    return user
  }
}
