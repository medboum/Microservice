import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrl: './account.component.css'
})
export class AccountComponent  implements OnInit{
  account: any

  constructor(private http: HttpClient) {
  }
  ngOnInit(): void {
    this.http.get("http://localhost:8888/ACCOUNT-SERVICE/accounts")
      .subscribe({
        next : data => {
         this.account=data;
        },
        error :err => {
          console.log(err);
        }
      })
  }

}
