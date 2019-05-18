package green.belka.backend;


import green.belka.backend.model.Achievement;
import green.belka.backend.model.User;

import java.util.List;
import java.util.UUID;

public interface MainService {
    Achievement getAchievement(UUID id);

    List<Achievement> getAchievements();

    Achievement addAchievement(Achievement achievement);

    void updateAchievement(Achievement achievement);

    void deleteAchievement(UUID id);

    User getUser(UUID id);

    List<User> getUsers();

    User addUser(User user);

    void updateUser(User user);

    void deleteUser(UUID id);
}
