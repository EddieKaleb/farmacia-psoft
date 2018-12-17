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
    return this.http.get<any[]>(API_URL+'/estoques');
  }

  getProductsCategory(id){
    return this.http.get<any[]>(API_URL+'/estoques/categoria/'+id);
  }

  getProductById(id){
    return this.http.get<any>(API_URL+'/produtos/'+id);
  }

  createProduct(product){
    return this.http.post<any>(API_URL+"/produtos",product);
  }

  applyPromotion(categoria){
    return this.http.put<any>(API_URL+"/categorias/"+categoria.id, categoria);
  }

  deleteProduct(id){
    return this.http.delete<any>(API_URL+"/produtos/"+id);
  }

}