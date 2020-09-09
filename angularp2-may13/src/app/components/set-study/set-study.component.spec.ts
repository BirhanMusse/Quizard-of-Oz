import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SetStudyComponent } from './set-study.component';

describe('SetStudyComponent', () => {
  let component: SetStudyComponent;
  let fixture: ComponentFixture<SetStudyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SetStudyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SetStudyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
