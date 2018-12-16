import { Component, OnInit } from '@angular/core';
import { ShoppingCartService } from '../../service/shopping-cart.service';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  products= [];

  valorTotal;

  constructor(private cartService: ShoppingCartService) { }

  ngOnInit() {
    this.products = this.cartService.getProducts();
    this.getVal();
  }

  getVal(){
    let soma = 0;
    this.products.forEach((item)=> 
    soma += (item.quant * item.item.preco));
    this.valorTotal = soma.toFixed(2);
  }



}
