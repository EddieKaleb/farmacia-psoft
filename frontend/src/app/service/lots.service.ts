import { Injectable } from '@angular/core';
import Product from '../model/product.module';
import Lot from '../model/lot.module';

@Injectable({
  providedIn: 'root'
})
export class LotsService {

  lots: Array<Lot>;
  constructor() { }

  getLots(): Array<Lot>{
    let escova = new Product("Escova de dentes", 5.50,5.50,"assets/img/medicamento.png",2, 0);
    let pasta = new Product("Pasta de dentes", 3.00,2.50, "assets/img/medicamento.png", 30, 30);
    this.lots = [
        new Lot(1, 2, "10-12-2018", 1, escova.quant, escova),
        new Lot(2, 2, "10-12-2018", 0, pasta.quant, pasta)
    ];
    return this.lots
  }
}
