import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccountOverviewComponent } from './account-overview/account-overview.component';
import { AccountOverviewHeaderComponent } from './account-overview/account-overview-header/account-overview-header.component';
import { AccountOverviewStatusPanelComponent } from './account-overview/account-overview-status-panel/account-overview-status-panel.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

@NgModule({
  declarations: [
    AppComponent,
    AccountOverviewComponent,
    AccountOverviewHeaderComponent,
    AccountOverviewStatusPanelComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FontAwesomeModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
