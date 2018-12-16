import { Component, OnInit, Input } from '@angular/core';
import Venda from 'src/app/model/venda.module';
import { VendasService } from 'src/app/service/vendas.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-venda-list-item',
  templateUrl: './venda-list-item.component.html',
  styleUrls: ['./venda-list-item.component.css']
})
export class VendaListItemComponent implements OnInit {

  @Input() venda: Venda;
  active: boolean;
  
  constructor(private vendasService: VendasService,
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.active = true;
  }

  removeVenda(){
    this.vendasService.removeVenda(this.venda);
  }

}
