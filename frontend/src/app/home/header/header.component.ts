import { Component, OnInit } from '@angular/core';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { LoginComponent } from '../login/login.component';
import { RegisterComponent } from '../register/register.component';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public modalRef =  new BsModalRef;
  statusLogin = false;


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private modalService: BsModalService,
    private authenticationService: AuthenticationService) { }



  ngOnInit() {
    this.teste();
  }

  teste(){
    this.statusLogin =  !JSON.parse(localStorage.getItem('currentUser'));
  }
  openLogin() {
    this.modalRef = this.modalService.show(LoginComponent);
    this.modalRef.content.onClose.subscribe(result => {
      this.ngOnInit();
  })
    this.ngOnInit();
  }

  openRegister() {
    this.modalService.show(RegisterComponent);
  }

  logout(){
    this.authenticationService.logout();
    this.ngOnInit();
  }


}
