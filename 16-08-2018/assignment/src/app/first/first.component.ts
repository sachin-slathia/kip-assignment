import {Component, OnInit} from '@angular/core';
import {DataService} from './data.service';
import {Config} from './values';
import {Cart} from './cart';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent implements OnInit {
  allData;
  category: string[] = [];
  cart: Cart[] = [];
  totalPrice = 0;

  constructor(public first: DataService) {
  }

  addItems(name: string, price1: number, quantity1: number) {
    const index = this.cart.findIndex(item => item.item === name);
    if (index === -1) {
      this.cart.push({item: name, price: price1, quantity: 1});
      this.totalPrice += price1;
    } else {
      this.cart[index].quantity += 1;
      this.totalPrice += price1;
    }
  }

  removeItems(name: string, price1: number) {
    console.log(this.cart);
    const index = this.cart.findIndex(record => record.item === name);
    if (this.cart[index].quantity <= 1) {
      this.cart.splice(index, 1);
      this.totalPrice -= price1;
    } else {
      this.cart[index].quantity--;
      this.totalPrice -= price1;
    }
    console.log(this.cart);
  }

  ngOnInit() {
    this.first.getJsonData().subscribe((data: Config[]) => {
      this.allData = data;
      data.map((cat) => {
        this.category.push(cat.category);
      });
      this.category = this.category.filter(function (item, i, ar) {
        return ar.indexOf(item) === i;
      });
    });
  }


}
