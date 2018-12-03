import { Component, OnInit } from '@angular/core';
import { ProductsService } from '../service/products.service';
import Product from '../model/product.module';

@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.css']
})
export class ListProductsComponent implements OnInit {
  products: Array<Product>;

  constructor(private productsService: ProductsService) { }

  ngOnInit() {
   this.products =  this.productsService.getProducts();
  }

}
