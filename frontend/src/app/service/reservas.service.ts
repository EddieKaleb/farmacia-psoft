import { Injectable } from '@angular/core';
import Reserva from '../model/reserva.module';
import Venda from '../model/venda.module';

@Injectable({
  providedIn: 'root'
})
export class ReservasService {
  reservas: Array<Reserva>;
  constructor() {
    this.reservas = [new Reserva(1, "15-12-2018", "16-12-2018", new Venda(1, 50, 50, "15-12-2018", "jorge", 2), "jorge"),
    new Reserva(2, "17-12-2018", "18-12-2018", new Venda(1, 20, 20, "17-12-2018", "jorge", 2), "jorge"),
    new Reserva(3, "18-12-2018", "18-12-2018", new Venda(1, 30, 30, "17-12-2018", "jorge", 2), "jorge")];

  }

  getReservas(): Array<Reserva>{
    return this.reservas;
  }

  removeReserva(reserva){
    let index = this.reservas.indexOf(reserva);
    if(index > -1){
        this.reservas.splice(index, 1);
    }

  }
}
