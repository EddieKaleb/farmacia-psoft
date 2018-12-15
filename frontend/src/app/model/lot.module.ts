import Product from "./product.module";

export default class Lot {
    id: number;
    quant: number;
    gtin: number;
    validade: Date;
    situacao: number;
    product: Product;
    constructor(id, gtin, validade, situacao, quant, product) {
      this.id = id;
      this.gtin = gtin;
      this.validade = validade;
      this.situacao = situacao;
      this.quant = quant;
      this.product = product;
    }
  }