import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Order} from 'src/app/view/order/model/order';
import {Table} from 'src/app/view/order/model/table';
import {environment} from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  uri: string = environment.URL;

  constructor(private httpClient: HttpClient) { }

  getAll(){
    return this.httpClient.get<Array<Order>>(`${this.uri}orders`);
  }

  getById(id){
    return this.httpClient.get<Order>(`${this.uri}orders/detail/${id}`);
  }

  getPendings(){
    return this.httpClient.get<Array<Order>>(`${this.uri}orders/pendings`);
  }

  getTables(size){
    return this.httpClient.get<Array<Table>>(`${this.uri}orders/tables/${size}`);
  }

  getOrderNumber(){
    return this.httpClient.get(`${this.uri}orders/number`);
  }

  save(order){
    return this.httpClient.post(`${this.uri}orders`, order);
  }

  cancelOrder(id){
    return this.httpClient.put(`${this.uri}orders/cancel/${id}`, null);
  }

  closeOrder(id){
    return this.httpClient.put(`${this.uri}orders/close/${id}`, null);
  }

  closeAllOrdersByTable(numTable){
    return this.httpClient.put(`${this.uri}orders/all/${numTable}`, null);
  }
}
