import { Component, OnInit, Input } from '@angular/core';
import Product from 'src/app/model/product.module';

@Component({
  selector: 'app-admin-product-details',
  templateUrl: './admin-product-details.component.html',
  styleUrls: ['./admin-product-details.component.css']
})
export class AdminProductDetailsComponent implements OnInit {
  @Input() product: any;
  promo = 0;
  preco = 0;
  constructor() { }

  ngOnInit() {
    this.product = new Product("pasta", 2, 2.5, "/assets/img/alimento.png", 3, 0);
  }

  setProduct(product){
    this.product = product;
  }

}
