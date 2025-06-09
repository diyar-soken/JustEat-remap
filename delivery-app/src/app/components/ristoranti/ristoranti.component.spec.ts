import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RistorantiComponent } from './ristoranti.component';

describe('RistorantiComponent', () => {
  let component: RistorantiComponent;
  let fixture: ComponentFixture<RistorantiComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [RistorantiComponent]
    });
    fixture = TestBed.createComponent(RistorantiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
