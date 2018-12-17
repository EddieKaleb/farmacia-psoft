import { Component, OnInit } from '@angular/core';
import { ShoppingCartService } from '../../service/shopping-cart.service';
import { getMaxListeners } from 'cluster';
import { VendasService } from 'src/app/service/vendas.service';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  products: Map<Number,any>;

  valorTotal;

  constructor(private cartService: ShoppingCartService,
              private vs : VendasService) { }

  ngOnInit() {
    this.products = this.cartService.getProducts();
    this.getVal();
  }

  getList(){
    return Array.from(this.products.values());
  }
  
  getVal(){
    let soma = 0;
    this.getList().forEach((item)=> 
    soma += (this.itemQtd(item) * Number(this.getNewPrice(item))));
    this.valorTotal = soma.toFixed(2);
  }

  itemQtd(product){
    return product.quant;
  }
  getNewPrice(product){
    return (product.item.preco *Number(product.item.categoria.desconto.porcentagem)).toFixed(2);
  }

  deleteById(id){
    this.products.delete(id);
    this.getVal();
  }

  criar(){
    let user =  JSON.parse(localStorage.getItem('currentUser'));
    this.vs.iniciaVenda(user.id).subscribe();
    
  }

}
