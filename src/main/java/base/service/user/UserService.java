package base.service.user;

import base.entity.User;

public interface UserService {
    User getUser(String login);
}
