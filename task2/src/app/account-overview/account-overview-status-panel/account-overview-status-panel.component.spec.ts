import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountOverviewStatusPanelComponent } from './account-overview-status-panel.component';

describe('AccountOverviewStatusPanelComponent', () => {
  let component: AccountOverviewStatusPanelComponent;
  let fixture: ComponentFixture<AccountOverviewStatusPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AccountOverviewStatusPanelComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AccountOverviewStatusPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
