import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RestapiService } from './restapi.service';
import { AppRoutingModule } from './app-routing.module';
import {FormsModule} from '@angular/forms'
import {HttpClientModule} from '@angular/common/http';
import { HomeComponent } from './home/home.component'

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule

  ],
  providers: [RestapiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
