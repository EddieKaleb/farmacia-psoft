import { Injectable } from '@angular/core';
import Venda from '../model/venda.module';
import Usuario from '../model/usuario.module';
import {HttpClient} from '@angular/common/http';
import { environment } from '../../environments/environment';


const API_URL = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})
export class VendasService {

  constructor(private http: HttpClient) { }

  getvendas(){
    return this.http.get<any>(API_URL+"/vendas"); 
  }

  removeVenda(id){
    return this.http.delete<any>(API_URL+"/vendas/"+id);
  }

  finalizaVenda(id){
    return this.http.post<any>(API_URL+"/vendas/"+id, {});
  }
}
