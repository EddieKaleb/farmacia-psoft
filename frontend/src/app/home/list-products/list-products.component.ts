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

    

    this.route.params.subscribe(
      (params) => {
        let par = params['category']
        if(!par){
          this.productsService.getAllProducts().subscribe( r => {console.log(r);
           this.products = r});
        }else{
          let id = 1;
          
          if(par == "medicamentos"){
            id = 1;
          }else if(par == "alimentos"){
            id = 4;
          }else if(par == "higiene-pessoal"){
            id = 2;
          }else if(par == "cosmeticos"){
            id = 3;
          }

          
          this.productsService.getProductsCategory(id).subscribe( r => this.products = r);
        }
        
        
    
    });
  }

}
