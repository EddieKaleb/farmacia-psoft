import { Component, OnInit, Input } from '@angular/core';
import Product from '../../../model/product.module';

@Component({
  selector: 'app-item-cart',
  templateUrl: './item-cart.component.html',
  styleUrls: ['./item-cart.component.css']
})
export class ItemCartComponent implements OnInit {
  @Input() product: Product;
  constructor() { }

  ngOnInit() {
  }

  valorTotal(){
    let returno = (this.product.quant * this.product.newPrice).toFixed(2);
    console.log(returno);
    return returno;
  } 

}
