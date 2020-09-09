
export class UserLogging {

    //instance variables 
    username: string; 
    firstname: string;
    lastname: string;
    email: string;
    usertype: string; 

    id: number; 


    //constructor
    constructor(username: string, firstname: string, lastname: string, email: string, usertype: string, id: number) {
        this.username = username; 
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.usertype = usertype;
        this.id = id; 

    }
    
}