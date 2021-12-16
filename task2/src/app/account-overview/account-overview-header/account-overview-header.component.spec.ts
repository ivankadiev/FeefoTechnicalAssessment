import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountOverviewHeaderComponent } from './account-overview-header.component';

describe('AccountOverviewHeaderComponent', () => {
  let component: AccountOverviewHeaderComponent;
  let fixture: ComponentFixture<AccountOverviewHeaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AccountOverviewHeaderComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AccountOverviewHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
