import { Component, OnInit } from '@angular/core';
import { ProductsService } from '../../service/products.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.css']
})
export class ListProductsComponent implements OnInit {
  products: Array<any>;
  category;
  constructor(private productsService: ProductsService,
              private route: ActivatedRoute) { 

  }

  ngOnInit() {
    /*
    this.route.params.subscribe(
      (params) => this.products = this.productsService.getProductsCategory(params['category']));
    */
  }

}
