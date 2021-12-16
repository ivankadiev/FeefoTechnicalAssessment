import { Component } from '@angular/core';
import { AccountOverviewService } from '../shared/services/account-overview.service';
import { AccountOverviewModel } from '../shared/models/account-overview.model';

@Component({
  selector: 'app-account-overview',
  templateUrl: './account-overview.component.html',
  styleUrls: ['./account-overview.component.css'],
})
export class AccountOverviewComponent {
  readonly accountOverview: AccountOverviewModel;

  constructor(public readonly accountOverviewService: AccountOverviewService) {
    this.accountOverview = accountOverviewService.accountOverview;
  }
}
