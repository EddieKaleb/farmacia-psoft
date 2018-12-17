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
  quant: Number = 1;

  constructor(private cartService: ShoppingCartService,
              private route: ActivatedRoute,
              private productsService: ProductsService) { }

  ngOnInit() {
    this.route.params.subscribe(
      (params) => {this.productsService.getProductById(params['id'])
                      .subscribe(r => this.product = r)});

                      let currentUser = JSON.parse(localStorage.getItem('currentUser'));
        console.log( currentUser);
        
  }

  addCart(){
    this.cartService.addCart({item: this.product, quant: this.quant});
  }

  getVal(value){
    this.quant = Number(value);
  }

  validQuant(){
    return this.quant >= 1;
  }

  getNewPrice(){
    return (this.product.preco*Number(this.product.categoria.desconto.porcentagem)).toFixed(2);
  }

  getOldPrice(){
    return this.product.preco.toFixed(2);
  }

  isPromo(){
    return this.product.categoria.desconto.id >1;
  }

  getPromo(){
    return Number((1-Number(this.product.categoria.desconto.porcentagem)).toFixed(1))*100;
  }

  isAvailable(){
    return this.product.situacao.id == 1;
  }
}
