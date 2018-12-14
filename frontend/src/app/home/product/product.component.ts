import { Component, OnInit } from '@angular/core';
import Product from '../../model/product.module';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  product = new Product("Escova de dentes", "5,00","5,00","assets/img/escova.png","2 unidades", 0);
  
  constructor() { }

  ngOnInit() {
  }

}
