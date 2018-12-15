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
    
    return
  }
}
