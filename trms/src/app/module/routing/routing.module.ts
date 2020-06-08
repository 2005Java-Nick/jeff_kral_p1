import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes, Router } from '@angular/router';
import { LoginComponent } from '../../component/login/login.component';
import { CreateReimbursementComponent } from '../../component/createReimbursement/createReimbursement.component';

export const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'reimbursement', component: CreateReimbursementComponent}
];



@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class RoutingModule { }
