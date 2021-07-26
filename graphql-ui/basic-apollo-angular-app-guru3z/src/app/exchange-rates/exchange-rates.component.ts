import { Component, OnInit } from '@angular/core';
import { Apollo } from 'apollo-angular';
import gql from 'graphql-tag';
import { Observable } from 'rxjs';
import { shareReplay, map } from 'rxjs/operators';

@Component({
  selector: 'exchange-rates',
  templateUrl: './exchange-rates.component.html'
})
export class ExchangeRates implements OnInit {
  rates$: Observable<any[]>;
  loading$: Observable<boolean>;
  errors$: Observable<any>;

  constructor(private apollo: Apollo) { }

  ngOnInit() {
    const source$ = this.apollo.query({
      query: gql`
        {
          rates(currency: "USD") {
            currency
            rate
          }
        }
      `
    }).pipe(shareReplay(1));

    this.rates$ = source$.pipe(map(result => result.data && result.data.rates));
    this.loading$ = source$.pipe(map(result => result.loading));
    this.errors$ = source$.pipe(map(result => result.errors));
  }
}
