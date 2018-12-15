import { Component, OnInit, Input } from '@angular/core';
import Product from '../../../model/product.module';

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent implements OnInit {
  @Input() product: Product;
  
  constructor() { }

  ngOnInit() {
  }

  getNewPrice(){
    return this.product.newPrice.toFixed(2);
  }

  getOldPrice(){
    return this.product.oldPrice.toFixed(2);
  }
}
