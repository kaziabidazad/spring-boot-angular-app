import { Component, Input, OnInit } from '@angular/core';
import { WitcherModel } from '../services/api/models/witcher-model';
import { ActivatedRoute } from '@angular/router';
import { WitcherService } from '../services/api/witchers/witcher.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-witcher',
  templateUrl: './witcher.component.html',
  styleUrl: './witcher.component.scss'
})
export class WitcherComponent implements OnInit {

  @Input()
  witchers: Array<WitcherModel> = [];

  param!: any;

  constructor(
    private activatedRoute: ActivatedRoute,
    private witcherService: WitcherService) { }

  ngOnInit(): void {
    // acticated route contains all the query and param info
    //console.log(this.activatedRoute);
    // access the url params
    this.param = this.activatedRoute.snapshot.params['username'];
    console.log('param: ' + this.param);
    this.witcherService.getAllWitchers().subscribe({
      next: (data: WitcherModel[]) => {
        this.witchers = data;
      }, error: (err: HttpErrorResponse) => {
        if (err instanceof ErrorEvent) {
          console.log("An error while calling api: " + err);
        } else {
          // Server Error
          console.log("Error from server: " + err.message);
        }
      },
    });
  }
}