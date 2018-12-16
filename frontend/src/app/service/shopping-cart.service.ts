import { Injectable } from '@angular/core';
import Product from '../model/product.module';

@Injectable({
  providedIn: 'root'
})
export class ShoppingCartService {

  listCart: Map<number,any> = new Map();

  constructor() { }

  addCart(product){
    if(this.listCart.has(product.item.id)){
      this.listCart.get(product.item.id).quant+= Number(product.quant);
    }else{
      this.listCart.set(product.item.id , product);
    }

  }

  getProducts(): Map<Number,any>{
    return this.listCart;
  }
}
