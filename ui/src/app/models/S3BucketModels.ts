export class BucketInfoModel{
    bucket_name: String = '';
    creation_date: String= '';
    last_modified: String= '';
    number_of_files: Number= 0;
    total_size_of_files: Number= 0;
}

export class BucketDetailsModel{
    bucket_name: String= '';
    file_paths: String[]= [];
}