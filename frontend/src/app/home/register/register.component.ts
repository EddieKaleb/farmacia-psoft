import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from 'src/app/service/auth.service';
import bcrypt from 'bcryptjs';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  loading = false;
  returnUrl: string;
  error = false;
  success = false;
  errorMessage = "Erro Interno";

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService) { }

  ngOnInit() {
  }

  async onSubmit(form) {
    this.loading = true;
    form.tipo = { id: 2 };

    form.senha = await bcrypt.hash(form.senha, 8);

    await this.authenticationService.register(form)
      .subscribe(
        data => {
          this.success = true;
          this.loading = false;
          setTimeout(() => { this.success = false }, 2000);
        },
        errors => {
          this.errorMessage = errors.error[0].mensagemUsuario;
          this.error = true;
          this.loading = false;
          setTimeout(() => { this.error = false }, 2000);
        });
  }
}
