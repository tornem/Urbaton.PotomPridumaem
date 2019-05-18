package green.belka.backend;


import green.belka.backend.model.Achievement;
import green.belka.backend.model.User;
import green.belka.backend.repository.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MainServiceImpl implements MainService {



    @Autowired
    AchievementRepository achievementRepository;

    @Override
    public Achievement getAchievement(UUID id) {
        return null;
    }

    @Override
    public List<Achievement> getAchievements() {
        return null;
    }

    @Override
    public Achievement addAchievement(Achievement achievement) {
        return null;
    }

    @Override
    public void updateAchievement(Achievement achievement) {

    }

    @Override
    public void deleteAchievement(UUID id) {

    }

    @Override
    public User getUser(UUID id) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(UUID id) {

    }

//    private void validateExists(UUID id)  {
//        if (!UserRepository.existsById(id)) {
//            throw new Exception("Customer with id " + id + " doesn't exist");
//        }
//    }
}
