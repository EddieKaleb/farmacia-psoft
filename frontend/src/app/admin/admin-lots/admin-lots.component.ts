import { Component, OnInit } from '@angular/core';
import { LotsService } from 'src/app/service/lots.service';
import { ActivatedRoute } from '@angular/router';
import { BsModalService } from 'ngx-bootstrap/modal/';
import { AdminAddLotComponent } from './admin-add-lot/admin-add-lot.component';

@Component({
  selector: 'app-admin-lots',
  templateUrl: './admin-lots.component.html',
  styleUrls: ['./admin-lots.component.css']
})
export class AdminLotsComponent implements OnInit {

  lots: Array<any>;
  constructor(private lotsService: LotsService,
    private route: ActivatedRoute, private modalService: BsModalService) { }

  ngOnInit() {
    this.lots = this.lotsService.getLots();
    console.log(this.lots);
  }

  openAddLot(){
    this.modalService.show(AdminAddLotComponent);
  }
}
