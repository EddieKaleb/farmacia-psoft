import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { environment } from '../../environments/environment';
const API_URL = environment.apiUrl;

@Injectable({ providedIn: 'root' })
export class AuthenticationService {



  constructor(private http: HttpClient) { }

  login(auth) {

    return this.http.post<any>(`${API_URL}/usuarios/login`, auth)
      .pipe(map(user => {
        // login successful if there's a user in the response
        if (user) {
          // store user details and basic auth credentials in local storage
          // to keep user logged in between page refreshes
          user.authdata = window.btoa(auth.email + ':' + auth.senha);
          localStorage.setItem('currentUser', JSON.stringify(user));
        }
        return user;
      }));
  }


  register(user) {

    return this.http.post<any>(`${API_URL}/usuarios`, user)
      .pipe(map(user => {
        return user;
      }));
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
  }
}
