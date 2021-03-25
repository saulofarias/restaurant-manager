import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Product} from 'src/app/view/order/model/product';
import {environment} from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  uri: string = environment.URL;

  constructor(private httpClient: HttpClient) { }

  getAll(){
    return this.httpClient.get<Product[]>(`${this.uri}products`);
  }

  getById(id){
    return this.httpClient.get<Product>(`${this.uri}products/${id}`);
  }
}
