import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrl: './customer.component.css'
})
export class CustomerComponent implements  OnInit{
  customer: any

  constructor(private http: HttpClient) {
  }
  ngOnInit(): void {
    this.http.get("http://localhost:8888/CUSTOMER-SERVICE/customers")
      .subscribe({
        next : data => {
          this.customer=data;
        },
        error :err => {
          console.log(err);
        }
      })
  }

}

