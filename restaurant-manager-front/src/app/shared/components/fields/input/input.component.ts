import { Component, Input, OnInit } from '@angular/core';
import { AbstractControl} from '@angular/forms';

@Component({
  selector: 'app-input',
  templateUrl: './input.component.html',
  styleUrls: ['./input.component.css'],
})
export class InputComponent implements OnInit {
  @Input() label: string;
  @Input() type: string = 'text';
  @Input() controlName: string;
  @Input() message: string;
  @Input() value: string;

  constructor() {}

  ngOnInit(): void {}
}
