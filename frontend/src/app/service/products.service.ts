import { Injectable } from '@angular/core';
import Product from '../model/product.module';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  products: Array<Product>;
  constructor() {
    this.products = [
      new Product("Escova de dentes", "5,00","5,00","assets/img/escova.png","2 unidades", 0),
      new Product("Pasta de dentes", "3,00","2,50", "assets/img/pasta.png","30ml", 30),
      new Product("Escova de dentes", "5,00","5,00","assets/img/escova.png","2 unidades", 0),
      new Product("Pasta de dentes", "3,00","2,50", "assets/img/pasta.png","30ml", 30),
      new Product("Escova de dentes", "5,00","5,00","assets/img/escova.png","2 unidades", 0),
      new Product("Pasta de dentes", "3,00","2,50", "assets/img/pasta.png","30ml", 30),
      new Product("Escova de dentes", "5,00","5,00","assets/img/escova.png","2 unidades", 0),
      new Product("Pasta de dentes", "3,00","2,50", "assets/img/pasta.png","30ml", 30),
      new Product("Escova de dentes", "5,00","5,00","assets/img/escova.png","2 unidades", 0),
      new Product("Pasta de dentes", "3,00","2,50", "assets/img/pasta.png","30ml", 30)
    ]
  }

  getProducts(): Array<Product>{
    return this.products
  }
}
