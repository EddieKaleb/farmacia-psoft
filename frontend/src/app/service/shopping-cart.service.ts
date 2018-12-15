import { Injectable } from '@angular/core';
import Product from '../model/product.module';

@Injectable({
  providedIn: 'root'
})
export class ShoppingCartService {

  listCart: Array<any> = [];

  constructor() { }

  addCart(product){
    this.listCart.push(product);
  }

  getProducts(): Array<any>{
    return this.listCart;
  }
}
