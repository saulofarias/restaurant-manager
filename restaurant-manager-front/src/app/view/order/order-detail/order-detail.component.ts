import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {ToastService} from 'src/app/core/services/toast.service';
import {EventDataService} from 'src/app/shared/services/event-data.service';
import {OrderService} from 'src/app/shared/services/order.service';
import {Order} from '../model/order';

@Component({
  selector: 'app-order-detail',
  templateUrl: './order-detail.component.html',
  styleUrls: ['./order-detail.component.css']
})
export class OrderDetailComponent implements OnInit {

  orderId: number;
  order: Order = new Order();

  constructor(private orderService: OrderService,
             private toastService: ToastService,
             private router: Router,
             private eventDataService: EventDataService
             ) { }

  ngOnInit(): void {
    this.eventDataService.eventData.subscribe({
      next: (event) => {
        if(event)
          this.orderId = event;
          this.detailOrder(event);
      },
      error: (err) => {
        this.toastService.error('Erro ao realizar procedimento!');
      }
    })
  }

  detailOrder(id){
    this.orderService.getById(id).subscribe({
      next: (order) => {
        if(order) this.order = order;
      },
      error: (err) => {
        this.toastService.error('Erro ao buscar dados do Pedido!');
      }
    }) 
  }

  return(){
     this.router.navigate(['pedidos']);
  }
}
