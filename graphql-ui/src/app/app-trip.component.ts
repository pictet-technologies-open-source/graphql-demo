import {Component, OnInit} from '@angular/core';
import {Apollo, gql} from 'apollo-angular';

@Component({
    selector: 'app-trip',
    template: `
        <div *ngIf="loading">
            Loading...
        </div>
        <div *ngIf="error">
            Error :(
        </div>
        <h3>Displaying content for Trip with id = {{tripId}}</h3>
        <div *ngIf="trip">
            <p>Trip name: {{ trip.name }} </p>
            <p>Client: {{ trip?.client?.name }}</p>
            <h4>Flight Reservations:</h4>
            <div *ngFor="let booking of trip?.flightBookings; let i=index">
                <p>Flight {{i + 1}} : </p>
                <p>Origin: {{booking?.flight?.origin}} </p>
                <p> Destination :  {{booking?.flight?.destination}}</p>
            </div>

        </div>
    `,
})
export class AppTripComponent implements OnInit {
    trip: any;
    loading = true;
    error: any;
    tripId = 1;

    constructor(private apollo: Apollo) {
    }

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
