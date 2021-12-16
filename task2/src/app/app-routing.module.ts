import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountOverviewComponent } from './account-overview/account-overview.component';

const routes: Routes = [
  {
    path: '',
    component: AccountOverviewComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
