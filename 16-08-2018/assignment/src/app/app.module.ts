import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FirstComponent } from './first/first.component';
import { HttpClientModule } from '@angular/common/http';
import { FilterCategoriesPipe } from './first/filter-categories.pipe';


@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    FilterCategoriesPipe,
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
