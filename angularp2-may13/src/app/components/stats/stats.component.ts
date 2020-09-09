import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html',
  styles: [`
    ngb-progressbar {
      margin-top: 5rem;
    }
  `]
})
export class StatsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
