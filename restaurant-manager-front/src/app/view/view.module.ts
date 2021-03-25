import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {OrderListComponent} from './order/order-list/order-list.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {RouterModule} from '@angular/router';
import {AuthGuard} from '../core/guard/auth.guard';
import {ToastsComponent} from '../shared/components/toasts/toasts.component';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from '../core/components/register/register.component';
import { OrderCadComponent } from './order/order-cad/order-cad.component';
import {ComponentsModule} from '../shared/components/components.module';



@NgModule({
  declarations: [
    OrderListComponent,
    ToastsComponent,
    OrderCadComponent
  ],
  imports: [
    CommonModule,
    NgbModule,
    ReactiveFormsModule,
    FormsModule,
    ComponentsModule,
    RouterModule.forChild([
      {
        path: '',
        component: LoginComponent,
      },
      {
        path: 'register',
        component: RegisterComponent,
      },
      {
        path: 'pedidos',
        component: OrderListComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'pedidos/cad',
        component: OrderCadComponent,
        canActivate: [AuthGuard],
      }
    ])
  ],
  exports: [ OrderListComponent, ToastsComponent ],
})
export class ViewModule { }
