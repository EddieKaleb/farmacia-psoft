import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListProductsComponent } from './list-products/list-products.component';
import { AdminComponent } from './admin/admin.component';
import { AdminProductsComponent } from './admin/admin-products/admin-products.component';

const routes: Routes = [
  {path:'', component: ListProductsComponent},
  {path:'products/:category', component: ListProductsComponent},
  {path: 'admin', 
   component: AdminComponent,
   children: [
    {
      path:'products',
      component: AdminProductsComponent,
    },
    {
      path:'lotes',
      component: AdminProductsComponent,
    },
    {
      path:'vendas',
      component: AdminProductsComponent,
    }
   ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
