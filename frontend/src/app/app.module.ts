import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
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
import { ShoppingCartComponent } from './home/shopping-cart/shopping-cart.component';
import { ItemCartComponent } from './home/shopping-cart/item-cart/item-cart.component';
import { AdminLotsComponent } from './admin/admin-lots/admin-lots.component';
import { LotListItemComponent } from './admin/admin-lots/lot-list-item/lot-list-item.component';
import { AdminAddProductComponent } from './admin/admin-products/admin-add-product/admin-add-product.component';
import { AdminDescontosComponent } from './admin/admin-products/admin-descontos/admin-descontos.component';
import { UsuarioComponent } from './home/usuario/usuario.component';
import { ReservaComponent } from './home/usuario/reserva/reserva.component';
import { AdminVendasComponent } from './admin/admin-vendas/admin-vendas.component';
import { VendaListItemComponent } from './admin/admin-vendas/venda-list-item/venda-list-item.component';
import { AdminAddVendaComponent } from './admin/admin-vendas/admin-add-venda/admin-add-venda.component';
import { FormsModule } from '@angular/forms';
import { AdminProductDetailsComponent } from './admin/admin-products/product-list-item/admin-product-details/admin-product-details.component';
import { AdminAddLotComponent } from './admin/admin-lots/admin-add-lot/admin-add-lot.component';

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
    ProductComponent,
    ShoppingCartComponent,
    ItemCartComponent,
    AdminLotsComponent,
    LotListItemComponent,
    AdminAddProductComponent,
    AdminDescontosComponent,
    UsuarioComponent,
    ReservaComponent,
    AdminVendasComponent,
    VendaListItemComponent,
    AdminAddVendaComponent,
    AdminProductDetailsComponent,
    AdminAddLotComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ModalModule.forRoot(),
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [LoginComponent,RegisterComponent, AdminAddProductComponent, 
    AdminDescontosComponent, AdminAddVendaComponent, AdminProductDetailsComponent,
    AdminAddLotComponent],
})
export class AppModule { }
