export default class Product {
  name: string;
  oldPrice: number;
  newPrice: number;
  image: string;
  quant: number;
  promo: number;
  constructor(name, oldPrice, newPrice, image, quant, promo) {
    this.name = name;
    this.oldPrice = oldPrice;
    this.newPrice = newPrice;
    this.image = image;
    this.quant = quant;
    this.promo = promo;
  }
}