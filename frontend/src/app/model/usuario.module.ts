export default class Usuario {
    id: number;
    nome: string;
    cpf: string;
    rg: string;
    endereco: string;
    email: string;
    constructor(id, nome, cpf, rg, endereco, email) {
      this.id = id;
      this.nome = nome;
      this.cpf = cpf;
      this.rg = rg;
      this.endereco = endereco;
      this.email = email;
    }
  }