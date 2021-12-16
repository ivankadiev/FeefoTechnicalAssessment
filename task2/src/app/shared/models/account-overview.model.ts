import { SalesOverviewModel } from './sales-overview.model';
import { SupportContactModel } from './support-contact.model';

export interface AccountOverviewModel {
  supportContact: SupportContactModel;
  salesOverview: SalesOverviewModel;
}
