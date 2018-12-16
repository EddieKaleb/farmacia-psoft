import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductsService } from 'src/app/service/products.service';
import { BsModalService } from 'ngx-bootstrap/modal/';
import { AdminAddProductComponent } from './admin-add-product/admin-add-product.component';
import { AdminDescontosComponent } from './admin-descontos/admin-descontos.component';
import Product from 'src/app/model/product.module';

@Component({
  selector: 'app-admin-products',
  templateUrl: './admin-products.component.html',
  styleUrls: ['./admin-products.component.css']
})
export class AdminProductsComponent implements OnInit {
  products: Array<any>;
  category;
  constructor(private productsService: ProductsService,
    private route: ActivatedRoute, private modalService: BsModalService) { }

  ngOnInit() {
    this.products = [new Product("pasta", 2, 2.5, "/assets/img/alimento.png", 3, 0),
    new Product("pasta", 2, 2.5, "/assets/img/medicamento.png", 3, 0),
    new Product("pasta", 2, 2.5, "/assets/img/cosmetico.png", 3, 0),
    new Product("pasta", 2, 2.5, "/assets/img/higiene.png", 3, 0)];
  }

  openAddProduct(){
    this.modalService.show(AdminAddProductComponent);
  }

  openDescontos(){
    this.modalService.show(AdminDescontosComponent);
  }
}
