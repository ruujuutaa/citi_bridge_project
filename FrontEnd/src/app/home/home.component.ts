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
  stocks : Stock[][] =[[]];
  sectors : string[] =["Financial Services","Construction Materials","Automobile and Auto Components","Fast Moving Consumer Goods","Healthcare","Information Technology","Metals & Mining"];
  constructor(private stockService : StockServiceService) { }

  ngOnInit(): void {
    var i =0 ;
    this.sectors.forEach((sector) =>{
      this.stockService.getStocks(sector).subscribe((res)=>{
        this.stocks[i] = res;
        console.log(JSON.stringify(this.stocks[i]));
        console.log("hi")
        
    })
   
    i++;
    
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
