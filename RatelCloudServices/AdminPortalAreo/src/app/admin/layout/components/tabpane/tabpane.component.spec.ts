import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TabpaneComponent } from './tabpane.component';

describe('TabpaneComponent', () => {
  let component: TabpaneComponent;
  let fixture: ComponentFixture<TabpaneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabpaneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TabpaneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
