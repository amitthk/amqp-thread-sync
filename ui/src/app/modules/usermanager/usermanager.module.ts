import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ListComponent } from './list/list.component';
import { AddComponent } from './add/add.component';
import { EditComponent } from './edit/edit.component';
import { ViewComponent } from './view/view.component';

import { UserManagerRoutes } from './usermanager-routes';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(UserManagerRoutes)
  ],
  declarations: [ListComponent, AddComponent, EditComponent, ViewComponent]
})
export class UserManagerModule { }
