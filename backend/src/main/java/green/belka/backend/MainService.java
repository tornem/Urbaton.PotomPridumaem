package green.belka.backend;


import green.belka.backend.model.Achievement;
import green.belka.backend.model.ResponseData;
import green.belka.backend.model.User;

import java.util.List;
import java.util.UUID;

public interface MainService {
    ResponseData<Achievement> getAchievement(UUID id);

    ResponseData<List<Achievement>> getAchievements();

    ResponseData<UUID> addAchievement(Achievement achievement);

    ResponseData<UUID> updateAchievement(Achievement achievement);

    ResponseData<UUID> deleteAchievement(UUID id);

    ResponseData<User> getUser(Long id);

    ResponseData<List<User>> getUsers();

    ResponseData<Long> addUser(User user);

    ResponseData<Long> updateUser(User user);

    ResponseData<Long> deleteUser(Long id);
}
