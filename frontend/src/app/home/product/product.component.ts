import { Component, OnInit } from '@angular/core';
import Product from '../../model/product.module';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  product = new Product("Pasta de dentes", "3,00","2,50", "assets/img/pasta.png","30ml", 30);
  
  constructor() { }

  ngOnInit() {
  }

}
