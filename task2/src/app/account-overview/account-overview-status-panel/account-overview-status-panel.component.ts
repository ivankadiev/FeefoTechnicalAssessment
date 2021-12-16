import { Component, Input } from '@angular/core';
import { faInfoCircle, faUpload } from '@fortawesome/free-solid-svg-icons';
import { SalesOverviewModel } from '../../shared/models/sales-overview.model';

@Component({
  selector: 'app-account-overview-status-panel',
  templateUrl: './account-overview-status-panel.component.html',
  styleUrls: ['./account-overview-status-panel.component.css'],
})
export class AccountOverviewStatusPanelComponent {
  @Input() salesOverview: SalesOverviewModel | undefined;
  readonly infoCircleIcon = faInfoCircle;
  readonly uploadIcon = faUpload;

  get successfulUpload(): number {
    return this.salesOverview && this.salesOverview.uploads && this.salesOverview.successfulUploads
      ? (this.salesOverview.successfulUploads / this.salesOverview.uploads) * 100
      : 0;
  }

  get linesSaved(): number {
    return this.salesOverview && this.salesOverview.linesSaved && this.salesOverview.linesAttempted
      ? (this.salesOverview.linesSaved / this.salesOverview.linesAttempted) * 100
      : 0;
  }
}
