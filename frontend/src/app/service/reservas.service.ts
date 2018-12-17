import { Injectable } from '@angular/core';
import Reserva from '../model/reserva.module';
import Venda from '../model/venda.module';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';


const API_URL = environment.apiUrl;


@Injectable({
  providedIn: 'root'
})
export class ReservasService {
  constructor(private http: HttpClient) {

  }

  getReservas(user){
    return this.http.get<any>(API_URL+"/reservas/usuario/"+user);
  }

}
