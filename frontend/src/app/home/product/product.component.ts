import { Component, OnInit } from '@angular/core';
import Product from '../../model/product.module';
import { ShoppingCartService } from '../../service/shopping-cart.service';
import { logWarnings } from 'protractor/built/driverProviders';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  product = new Product("Pasta de dentes", "3,00",2.50, "assets/img/pasta.png","30ml", 30);
  quant = 1;

  constructor(private cartService: ShoppingCartService) { }

  ngOnInit() {
  }

  addCart(){
    this.cartService.addCart({item: this.product, quant: this.quant});
  }

  getVal(value){
    this.quant = value;
  }

  validQuant(){
    return this.quant >= 1;
  }
}
