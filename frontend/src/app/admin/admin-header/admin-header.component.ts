import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/service/auth.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styleUrls: ['./admin-header.component.css']
})
export class AdminHeaderComponent implements OnInit {

  constructor(private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService) { }

  ngOnInit() {
  }

  logout() {
    this.router.navigate(["/"]).then(() => {
      this.authenticationService.logout();
    });
  }

}
