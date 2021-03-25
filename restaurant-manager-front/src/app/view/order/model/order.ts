import {Item} from './item';

export class Order {
  id?: number;
  amount: number;
  number: number;
  numTable: number;
  status: string;
  items: Array<Item> = [];

}
