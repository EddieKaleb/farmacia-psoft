import { Component, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Form, NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from 'src/app/service/auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loading = false;
  returnUrl: string;
  error = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService) { }

  ngOnInit() {
  }

  onSubmit(form) {
    this.loading = true;

    this.authenticationService.login(form)
      .subscribe(
        data => {
          this.router.navigate([this.returnUrl]);
        },
        error => {
          this.error = true;
          setTimeout(() => { this.error = false }, 2000);
          this.loading = false;
        });
  }

}
