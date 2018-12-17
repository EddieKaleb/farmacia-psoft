import { Component, OnInit } from '@angular/core';
import { BsModalService } from 'ngx-bootstrap/modal';
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

  statusLogin = false;


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private modalService: BsModalService,
    private authenticationService: AuthenticationService) { }



  ngOnInit() {
    if (localStorage.getItem("currentUser")) {
      this.statusLogin = true;
    }
  }

  openLogin() {
    this.modalService.show(LoginComponent);
    this.statusLogin = true;
  }

  openRegister() {
    this.modalService.show(RegisterComponent);
  }

  logout() {
    this.router.navigate(["/"]).then(() => {
      this.authenticationService.logout();
    });
  }

}
