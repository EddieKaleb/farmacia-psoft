import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import Lot from 'src/app/model/lot.module';
import { ProductsService } from 'src/app/service/products.service';
import { LotsService } from 'src/app/service/lots.service';

@Component({
  selector: 'app-lot-list-item',
  templateUrl: './lot-list-item.component.html',
  styleUrls: ['./lot-list-item.component.css']
})
export class LotListItemComponent implements OnInit {
  @Input() lot: Lot;
  @Output() remove = new EventEmitter();

  constructor(private lotsService: LotsService) { }

  ngOnInit() {
  }

  delete(){
    this.lotsService.deleteLot(this.lot.id).subscribe((data)=> this.remove.emit(this.lot.id));
  }
}
