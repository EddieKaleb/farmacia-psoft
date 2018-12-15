import { Component, OnInit } from '@angular/core';
import Usuario from 'src/app/model/usuario.module';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {
  usuario: Usuario;
  reservas: Array<any>;
  constructor() { }

  ngOnInit() {
    this.usuario = new Usuario(1, "Jorge", "12345678910", "66341", "Rua x", "example@gmail.com");
    
  }

}
