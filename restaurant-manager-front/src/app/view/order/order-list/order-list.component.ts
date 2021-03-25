import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastService } from 'src/app/core/services/toast.service';
import { EventDataService } from 'src/app/shared/services/event-data.service';
import { OrderService } from 'src/app/shared/services/order.service';
import { Order } from '../model/order';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css'],
})
export class OrderListComponent implements OnInit {
  orders: Array<Order>;

  constructor(
    private orderService: OrderService,
    private toastService: ToastService,
    private router: Router,
    public eventDataService: EventDataService
  ) {}

  ngOnInit(): void {
    this.getPendings();
    //this.getAll();
  }

  getAll() {
    this.orderService.getAll().subscribe({
      next: (orders) => {
        if (orders) this.orders = orders;
      },
      error: (err) => {
        this.toastService.error('Erro ao buscar Pedidos!');
      },
    });
  }

  getPendings() {
    this.orderService.getPendings().subscribe({
      next: (orders) => {
        if (orders) this.orders = orders;
      },
      error: (err) => {
        this.toastService.error('Erro ao buscar Pedidos!');
      },
    });
  }

  cancelOrder(id) {
    this.orderService.cancelOrder(id).subscribe({
      next: (order) => {
        if (order) {
          this.ngOnInit();
          this.toastService.success('Operação realizada com sucesso!');
        }
      },
      error: (err) => {
        this.toastService.error('Erro ao realizar procedimento!');
      },
    });
  }

  closeOrder(id) {
    this.orderService.closeOrder(id).subscribe({
      next: (order) => {
        if (order) {
          this.ngOnInit();
          this.toastService.success('Operação realizada com sucesso!');
        }
      },
      error: (err) => {
        this.toastService.error('Erro ao realizar procedimento!');
      },
    });
  }
}
