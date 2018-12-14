import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListProductsComponent } from './home/list-products/list-products.component';
import { ProductCardComponent } from './home/list-products/product-card/product-card.component';
import { MenuComponent } from './home/header/menu/menu.component';
import { HeaderComponent } from './home/header/header.component';
import { LoginComponent } from './home/login/login.component';
import { ModalModule } from 'ngx-bootstrap/modal';
import { AdminComponent } from './admin/admin.component';
import { AdminMenuComponent } from './admin/admin-header/admin-menu/admin-menu.component';
import { AdminProductsComponent } from './admin/admin-products/admin-products.component';
import { ProductListItemComponent } from './admin/admin-products/product-list-item/product-list-item.component';
import { HomeComponent } from './home/home.component';
import { AdminHeaderComponent } from './admin/admin-header/admin-header.component';
import { RegisterComponent } from './home/register/register.component';
import { ProductComponent } from './home/product/product.component';

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
    ProductListItemComponent,
    HomeComponent,
    AdminHeaderComponent,
    RegisterComponent,
    ProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ModalModule.forRoot(),
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [LoginComponent,RegisterComponent],
})
export class AppModule { }
