import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component'
import { NavbarComponent } from './navbar/navbar.component';
import { WatchlistComponent } from './watchlist/watchlist.component';
const routes: Routes = [
  {
    path:'', 
    component: LoginComponent,
  },
  {
    path:'home', 
    component: HomeComponent,
    
  },
  {
    path:'login', 
    component: LoginComponent

  },
  {
    path:'watchlist', 
    component: WatchlistComponent

  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
