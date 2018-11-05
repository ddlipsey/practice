import { Injectable } from '@angular/core';
import { Movie } from './Movie';
import { Genre } from './Genre';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private moviesUrl = 'http://localhost:8080/movies';
  private genresUrl = 'http://localhost:8080/genres';

  /** GET movies from the server */
  getMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.moviesUrl)
      .pipe(
        catchError(this.handleError('getMovies', []))
      );
  }

   /** GET genres from the server */
  getGenres(): Observable<Genre[]> {
    return this.http.get<Genre[]>(this.genresUrl)
      .pipe(
        catchError(this.handleError('getGenres', []))
      );
  }

  /** GET hero by id. Will 404 if id not found */
  getMovie(id: string): Observable<Movie> {
    const url = `${this.moviesUrl}/${id}`;
    return this.http.get<Movie>(url).pipe(
      catchError(this.handleError<Movie>(`getMovie id=${id}`))
    );
  }

  /** PUT: update the hero on the server */
  updateMovie(movie: Movie): Observable<any> {
    return this.http.put(this.moviesUrl, movie, httpOptions).pipe(
      catchError(this.handleError<any>('updateMovie'))
    );
  }

  /** DELETE: delete the hero from the server */
  deleteMovie(hero: Movie | string): Observable<Movie> {
    const id = typeof hero === 'string' ? hero : hero.id;
    const url = `${this.moviesUrl}/${id}`;

    return this.http.delete<Movie>(url, httpOptions).pipe(
      catchError(this.handleError<Movie>('deleteMovie'))
    );
  }

  /** POST: update the hero on the server */
  addMovie(movie: Movie): Observable<any> {
    return this.http.post(this.moviesUrl, movie, httpOptions).pipe(
      catchError(this.handleError<any>('addMovie'))
    );
  }

  /**
 * Handle Http operation that failed.
 * Let the app continue.
 * @param operation - name of the operation that failed
 * @param result - optional value to return as the observable result
 */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  constructor(private http: HttpClient) { }
}
