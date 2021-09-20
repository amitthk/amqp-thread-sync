import { RouterModule, Routes } from '@angular/router';

import { ListComponent } from './list/list.component';
import { AddComponent } from './add/add.component';
import { EditComponent } from './edit/edit.component';
import { ViewComponent } from './view/view.component';


export const UserManagerRoutes: Routes = [
    { path: 'users', redirectTo: 'list', pathMatch: 'full' },
    { path: 'list', component: ListComponent},
    { path: 'add', component: AddComponent},
    { path: 'edit', component: EditComponent},
    { path: 'view', component: ViewComponent}];
