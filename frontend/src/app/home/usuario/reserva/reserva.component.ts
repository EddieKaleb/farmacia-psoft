import { Component, OnInit, Input } from '@angular/core';
import Reserva from 'src/app/model/reserva.module';
import { ReservasService } from 'src/app/service/reservas.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-reserva',
  templateUrl: './reserva.component.html',
  styleUrls: ['./reserva.component.css']
})
export class ReservaComponent implements OnInit {
  @Input() reserva: Reserva;
  active: boolean;

  constructor(private reservasService: ReservasService,
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.active = true;
  }

  getValorTotal(){
    return this.reserva.venda.valorTotal.toFixed(2);
  }

  removeReserva(){
    this.reservasService.removeReserva(this.reserva);
    this.active = false;
  }
}
