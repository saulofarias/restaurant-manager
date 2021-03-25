import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NavComponent } from './nav/nav.component';
import { RouterModule } from '@angular/router';
import { InputComponent } from './fields/input/input.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InputSelectComponent } from './fields/input-select/input-select.component';

@NgModule({
  declarations: [
    NavComponent,
    InputComponent,
    InputSelectComponent,
  ],
  imports: [
    CommonModule,
    NgbModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule.forChild([
    ]),
  ],
  exports: [NavComponent, InputSelectComponent, InputComponent ],
})
export class ComponentsModule {}
