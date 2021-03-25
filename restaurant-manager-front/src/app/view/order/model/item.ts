import {Product} from './product';

export class Item {
 id?: number;
 description: string;
 price: number;
 product: Product = new Product();
}
