import { Injectable } from '@angular/core';
import { AccountOverviewModel } from '../models/account-overview.model';

@Injectable({
  providedIn: 'root',
})
export class AccountOverviewService {
  get accountOverview(): AccountOverviewModel {
    return {
      supportContact: {
        name: 'John Smith',
        email: 'john.smith@feefo.com',
      },
      salesOverview: {
        uploads: 8,
        successfulUploads: 3,
        linesAttempted: 20,
        linesSaved: 4,
        lastUploadDate: 1605001226079,
      },
    };
  }
}
