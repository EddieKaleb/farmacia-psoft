import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductsService } from 'src/app/service/products.service';

@Component({
  selector: 'app-admin-products',
  templateUrl: './admin-products.component.html',
  styleUrls: ['./admin-products.component.css']
})
export class AdminProductsComponent implements OnInit {
  products: Array<any>;
  category;
  constructor(private productsService: ProductsService,
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.products = this.productsService.getProducts();
  }

}
