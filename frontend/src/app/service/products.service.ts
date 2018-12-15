import { Injectable } from '@angular/core';
import Product from '../model/product.module';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  products: Array<Product>;
  constructor() {
  }

  getProducts(): Array<Product>{
    return this.products
  }

  getProductsCategory(category): Array<Product>{
    
    let products;
    if(category === 'medicamentos'){
      products = [
        new Product("Escova de dentes", 5.50,5.50,"assets/img/medicamento.png","2 unidades", 0),
        new Product("Pasta de dentes", 3.00,2.50, "assets/img/medicamento.png","30ml", 30),
        new Product("Escova de dentes", 5.50,5.50,"assets/img/medicamento.png","2 unidades", 0),
        new Product("Pasta de dentes", 3.00,2.50, "assets/img/medicamento.png","30ml", 30),
        new Product("Escova de dentes", 5.50,5.50,"assets/img/medicamento.png","2 unidades", 0),
        new Product("Pasta de dentes", 3.00,2.50, "assets/img/medicamento.png","30ml", 30),
        new Product("Escova de dentes", 5.50,5.50,"assets/img/medicamento.png","2 unidades", 0),
        new Product("Pasta de dentes", 3.00,2.50, "assets/img/medicamento.png","30ml", 30),
      ]
    }else if(category === 'higiene-pessoal'){
      products = [
        new Product("Escova de dentes", 5.50,5.50,"assets/img/higiene.png","2 unidades", 0),
        new Product("Pasta de dentes", 3.00,2.50, "assets/img/higiene.png","30ml", 30),
        new Product("Escova de dentes", 5.50,5.50,"assets/img/higiene.png","2 unidades", 0),
        new Product("Pasta de dentes", 3.00,2.50, "assets/img/higiene.png","30ml", 30),
        new Product("Escova de dentes", 5.50,5.50,"assets/img/higiene.png","2 unidades", 0),
        new Product("Pasta de dentes", 3.00,2.50, "assets/img/higiene.png","30ml", 30),
      ]
    }else if(category === 'alimentos'){
      products = [
        new Product("Escova de dentes", 5.50,5.50,"assets/img/alimento.png","2 unidades", 0),
        new Product("Pasta de dentes", 3.00,2.50, "assets/img/alimento.png","30ml", 30),
        new Product("Escova de dentes", 5.50,5.50,"assets/img/alimento.png","2 unidades", 0),
        new Product("Pasta de dentes", 3.00,2.50, "assets/img/alimento.png","30ml", 30),
      ];
    }else if(category === 'cosmeticos'){
      products = [

      ];
    }else{
      products = [

      ]
    }
    return products;
  }
}
