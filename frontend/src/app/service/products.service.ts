import { Injectable } from '@angular/core';
import Product from '../model/product.module';
import {HttpClient} from '@angular/common/http';
import { environment } from '../../environments/environment';

const API_URL = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})
export class ProductsService {


  

  products: Array<Product>;
  constructor(private http: HttpClient) {
  }


  getProductsApi(){
    return this.http.get<any[]>(API_URL+'/produtos');
  }

  getProducts(): Array<Product>{
    this.products = [
      new Product("Escova de dentes", 5.50,5.50,"assets/img/medicamento.png","2 unidades", 0),
      new Product("Pasta de dentes", 3.00,2.50, "assets/img/medicamento.png","30ml", 30),
      new Product("Escova de dentes", 5.50,5.50,"assets/img/medicamento.png","2 unidades", 0),
      new Product("Pasta de dentes", 3.00,2.50, "assets/img/medicamento.png","30ml", 30),
      new Product("Escova de dentes", 5.50,5.50,"assets/img/medicamento.png","2 unidades", 0),
      new Product("Pasta de dentes", 3.00,2.50, "assets/img/medicamento.png","30ml", 30),
      new Product("Escova de dentes", 5.50,5.50,"assets/img/medicamento.png","2 unidades", 0),
      new Product("Pasta de dentes", 3.00,2.50, "assets/img/medicamento.png","30ml", 30),
    ];
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
        new Product("Escova de dentes", 5.50,5.50,"assets/img/cosmetico.png","2 unidades", 0),
        new Product("Pasta de dentes", 3.00,2.50, "assets/img/cosmetico.png","30ml", 30),
        new Product("Escova de dentes", 5.50,5.50,"assets/img/cosmetico.png","2 unidades", 0),
        new Product("Pasta de dentes", 3.00,2.50, "assets/img/cosmetico.png","30ml", 30),
      ];
    }else{
      products = [
        new Product("Escova de dentes", 5.50,5.50,"assets/img/medicamento.png","2 unidades", 0),
        new Product("Pasta de dentes", 3.00,2.50, "assets/img/medicamento.png","30ml", 30),
        new Product("Escova de dentes", 5.50,5.50,"assets/img/medicamento.png","2 unidades", 0),
        new Product("Pasta de dentes", 3.00,2.50, "assets/img/medicamento.png","30ml", 30),
        new Product("Escova de dentes", 5.50,5.50,"assets/img/cosmetico.png","2 unidades", 0),
        new Product("Pasta de dentes", 3.00,2.50, "assets/img/cosmetico.png","30ml", 30),
        new Product("Escova de dentes", 5.50,5.50,"assets/img/cosmetico.png","2 unidades", 0),
        new Product("Pasta de dentes", 3.00,2.50, "assets/img/cosmetico.png","30ml", 30),
        new Product("Escova de dentes", 5.50,5.50,"assets/img/alimento.png","2 unidades", 0),
        new Product("Pasta de dentes", 3.00,2.50, "assets/img/alimento.png","30ml", 30),
        new Product("Escova de dentes", 5.50,5.50,"assets/img/alimento.png","2 unidades", 0),
        new Product("Pasta de dentes", 3.00,2.50, "assets/img/alimento.png","30ml", 30),
        new Product("Escova de dentes", 5.50,5.50,"assets/img/higiene.png","2 unidades", 0),
        new Product("Pasta de dentes", 3.00,2.50, "assets/img/higiene.png","30ml", 30),
        new Product("Escova de dentes", 5.50,5.50,"assets/img/higiene.png","2 unidades", 0),
        new Product("Pasta de dentes", 3.00,2.50, "assets/img/higiene.png","30ml", 30),
      ]
    }
    return products;
  }
}