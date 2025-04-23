import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CatProfileService } from '../../cat-profile.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
  imports: [FormsModule]
})
export class NavbarComponent {
  filterText: string = '';

  @Output() filterChanged = new EventEmitter<string>();

  constructor(private catProfileService: CatProfileService) { }

  filterCats(): void {
    console.log('Filter triggered with value:', this.filterText);
    this.filterChanged.emit(this.filterText);
  }

  generateRandomCat(): void {
    this.catProfileService.generateRandomCat().subscribe((newCat) => {
      console.log('Generated Random Cat:', newCat);
      this.filterChanged.emit(''); // Trigger a refresh of the displayed cats
    });
  }
}
