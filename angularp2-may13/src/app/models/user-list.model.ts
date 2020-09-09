import { User } from './user.model';

export class UserList {

    users: User[];

    constructor(users: User[]) {
        this.users = users;
        
    }
}
