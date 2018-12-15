import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductsService } from 'src/app/service/products.service';
import { BsModalService } from 'ngx-bootstrap/modal/';
import { AdminAddProductComponent } from './admin-add-product/admin-add-product.component';
import { AdminDescontosComponent } from './admin-descontos/admin-descontos.component';

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

  }

  openAddProduct(){
    this.modalService.show(AdminAddProductComponent);
  }

  openDescontos(){
    this.modalService.show(AdminDescontosComponent);
  }
}
