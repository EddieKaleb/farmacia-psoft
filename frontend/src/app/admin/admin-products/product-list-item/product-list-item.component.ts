import { Component, OnInit, Input, Output , EventEmitter } from '@angular/core';
import Product from 'src/app/model/product.module';
import { AdminProductDetailsComponent } from './admin-product-details/admin-product-details.component';
import { BsModalService } from 'ngx-bootstrap/modal/';
import { ProductsService } from 'src/app/service/products.service';



@Component({
  selector: 'app-product-list-item',
  templateUrl: './product-list-item.component.html',
  styleUrls: ['./product-list-item.component.css']
})
export class ProductListItemComponent implements OnInit {
  @Input() product: any;
  @Output() remove = new EventEmitter();

  constructor(private modalService: BsModalService, 
              private productsService: ProductsService) { }

  ngOnInit() {
    
  }

  openDetails(){
    let modalRef = this.modalService.show(AdminProductDetailsComponent).content.setProduct(this.product);
  }

  getOldPrice(){
    return this.product.preco.toFixed(2);
  }

  delete(){
    this.productsService.deleteProduct(this.product.id).subscribe((data)=> { 
        if(!data){
          this.remove.emit(this.product.id);
        }
      });
  }
    
}
