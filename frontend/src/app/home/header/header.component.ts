import { Component, OnInit } from '@angular/core';
import { BsModalService } from 'ngx-bootstrap/modal';
import { LoginComponent } from '../login/login.component';
import { RegisterComponent } from '../register/register.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  statusLogin = true;


  constructor(private modalService: BsModalService) { }
  
  

  ngOnInit() {
  }

  openLogin(){
    this.modalService.show(LoginComponent);
  }

  openRegister(){
    this.modalService.show(RegisterComponent);
  }


}
