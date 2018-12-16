import { Component, OnInit } from '@angular/core';
import Venda from 'src/app/model/venda.module';
import { VendasService } from 'src/app/service/vendas.service';
import { BsModalService } from 'ngx-bootstrap/modal/';
import { AdminAddVendaComponent } from './admin-add-venda/admin-add-venda.component';

@Component({
  selector: 'app-admin-vendas',
  templateUrl: './admin-vendas.component.html',
  styleUrls: ['./admin-vendas.component.css']
})
export class AdminVendasComponent implements OnInit {

  vendas: Array<Venda>;
  constructor(private vendasService: VendasService, private modalService: BsModalService) { }

  ngOnInit() {
    this.vendas = this.vendasService.getvendas();
  }

  openAddVendas(){
    this.modalService.show(AdminAddVendaComponent);
  }
}
