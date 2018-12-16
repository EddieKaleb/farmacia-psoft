import { Component, OnInit } from '@angular/core';
import Product from '../../model/product.module';
import { ShoppingCartService } from '../../service/shopping-cart.service';
import { logWarnings } from 'protractor/built/driverProviders';
import { ActivatedRoute } from '@angular/router';
import { ProductsService } from 'src/app/service/products.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  product;
  quant = 1;

  constructor(private cartService: ShoppingCartService,
              private route: ActivatedRoute,
              private productsService: ProductsService) { }

  ngOnInit() {

    this.route.params.subscribe(
      (params) => { console.log(params['id']);
      this.productsService.getProductById(params['id']).subscribe(r => this.product = r)});
       
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

  getNewPrice(){

    
    return this.product.preco.toFixed(2);  
  }
}
