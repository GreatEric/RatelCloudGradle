import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SysmenuComponent } from './sysmenu.component';

describe('SysmenuComponent', () => {
  let component: SysmenuComponent;
  let fixture: ComponentFixture<SysmenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SysmenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SysmenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
