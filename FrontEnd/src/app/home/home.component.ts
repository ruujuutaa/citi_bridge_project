import { Component, OnInit } from '@angular/core';
import { Stock } from '../stock';
import { StockServiceService } from '../stock-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  //stocks : Stock[]=[];
  stocks : Stock[]=[];
  sectorSelected : string;
  sectors : string[] =["Financial Services","Construction Materials","Automobile and Auto Components","Fast Moving Consumer Goods","Healthcare","Information Technology","Metals & Mining"];
  constructor(private stockService : StockServiceService) { }

  ngOnInit(): void {
    
    this.sectorSelected=this.sectors[0];
    this.onSectorSelected(this.sectorSelected);
  }
  
  onSectorSelected(val : any){
    this.stockService.getStocks(val).subscribe((res)=>{
      this.stocks = res;
      console.log(JSON.stringify(this.stocks));
      console.log("hi")
      
  })
  }

// ngOnInit(): void {
//   this.stockService.getStocks("Financial Services").subscribe((res)=>{
//           this.stocks= res;
//           console.log(JSON.stringify(this.stocks));
//           console.log("hi")
          
//       })
// }
}
