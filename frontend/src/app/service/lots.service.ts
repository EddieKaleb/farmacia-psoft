import { Injectable } from '@angular/core';
import Product from '../model/product.module';
import Lot from '../model/lot.module';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';

const API_URL = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})
export class LotsService {

  lots: Array<Lot>;
  constructor(private http: HttpClient) { }

  getLots(){
    return this.http.get<any>(API_URL+"/lotes");
  }

  createLot(lot){
    return this.http.post<any>(API_URL+"/lotes",lot);
  }

  deleteLot(id){
    return this.http.delete<any>(API_URL+"/lotes/"+id);
  }
}
