package green.belka.backend.controller;

import green.belka.backend.MainService;
import green.belka.backend.model.Achievement;
import green.belka.backend.model.Achievement;
import green.belka.backend.model.ResponseData;
import green.belka.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class MainController {

    @Autowired
    MainService mainService;

    @RequestMapping(
            value = {"/achievement/{id}"},
            method = {RequestMethod.GET}
    )
    public ResponseData<Achievement> getAchievement(@PathVariable("id") Long id){
        return mainService.getAchievement(id);
    }

    @RequestMapping(
            value = {"/achievement/"},
            method = {RequestMethod.GET}
    )
    public ResponseData<List<Achievement>> getAchievements(){
        return mainService.getAchievements();
    }

    @RequestMapping(
            value = {"/achievement/"},
            method = {RequestMethod.POST}
    )
    public ResponseData<Long> addAchievement(@RequestBody Achievement achievement, @RequestParam Long userId){
        return mainService.addAchievement(achievement, userId);
    }


    @RequestMapping(
            value = {"/user/{id}"},
            method = {RequestMethod.GET}
    )
    public ResponseData<User> getUser(@PathVariable("id") Long id){
        return mainService.getUser(id);
    }

    @RequestMapping(
            value = {"/user/"},
            method = {RequestMethod.GET}
    )
    public ResponseData<List<User>> getUsers(){
        return mainService.getUsers();
    }

    @RequestMapping(
            value = {"/user/"},
            method = {RequestMethod.POST}
    )
    public ResponseData<Long> addUser(@RequestBody User user){
        return mainService.addUser(user);
    }


}
