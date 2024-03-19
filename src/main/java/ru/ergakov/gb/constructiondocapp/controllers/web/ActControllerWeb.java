package ru.ergakov.gb.constructiondocapp.controllers.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ergakov.gb.constructiondocapp.model.Act;
import ru.ergakov.gb.constructiondocapp.service.ActService;

import java.util.List;

@Controller
@AllArgsConstructor
public class ActControllerWeb {
    private final ActService actService;
    @GetMapping("/acts")
    public String findAll(Model model) {
        List<Act> acts = actService.getAllActs();
        model.addAttribute("acts", acts);
        return "act-list";
    }

//    @GetMapping("/acts-admin")
//    public String findAllAdmin(Model model) {
//        List<Act> acts = actService.getAllActs();
//        model.addAttribute("acts", acts);
//        return "act-list-old";
//    }

    /**
     * Метод получения списка всех актов для авторизованных пользователей
     *
     * @param model Model
     * @return html представление списка всех актов
     */
    @GetMapping("/public-data")
    public String findAllUser(Model model) {
        List<Act> acts = actService.getAllActs();
        model.addAttribute("acts", acts);
        return "user-act-list";
    }

    @GetMapping("/act-create")
    public String createActForm(Act ignoredAct) {
        return "act-create";
    }

    @PostMapping("/act-create")
    public String createAct(Act act) {
        actService.createAct(act);
        return "redirect:/public-data";
    }

    @GetMapping("/act-delete/{id}")
    public String deleteAct(@PathVariable("id") Long id) {
        actService.deleteAct(id);
        return "redirect:/public-data";
    }

    @GetMapping("/act-update/{id}")
    public String getOneAct(@PathVariable("id") Long id, Model model) {
        Act act = actService.getActById(id);
        model.addAttribute("act", act);
        return "act-update";
    }

    @PostMapping("/act-update")
    public String updateAct(Act act) {
        actService.updateAct(act);
        return "redirect:/public-data";
    }

    /**
     * Метод вызова ошибки авторизации
     *
     * @return http представление ответа об ошибке авторизации
     */
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

    /**
     * Метод авторизации
     *
     * @return http представление формы авторизации
     */
    @GetMapping("/login")
    public String auth() {
        return "login-page";
    }

//    @GetMapping("/find-acts-by-period")
//    public String findActsByPeriod(Model model) {
//        List<Act> acts = actService.findActByReportingPeriod("February");
//        model.addAttribute("acts", acts);
//        return "act-list";
//    }
}
