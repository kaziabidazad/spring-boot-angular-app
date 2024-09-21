import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WitcherModel } from '../services/api/models/witcher-model';
import { WitcherService } from '../services/api/witchers/witcher.service';

@Component({
  selector: 'app-witcher-details',
  templateUrl: './witcher-details.component.html',
  styleUrl: './witcher-details.component.scss'
})
export class WitcherDetailsComponent {

  @Input()
  witcher!: WitcherModel;
}
