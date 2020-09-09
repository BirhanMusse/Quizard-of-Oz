import { Injectable } from '@angular/core';

@Injectable()

export class MyService {

    private userLogging;

    constructor() {}

    setValue(userLogging) {

        this.userLogging = userLogging;
    }

    getValue() {

        return this.userLogging ;
    }
}