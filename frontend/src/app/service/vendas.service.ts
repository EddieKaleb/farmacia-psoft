import { Injectable } from '@angular/core';
import Venda from '../model/venda.module';
import Usuario from '../model/usuario.module';

@Injectable({
  providedIn: 'root'
})
export class VendasService {

  vendas: Array<Venda>;
  constructor() { }

  getvendas(): Array<Venda>{
    this.vendas = [
        new Venda(1, 2.5, 5, "15-12-2018", new Usuario(1, "Jorge", "123455", "1235135", "rua X", "email"), 1),
        new Venda(2, 10, 50, "15-12-2018", new Usuario(1, "Jorge", "123455", "1235135", "rua X", "email"), 0)
    ];
    return this.vendas;
  }

  removeVenda(venda){
    let index = this.vendas.indexOf(venda);
    if(index > -1){
        this.vendas.splice(index, 1);
    }

  }
}
