import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CatProfile, CatProfileService } from './cat-profile.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, NavbarComponent, CommonModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'frontend';
  catProfiles: CatProfile[] = [];
  filterText: string = '';
  filteredCatProfiles: CatProfile[] = [];

  constructor(private catProfileService: CatProfileService) {}

  ngOnInit(): void {
    this.catProfileService.getCatProfiles().subscribe((profiles) => {
      this.catProfiles = profiles;
      this.filteredCatProfiles = profiles;
    });
  }

  filterCats(filterText: string): void {
    console.log('Filtering cats with value:', filterText);
    this.filteredCatProfiles = this.catProfiles.filter(cat => {
      const matches = cat.name.toLowerCase().includes(filterText.toLowerCase());
      if (matches) {
        console.log('Cat matches filter:', cat);
      }
      return matches;
    });
  }
}
