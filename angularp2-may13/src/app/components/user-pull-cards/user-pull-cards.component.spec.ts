import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserPullCardsComponent } from './user-pull-cards.component';

describe('UserPullCardsComponent', () => {
  let component: UserPullCardsComponent;
  let fixture: ComponentFixture<UserPullCardsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserPullCardsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserPullCardsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
