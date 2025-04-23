import { Component, OnInit } from '@angular/core';
import { CatProfile, CatProfileService } from '../../cat-profile.service';

@Component({
  selector: 'app-cat-profile',
  templateUrl: './cat-profile.component.html',
  styleUrls: ['./cat-profile.component.scss']
})
export class CatProfileComponent implements OnInit {
  catProfiles: CatProfile[] = [];

  constructor(private catProfileService: CatProfileService) {}

  ngOnInit(): void {
    this.loadCatProfiles();
  }

  loadCatProfiles(): void {
    this.catProfileService.getCatProfiles().subscribe((profiles) => {
      this.catProfiles = profiles;
    });
  }

  generateRandomCat(): void {
    this.catProfileService.generateRandomCat().subscribe((newCat) => {
      this.catProfiles.push(newCat);
    });
  }

  deleteCatProfile(id: number): void {
    this.catProfileService.deleteCatProfile(id).subscribe(() => {
      this.catProfiles = this.catProfiles.filter((cat) => cat.id !== id);
    });
  }
}
