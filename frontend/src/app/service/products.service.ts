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


  getAllProducts(){
    return this.http.get<any[]>(API_URL+'/produtos');
  }

  getProductsCategory(id){
    return this.http.get<any[]>(API_URL+'/produtos/categoria/'+id);
  }

  getProductById(id){
    console.log(id);
    
    return this.http.get<any>(API_URL+'/produtos/'+id);
  }
}