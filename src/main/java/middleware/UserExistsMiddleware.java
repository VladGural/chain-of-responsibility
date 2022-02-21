/*
 * Copyright (c) 2022 Javatar LLC
 * All rights reserved.
 */

package middleware;

import server.Server;

/**
 * @author Vladyslav Gural / Javatar LLC
 * @version 19-02-2022
 */
class UserExistsMiddleware extends Middleware {
    private Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }

    public boolean check(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
            return false;
        }
        return checkNext(email, password);
    }
}
