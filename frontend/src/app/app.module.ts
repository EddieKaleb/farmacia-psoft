import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListProductsComponent } from './list-products/list-products.component';
import { ProductCardComponent } from './list-products/product-card/product-card.component';
import { MenuComponent } from './menu/menu.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { ModalModule } from 'ngx-bootstrap/modal';
import { AdminComponent } from './admin/admin.component';
import { AdminMenuComponent } from './admin/admin-menu/admin-menu.component';
import { AdminProductsComponent } from './admin/admin-products/admin-products.component';
import { ProductListItemComponent } from './admin/admin-products/product-list-item/product-list-item.component';


@NgModule({
  declarations: [
    AppComponent,
    ListProductsComponent,
    ProductCardComponent,
    MenuComponent,
    HeaderComponent,
    LoginComponent,
    AdminComponent,
    AdminMenuComponent,
    AdminProductsComponent,
    ProductListItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ModalModule.forRoot(),
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [LoginComponent],
})
export class AppModule { }
