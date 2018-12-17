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
    console.log(this.product);
    
  }

  getNewPrice(){
    return (this.product.produto.preco *Number(this.product.produto.categoria.desconto.porcentagem)).toFixed(2);
  }

  getOldPrice(){
    return this.product.produto.preco.toFixed(2);
  }

  isPromo(){
    return this.product.produto.categoria.desconto.id>1;
  }

  getPromo(){
    return Number((Number(this.product.produto.categoria.desconto.porcentagem) -1).toFixed(1))*100;
  }

  isAvailable(){
    return this.product.produto.situacao.id == 1;
  }
}
