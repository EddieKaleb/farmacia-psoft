import { Component, OnInit, Input } from '@angular/core';
import Lot from 'src/app/model/lot.module';

@Component({
  selector: 'app-lot-list-item',
  templateUrl: './lot-list-item.component.html',
  styleUrls: ['./lot-list-item.component.css']
})
export class LotListItemComponent implements OnInit {
  @Input() lot: Lot;
  constructor() { }

  ngOnInit() {
  }

  situacao(){
    return this.lot.situacao ? "Válido" : "Vencido"; 
  }

}
