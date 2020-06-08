import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reimbursement } from '../types/reimbursement';


@Injectable({
  providedIn: 'root'
})
export class ReimbursementService {

  createReimbursement(reimbursement: Reimbursement): Observable<object> {
    return this.http.post('createReimbursement', reimbursement);
  }


  constructor(private http: HttpClient) { }
}
