import { Component } from '@angular/core';
import { WitcherModel } from '../services/api/models/witcher-model';
import { WitcherService } from '../services/api/witchers/witcher.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-witcher',
  templateUrl: './add-witcher.component.html',
  styleUrl: './add-witcher.component.scss'
})
export class AddWitcherComponent {
  constructor(private witcherService: WitcherService, private router: Router) {

  }

  witcher: WitcherModel = {};

  saveWitcher() {
    this.witcherService.createWitcher(this.witcher).subscribe({
      next: (data: WitcherModel) => {
        this.router.navigate(["/witchers"]);
      }
    });
  }

}
