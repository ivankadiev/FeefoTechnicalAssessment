import { Component, Input } from '@angular/core';
import { faEnvelope } from '@fortawesome/free-solid-svg-icons';
import { SupportContactModel } from '../../shared/models/support-contact.model';

@Component({
  selector: 'app-account-overview-header',
  templateUrl: './account-overview-header.component.html',
  styleUrls: ['./account-overview-header.component.css'],
})
export class AccountOverviewHeaderComponent {
  @Input() supportContact: SupportContactModel | undefined;
  readonly emailIcon = faEnvelope;
}
