import { Component, OnInit } from '@angular/core';
import { ProductsService } from 'src/app/service/products.service';

@Component({
  selector: 'app-admin-add-product',
  templateUrl: './admin-add-product.component.html',
  styleUrls: ['./admin-add-product.component.css']
})
export class AdminAddProductComponent implements OnInit {

  constructor(private productService: ProductsService) { }

  ngOnInit() {
  }

  create(form){
    let categoria= "";
    if(form.categoria == 1){
      categoria = "medicamento"
    }else if(form.categoria == 2){
      categoria = "higiene"
    }else if(form.categoria == 3){
      categoria = "cosmetico"
    }else{
      categoria = "alimento"
    }
    let product = {
      caminhoImagem: "assets/img/"+categoria+".png",
      categoria: {
        desconto: {
          id: 1
        },
        id: form.categoria
      },
      nome: form.nome,
      nomeFabricante: form.fabricante,
      preco: form.valor,
      situacao: {
        id: 1
      }
    }
    this.productService.createProduct(product).subscribe();

  }

}
