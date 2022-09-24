import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../auth-service.service';
import { Stock } from '../stock';
import { StockServiceService } from '../stock-service.service';
import UpdateService from '../update.service';
import { User } from '../user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  //stocks : Stock[]=[];
  //user : User;
  username : string;
  stocks : Stock[]=[];
  sectorSelected : string;
  sectors : string[] =["Financial Services","Construction Materials","Automobile and Auto Components","Fast Moving Consumer Goods","Healthcare","Information Technology","Metals & Mining"];
  constructor(private stockService : StockServiceService, private updateService : UpdateService,public authService : AuthServiceService) { }

  ngOnInit(): void {
    this.username=this.authService.username;
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

  addStock(stock : string, username: string){
    //this.user.stocks=[...this.user.stocks,stock];
    this.updateService.updateStocks(stock, username);

  }

  

// ngOnInit(): void {
//   this.stockService.getStocks("Financial Services").subscribe((res)=>{
//           this.stocks= res;
//           console.log(JSON.stringify(this.stocks));
//           console.log("hi")
          
//       })
// }
}
