import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { AbstractControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-input-select',
  templateUrl: './input-select.component.html',
  styleUrls: ['./input-select.component.css'],
})
export class InputSelectComponent implements OnInit {
  @Input() label: string;
  @Input() controlName: string;
  @Input() message: string;
  @Input() options: Array<any> = []; 
  @Output() inputValue = new EventEmitter();

  constructor() {}

  ngOnInit(): void {
  }

  change(event){
    this.inputValue.emit({value: event.value});
  }
}
