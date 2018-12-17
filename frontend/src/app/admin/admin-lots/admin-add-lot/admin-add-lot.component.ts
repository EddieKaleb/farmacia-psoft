import { Component, OnInit } from '@angular/core';
import { LotsService } from 'src/app/service/lots.service';
import { ProductsService } from 'src/app/service/products.service';

@Component({
  selector: 'app-admin-add-lot',
  templateUrl: './admin-add-lot.component.html',
  styleUrls: ['./admin-add-lot.component.css']
})
export class AdminAddLotComponent implements OnInit {

  products;

  constructor(private lotsService: LotsService,
              private productsService: ProductsService) { }

  ngOnInit() {
  }

  create(form){
    let lot = {
      gtin: form.gtin,
      produto: {
          id: form.id
      },
      quantidade: form.quantidade,
      validade: form.validade
    }

    this.lotsService.createLot(lot).subscribe();
  }
}
