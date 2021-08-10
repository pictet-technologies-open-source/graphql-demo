import {Component, OnInit} from '@angular/core';
import {Apollo, gql} from 'apollo-angular';

@Component({
  selector: 'exchange-rates',
  template: `
    <div *ngIf="loading">
      Loading...
    </div>
    <div *ngIf="error">
      Error :(
    </div>
    <div *ngIf="trip">
<!--      <div *ngFor="let trip of trip">-->
        <p>{{ trip.name }}: {{ trip?.client?.name }}</p>
<!--      </div>-->
    </div>
  `,
})
export class ExchangeRates implements OnInit {
  trip: any;
  loading = true;
  error: any;

  constructor(private apollo: Apollo) {}

  ngOnInit() {
    this.apollo
      .watchQuery({
        query: gql`
          {
            trip(id: 1) {
              name
              client {
                name
              }
              flightBookings {
                seatNumber
                flight {
                  origin
                  destination
                  number
                }
              }
            }
          }
        `,
      })
      .valueChanges.subscribe((result: any) => {
        this.trip = result?.data?.trip;
        this.loading = result.loading;
        this.error = result.error;
      });
  }
}
