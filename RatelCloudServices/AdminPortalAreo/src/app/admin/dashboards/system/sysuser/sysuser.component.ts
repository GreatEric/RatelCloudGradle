import { Component, OnInit } from '@angular/core';
import {fadeInAnimation} from "../../../animations";

@Component({
  selector: 'app-sysuser',
  templateUrl: './sysuser.component.html',
  styleUrls: ['./sysuser.component.scss'],
  animations: [fadeInAnimation],
  host: { '[@fadeInAnimation]': '' },
})
export class SysuserComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
