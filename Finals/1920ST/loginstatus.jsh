public LoginStatus userLogin(String username, String password) {
    if(this.loggedIn) {
        return new LoginStatus(true,"Already logged in!");
    } else {
        Boolean u = usernameExists(username);
        Boolean p = isValidPassword(password);
        if (u && p) {
            if(doLogin(username, password)) {
                return new LoginStatus(true,"Login by password.");
            } else {
                return new LoginStatus(false,"No Server Response");
            }
        } else {
            return new LoginStatus(false,"Incorrect Username/Password");
        }
    }
}

// A method inside the LoginStatus class
public CompletableFuture<LoginStatus> userLogin(String username, String password) {
    if(this.loggedIn) {
        return CompletableFuture.<LoginStatus>completedFuture(new LoginStatus(true,"Already logged in!"));
    } else {
        CompletableFuture<LoginStatus> ls = CompletableFuture.<Boolean>supplyAsync(() -> usernameExists(username))
            .thenApplyAsync(u -> u && isvalidPassWord(password))
            .thenApplyAsync(x -> {
                if (x) {
                    if (doLogin(username, password)) {
                        return new LoginStatus(true,"Login by password.");
                    } else {
                        return new LoginStatus(false,"No Server Response");
                    }
                } else {
                    return new LoginStatus(false,"Incorrect Username/Password");
                }
            });
        return ls;
    }
}