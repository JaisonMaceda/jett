import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RestapiService {

  constructor(private http:HttpClient) { }

  login(username:string, password:string){
     const headers = new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)})
    return this.http.get("http://localhost:8081/jett_core/login",{headers,responseType: 'text' as 'json'})
  }

  getUser(){
    let username="user";
    let password="P@ssw0rd";
    const headers=new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)});
    return this.http.get("http://localhost:8081/getUsers",{headers});
  }
}
