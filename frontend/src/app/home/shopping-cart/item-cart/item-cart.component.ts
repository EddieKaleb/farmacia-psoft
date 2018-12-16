import { Component, OnInit, Input, Output,  EventEmitter  } from '@angular/core';
import Product from '../../../model/product.module';

@Component({
  selector: 'app-item-cart',
  templateUrl: './item-cart.component.html',
  styleUrls: ['./item-cart.component.css']
})
export class ItemCartComponent implements OnInit {
  @Input() product: any;
  @Output() dele = new EventEmitter();

  valorTotal;

  constructor() { }

  ngOnInit() {
    this.valorTotal = (this.product.quant * Number(this.getNewPrice())).toFixed(2);
  }

  getVal(value){
    
    if(value.value>1){
      this.product.quant  = value.value;
    }else if(value.value){
      this.product.quant = 1;
      value.value = 1;
    }
    
    this.valorTotal = (this.product.quant * Number(this.getNewPrice())  ).toFixed(2);
  }

  deleteItem(){
    this.dele.emit(this.product.item.id);
  }

  getNewPrice(){
    return (this.product.item.preco *Number(this.product.item.categoria.desconto.porcentagem)).toFixed(2);
  }

}
