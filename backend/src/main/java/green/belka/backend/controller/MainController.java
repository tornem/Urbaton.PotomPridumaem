package green.belka.backend.controller;

import green.belka.backend.MainService;
import green.belka.backend.model.Achievement;
import green.belka.backend.model.Achievement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@Service
public class MainController {
    @Autowired
    MainService mainService;

    @RequestMapping(
            value = {"/achievement/{id}"},
            method = {RequestMethod.GET}
    )
    public Achievement getAchievement(@PathVariable("id") UUID id){

        return mainService.getAchievement(id);
    }

    @RequestMapping(
            value = {"/achievement/"},
            method = {RequestMethod.GET}
    )
    public List<Achievement> getAchievements(){

        return mainService.getAchievements();
    }

    @RequestMapping(
            value = {"/achievement/"},
            method = {RequestMethod.POST}
    )
    public Achievement addAchievement(@RequestBody Achievement achievement){

        return mainService.addAchievement(achievement);
    }

//    @RequestMapping(
//            value = {"/achievement/{id}"},
//            method = {RequestMethod.POST}
//    )
//    public void updateAchievement(@PathVariable("id") UUID id, @RequestBody Achievement achievement){
//
//        return mainService.updateAchievement(achievement);
//    }


}
