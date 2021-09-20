import { Component, OnInit } from '@angular/core';
import { ModalService } from 'src/app/services/modal.service';
import * as XLSX from "xlsx";

@Component({
  selector: 'app-excel-uploader',
  templateUrl: './excel-uploader.component.html',
  styleUrls: ['./excel-uploader.component.css']
})
export class ExcelUploaderComponent implements OnInit {

  constructor(private modalService: ModalService) { }

  ngOnInit(): void {
  }

  arrayBuffer:any;
  fileToUpload:File | null = null;
  loadedJsonObject: any = null;


handleFileInput(event:Event) {
  const target= event.target as HTMLInputElement;
  const file: File = (target.files as FileList)[0];
  this.fileToUpload=file;
}


  uploadExcel(event:Event) {
      let fileReader = new FileReader();
        fileReader.onload = (e) => {
            this.arrayBuffer = fileReader.result;
            var data = new Uint8Array(this.arrayBuffer);
            var arr = new Array();
            for(var i = 0; i != data.length; ++i) arr[i] = String.fromCharCode(data[i]);
            var bstr = arr.join("");
            var workbook = XLSX.read(bstr, {type:"binary"});
            var first_sheet_name = workbook.SheetNames[0];
            var worksheet = workbook.Sheets[first_sheet_name];
            this.loadedJsonObject= XLSX.utils.sheet_to_json(worksheet,{raw:true});
        }
        if(this.fileToUpload){
        fileReader.readAsArrayBuffer(this.fileToUpload);
        }
}

openModal(id: string) {
  this.modalService.open(id);
}

closeModal(id: string) {
  this.modalService.close(id);
}


}
