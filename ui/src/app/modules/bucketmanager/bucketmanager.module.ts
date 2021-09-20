import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BucketSummaryComponent } from './bucket-summary/bucket-summary.component';
import { BucketObjectsComponent } from './bucket-objects/bucket-objects.component';

import { BucketManagerRoutes } from './bucketmanager-routes';
import { AuthGuard } from '../../utility/auth.guard';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    RouterModule.forChild(BucketManagerRoutes)

  ],
  declarations: [BucketSummaryComponent, BucketObjectsComponent],
  providers: [AuthGuard]
})
export class BucketManagerModule { }
