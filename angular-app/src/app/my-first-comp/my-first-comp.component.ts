import { Component } from '@angular/core';
import { MyFirstService } from '../services/my-first/my-first.service';

@Component({
  selector: 'app-my-first-comp',
  templateUrl: './my-first-comp.component.html',
  styleUrl: './my-first-comp.component.scss'
})
export class MyFirstCompComponent {

  constructor(private firstService: MyFirstService) {
    this.messages = firstService.getAllMessages();
    this.isSubmitted = this.messages.length > 0;
  }

  name: string = '';
  email: string = '';
  message: string = '';
  isSubmitted: boolean = false;
  messages: Array<any> = [];
  onSubmit(): void {
    if (!this.isValid())
      return;
    // alert(this.name + " -> " + this.email + " email: " + this.message);
    this.isSubmitted = true;
    var jsonMessage = {
      "name": this.name,
      "email": this.email,
      "message": this.message
    };
    this.firstService.insert(jsonMessage);
    this.clearForm();
  }
  isValid(): boolean {
    if (this.name.trim() === '' || this.email.trim() === '' || this.message.trim() === '')
      return false;
    return true;
  }
  toggleSubmit() {
    // this.isSubmitted = false;
  }
  clearForm(): void {
    this.name = '';
    this.email = '';
    this.message = '';
  }

  deleteMessage(msgId: number) {
     this.firstService.deleteMessages(msgId);
  }
}
