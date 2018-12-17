import { Component, OnInit } from '@angular/core';
import Usuario from 'src/app/model/usuario.module';
import Reserva from 'src/app/model/reserva.module';
import Venda from 'src/app/model/venda.module';
import { ActivatedRoute } from '@angular/router';
import { ReservasService } from 'src/app/service/reservas.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {
  usuario: Usuario;
  reservas: Array<any>;


  constructor(private reservasService: ReservasService,
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.usuario =  JSON.parse(localStorage.getItem('currentUser'));
    this.reservasService.getReservas(this.usuario.id).subscribe(r => this.reservas=r);

  }

}
