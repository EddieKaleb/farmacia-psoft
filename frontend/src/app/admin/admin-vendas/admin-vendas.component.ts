import { Component, OnInit } from '@angular/core';
import Venda from 'src/app/model/venda.module';
import { VendasService } from 'src/app/service/vendas.service';

@Component({
  selector: 'app-admin-vendas',
  templateUrl: './admin-vendas.component.html',
  styleUrls: ['./admin-vendas.component.css']
})
export class AdminVendasComponent implements OnInit {

  vendas: Array<Venda>;
  constructor(private vendasService: VendasService) { }

  ngOnInit() {
    this.vendas = this.vendasService.getvendas();
  }

}
