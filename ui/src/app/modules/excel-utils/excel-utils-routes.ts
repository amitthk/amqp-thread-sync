import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from 'src/app/utility/auth.guard';
import { ExcelUploaderComponent } from './excel-uploader/excel-uploader.component';
import { MongoBrowserComponent } from './mongo-browser/mongo-browser.component';

export const ExcelUtilsRoutes: Routes = [
    { path: 'excel-utils', redirectTo: 'excel-uploader', pathMatch: 'full' },
    { path: 'excel-uploader', component: ExcelUploaderComponent, canActivate: [AuthGuard]},
    { path: 'mongo-browser', component: MongoBrowserComponent, canActivate: [AuthGuard]}];