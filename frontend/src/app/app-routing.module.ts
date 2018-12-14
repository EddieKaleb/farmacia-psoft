import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListProductsComponent } from './home/list-products/list-products.component';
import { AdminComponent } from './admin/admin.component';
import { AdminProductsComponent } from './admin/admin-products/admin-products.component';
import { HomeComponent } from './home/home.component';
import { ProductComponent } from './home/product/product.component';
import { ShoppingCartComponent } from './home/shopping-cart/shopping-cart.component';

const routes: Routes = [
  {path:'', component: HomeComponent,
   children: [
    {path:'', component: ListProductsComponent},
    {path:'products/:category', component: ListProductsComponent},
    {path:'product', component: ProductComponent},
    {path:'shopping-cart', component: ShoppingCartComponent},
  ]},
  {path: 'admin', component: AdminComponent,
   children: [
    {path:'products', component: AdminProductsComponent},
    {path:'lotes', component: AdminProductsComponent},
    {path:'vendas', component: AdminProductsComponent}
   ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
