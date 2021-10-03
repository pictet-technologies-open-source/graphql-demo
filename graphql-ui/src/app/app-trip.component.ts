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
        <br>
        <br>
        <h3>Displaying content for the newly added trip with id = {{newTrip.id}}</h3>
        <div *ngIf="newTrip">
            <p>Trip name: {{ newTrip.name }} </p>
            <p>Client: {{ newTrip?.client?.name }}</p>
        </div>
    `,
})
export class AppTripComponent implements OnInit {
    trip: any;
    newTrip: any;
    loading = true;
    error: any;
    tripId = 1;

    constructor(private apollo: Apollo) {
    }

    ngOnInit() {
        this.apollo
        .watchQuery({ // example query
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

        this.apollo.mutate({ // example mutation
            mutation:  gql`   
                mutation {   
                    createTrip (input:{
                        name: "San Francisco to New York",
                        client : {
                            name: "Lara",
                            age: 22
                        }
                    }) {
                        id
                        name
                        client {
                            name
                        }
                    }
                }
            `
        }).subscribe((result: any) => {
            this.newTrip = result?.data?.createTrip;
        });
    }


}
