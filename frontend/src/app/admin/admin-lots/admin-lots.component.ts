import { Component, OnInit } from '@angular/core';
import { LotsService } from 'src/app/service/lots.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-admin-lots',
  templateUrl: './admin-lots.component.html',
  styleUrls: ['./admin-lots.component.css']
})
export class AdminLotsComponent implements OnInit {

  lots: Array<any>;
  constructor(private lotsService: LotsService,
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.lots = this.lotsService.getLots();
    console.log(this.lots);
  }

}
