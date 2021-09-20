import { RouterModule, Routes } from '@angular/router';

import { BucketSummaryComponent } from './bucket-summary/bucket-summary.component';
import { BucketObjectsComponent } from './bucket-objects/bucket-objects.component';
import { AuthGuard } from '../../utility/auth.guard';

export const BucketManagerRoutes: Routes = [
    { path: 'buckets', redirectTo: 'bucketsummary', pathMatch: 'full' },
    { path: 'bucketsummary', component: BucketSummaryComponent, canActivate: [AuthGuard]},
    { path: 'bucketobjects', component: BucketObjectsComponent, canActivate: [AuthGuard]}];