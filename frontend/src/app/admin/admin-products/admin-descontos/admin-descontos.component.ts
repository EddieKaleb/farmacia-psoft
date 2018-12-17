import { Component, OnInit } from '@angular/core';
import { ProductsService } from 'src/app/service/products.service';

@Component({
  selector: 'app-admin-descontos',
  templateUrl: './admin-descontos.component.html',
  styleUrls: ['./admin-descontos.component.css']
})
export class AdminDescontosComponent implements OnInit {

  constructor(private productsService: ProductsService) { }

  ngOnInit() {
  }

  aplica(form){
    let name;
    if(form.categoria == 1){
      name = "Medicamentos";
    }else if(form.categoria == 4){
      name = "Alimentos";
    }else if(form.categoria == 2){
      name =  "Higiene Pessoal";
    }else if(form.categoria == 3){
      name =  "Cosmeticos";
    }

    let categoria = {
      desconto: {
        id: form.desconto
      },
      id: form.categoria,
      nome: name
    }

    this.productsService.applyPromotion(categoria).subscribe();
  }
}
