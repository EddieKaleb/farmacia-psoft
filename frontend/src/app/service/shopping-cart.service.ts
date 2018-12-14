import { Injectable } from '@angular/core';
import Product from '../model/product.module';

@Injectable({
  providedIn: 'root'
})
export class ShoppingCartService {

  listCart: Array<Product> = [new Product("Pasta de dentes", "3,00", 2.50, "assets/img/medicamento.png", 2, 30), new Product("Pasta de dentes", "3,00", 2.5 , "assets/img/cosmetico.png",2, 30)];

  constructor() { }

  addCart(product: Product){
    console.log(product);
    
    this.listCart.push(product);
  }

  getProducts(): Array<Product>{
    return this.listCart;
  }
}
