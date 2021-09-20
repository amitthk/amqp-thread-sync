import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UserLogin } from '../../models';
import { AuthService } from '../../services/auth.service';
import { HttpResponse } from '@angular/common/http';

@Component({
  selector: 'json-to-table',
  templateUrl: './json-to-table.component.html',
  styleUrls: ['./json-to-table.component.css']
})
export class JsonToTableComponent implements OnInit , OnChanges{
constructor(){

}

@Input("jsonData") jsonData?: any[];

ngOnInit(){

}

ngOnChanges(changes: SimpleChanges){
    if(changes.jsonData){
        this.jsonData= changes.jsonData.currentValue;
    }
}

}