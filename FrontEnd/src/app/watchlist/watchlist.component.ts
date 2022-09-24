import { Component, OnInit } from '@angular/core';
import { Stock } from '../stock';
import UpdateService from '../update.service';

@Component({
  selector: 'app-watchlist',
  templateUrl: './watchlist.component.html',
  styleUrls: ['./watchlist.component.css']
})
export class WatchlistComponent implements OnInit {
  public userName: string;
  stocks : Stock[];
  constructor(private updateService : UpdateService) { }

  ngOnInit(): void {
    console.log(history.state)
    this.userName=history.state.data;
    console.log(this.userName);
    this.getSavedStocks(this.userName);
  }

  getSavedStocks(username: string){
     this.updateService.getSavedStocks(username).subscribe((res) =>{
      this.stocks=res;
     });

  }
  removeStock(stock: string, username : string){
    this.updateService.removeStock(stock,username);
    this.getSavedStocks(username);
  }

}
