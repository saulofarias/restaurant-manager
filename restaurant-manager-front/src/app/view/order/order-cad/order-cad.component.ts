import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastService } from 'src/app/core/services/toast.service';
import { OrderService } from 'src/app/shared/services/order.service';
import { ProductService } from 'src/app/shared/services/product.service';
import { Order } from '../model/order';
import { Product } from '../model/product';
import { Table } from '../model/table';
import { OrderRequest } from '../model/request';

@Component({
  selector: 'app-order-cad',
  templateUrl: './order-cad.component.html',
  styleUrls: ['./order-cad.component.css'],
})
export class OrderCadComponent implements OnInit {
  tables: Array<Table> = [];
  items: Array<Product> = [];
  orderNumber;
  tabValue: number;
  product: Product = new Product();
  products: Array<Product> = [];
  request: OrderRequest = new OrderRequest();
  total: number = 0;

  constructor(
    private router: Router,
    private toastService: ToastService,
    private productService: ProductService,
    private orderService: OrderService
  ) {}

  ngOnInit(): void {
    this.getItems();
    this.getTables();
    this.getOrderNumber();
  }

  getItems() {
    this.productService.getAll().subscribe({
      next: (products) => {
        if (products) this.items = products;
      },
      error: (err) => {
        this.toastService.error('Erro ao buscar Items!');
      },
    });
  }

  setTotal(id) {
    this.productService.getById(id).subscribe({
      next: (product) => {
        if (product) {
          this.product = product;
          this.total += product.price;
      }},
      error: (err) => {
        this.toastService.error('Erro ao buscar Item!');
      },
    });
  }

  getTables() {
    this.orderService.getTables(10).subscribe({
      next: (tables) => {
        if (tables) this.tables = tables;
      },
      error: (err) => {
        this.toastService.error('Erro ao buscar Mesas!');
      },
    });
  }

  getOrderNumber() {
    this.orderService.getOrderNumber().subscribe({
      next: (val) => {
        if (val) this.orderNumber = val;
      },
      error: (err) => {
        this.toastService.error('Erro ao buscar Número Pedido!');
      },
    });
  }
  save() {
    this.request.table = this.tabValue;
    this.request.number = this.orderNumber.number;
    this.request.products = this.products;
    //console.log(this.request);
    this.orderService.save(this.request).subscribe({
      next: (order) => {
        if (order) 
        this.toastService.success('Pedido criado com sucesso!');
      },
      error: (err) => {
        this.toastService.error('Erro ao buscar Número Pedido!');
      },
    });
  }

  tableValue(event) {
    if (event.target) {
      this.tabValue = event.target.value;
    }
  }

  itemValue(event) {
    if (event.target) {
      //let index = this.products.indexOf(event.target.value);
      //let remove = this.products.splice(index, 1);
      //this.products.includes(event.target.value);
      this.product.id = event.target.value;
      this.products.push(this.product);
      this.setTotal(this.product.id); 
    }
  }
}
