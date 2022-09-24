import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from '../auth-service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router: Router,public auth: AuthServiceService) { }

  ngOnInit(): void {
  }

  toWatchlist(){
    this.router.navigate(['/watchlist'],{state:{data:this.auth.username}});
  }

}