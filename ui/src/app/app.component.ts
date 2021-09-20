import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ng-excel-uploader';

  showsidebar = false;

  onSidebarToggle(event: Event){
    this.showsidebar=!this.showsidebar;
  }
}
