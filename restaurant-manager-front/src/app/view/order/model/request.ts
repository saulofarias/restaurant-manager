import {Product} from './product';

export class OrderRequest {

  table:number;
  number: number;
  products: Array<Product>;
}
