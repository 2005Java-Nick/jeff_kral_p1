import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { CreateReimbursementComponent } from './component/createReimbursement/createReimbursement.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CreateReimbursementComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
