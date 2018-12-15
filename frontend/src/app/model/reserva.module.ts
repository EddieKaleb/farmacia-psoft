export default class Reserva {
    id: number;
    dataInicial: Date;
    dataFinal: Date;
    venda: string;
    usuario: number;
    constructor(id, dataInicial, dataFinal, venda, usuario) {
      this.id = id;
      this.dataInicial = dataInicial;
      this.dataFinal = dataFinal;
      this.venda = venda;
      this.usuario = usuario;
    }
  }