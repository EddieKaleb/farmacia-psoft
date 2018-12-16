import { Component, OnInit, Input } from '@angular/core';
import Product from '../../../model/product.module';

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent implements OnInit {
  @Input() product: any;
  
  constructor() { }

  ngOnInit() {
  }

  getNewPrice(){
    return (this.product.preco *Number(this.product.categoria.desconto.porcentagem)).toFixed(2);
  }

  getOldPrice(){
    return this.product.preco.toFixed(2);
  }

  isPromo(){
    return this.product.categoria.desconto.id>1;
  }

  getPromo(){
    return Number((Number(this.product.categoria.desconto.porcentagem) -1).toFixed(1))*100;
  }

  isAvailable(){
    return this.product.situacao.id == 1;
  }
}
