import { Routes } from '@angular/router';
import { ParentCompo } from './Components/parent-compo/parent-compo';

export const routes: Routes = [

{
    path:'',
    redirectTo:'/view',
    pathMatch:'full'
},
{
    path:'view',
    component:ParentCompo
}


];
