export class LoginCreds {
    id: number;
    uName: string;
    pWord: string;

    constructor(id: number, uName: string, pWord: string) {
        this.id = id;
        this.uName = uName;
        this.pWord = pWord;
    }
}