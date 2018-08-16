import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Config} from './values';
import {throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {Cart} from './cart';

@Injectable({
  providedIn: 'root'
})
export class DataService {
cart: Cart[];
  constructor(private httpClient: HttpClient) {
  }
  getJsonData() {

    return this.httpClient.get<Config[]>('https://gist.githubusercontent.com/Aakash06/' +
      'fad46b64a573d4c152e899192b90b86c/raw/8bdfa0dfcce2411cb521b58916cd5556700c1ab1/menu.json').pipe(
      catchError(this.handleError)
    );
  }


  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  };
}
