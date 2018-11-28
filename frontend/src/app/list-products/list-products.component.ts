import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.css']
})
export class ListProductsComponent implements OnInit {
  products: Array<any>;

  constructor() { }

  ngOnInit() {
    this.products = [
      
      {
        name: "Escova de dentes",
        oldPrice: "5,00",
        newPrice: "5,00",
        image: "assets/img/escova.png",
        quant: "2 unidades",
        promo: 0
      },
      {
        name: "Pasta de dentes",
        oldPrice: "3,00",
        newPrice: "2,50",
        image: "assets/img/pasta.png",
        quant: "30ml",
        promo: 30
      },
      {
        name: "Escova de dentes",
        oldPrice: "5,00",
        newPrice: "5,00",
        image: "assets/img/escova.png",
        quant: "2 unidades",
        promo: 0
      },
      {
        name: "Pasta de dentes",
        oldPrice: "3,00",
        newPrice: "2,50",
        image: "assets/img/pasta.png",
        quant: "30ml",
        promo: 30
      },
      {
        name: "Escova de dentes",
        oldPrice: "5,00",
        newPrice: "5,00",
        image: "assets/img/escova.png",
        quant: "2 unidades",
        promo: 0
      },
      {
        name: "Pasta de dentes",
        oldPrice: "3,00",
        newPrice: "2,50",
        image: "assets/img/pasta.png",
        quant: "30ml",
        promo: 30
      },
  
     
    ]
  }

}
