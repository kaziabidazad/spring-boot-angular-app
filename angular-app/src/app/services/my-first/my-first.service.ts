import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MyFirstService {

  constructor() {
     this.init();
   }

  messages: Array<any> = [];

  init(): void {
    this.messages.push({
      name: 'Kazi',
      'email': "kazi@kazi.com",
      'message': "First message from Kazi"
    });
    this.messages.push({
      name: 'Duke',
      'email': "duke@duke.com",
      'message': "First message from Duke"
    });
    this.messages.push({
      name: 'Simran',
      'email': "simran@simran.com",
      'message': "First message from Simran"
    });

  }

  insert(message: { name: string, email: string, message: string }): void {
    this.messages.push(message);
  }

  getAllMessages(): any[] {
    return this.messages;
  }

  deleteMessages(index: number) {
    this.messages.splice(index, 1);
  }
}
