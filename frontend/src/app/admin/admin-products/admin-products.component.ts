import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductsService } from 'src/app/service/products.service';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal/';
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
  public modalRef: BsModalRef;

  constructor(private productsService: ProductsService,
    private route: ActivatedRoute, private modalService: BsModalService) { }

  ngOnInit() {
    this.productsService.getProducts().subscribe( r => { console.log(r);
     this.products = r});
  }

  openAddProduct(){
    this.modalService.show(AdminAddProductComponent);
    
  }

  openDescontos(){
    this.modalService.show(AdminDescontosComponent);
  }

  remove(id){
    for(let i = 0 ; i < this.products.length; i++){
      if(this.products[i].id === id){
        this.products.splice(i,1);
      }
    }

    
    this.ngOnInit();
  }
}
