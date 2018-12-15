export default class Venda {
    id: number;
    valorSubTotal: number;
    valorTotal: number;
    data: Date;
    usuario: string;
    status: number;
    constructor(id, valorSubTotal, valorTotal, data, usuario, status) {
      this.id = id;
      this.valorSubTotal = valorSubTotal;
      this.valorTotal = valorTotal;
      this.data = data;
      this.usuario = usuario;
      this.status = status;
    }
  }