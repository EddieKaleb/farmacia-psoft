import { Component, OnInit, Input } from '@angular/core';
import Product from 'src/app/model/product.module';
import { AdminProductDetailsComponent } from './admin-product-details/admin-product-details.component';
import { BsModalService } from 'ngx-bootstrap/modal/';


@Component({
  selector: 'app-product-list-item',
  templateUrl: './product-list-item.component.html',
  styleUrls: ['./product-list-item.component.css']
})
export class ProductListItemComponent implements OnInit {
  @Input() product: Product;
  constructor(private modalService: BsModalService) { }

  ngOnInit() {
    
  }

  openDetails(){
    let modalRef = this.modalService.show(AdminProductDetailsComponent).content.setProduct(this.product);
  }

  removeProduct(){

  }
}
