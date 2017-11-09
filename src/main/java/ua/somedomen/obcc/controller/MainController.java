package ua.somedomen.obcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.somedomen.obcc.entity.News;
import ua.somedomen.obcc.entity.Voting;
import ua.somedomen.obcc.service.NewsService;
import ua.somedomen.obcc.service.VotingService;

import java.security.Principal;


@Controller
public class MainController {

//    String qwe = "Roman the best";
//
    @Autowired
    private VotingService votingService;

    @Autowired
    private NewsService newsService;

    @GetMapping("/")
    public String index(Model model) {
//        model.addAttribute("URL", new ListURL());
//        model.addAttribute("ABC", qwe);
        model.addAttribute("votingShowAll", votingService.findALL());
        model.addAttribute("newsShowAll", newsService.findALL());
        return "index";
    }



    @GetMapping("/admin")
    public String loginAmd(Principal principal, Model model)
    {
        model.addAttribute("user", principal);
        return "admin";
    }

    @GetMapping("/login")
    public String indexLogin()
    {
        return "login";
    }


    @PostMapping("/addNews")
    public String addNews(
            @RequestParam("newsName") String newsName,
            @RequestParam("newsText") String newsText){
        newsService.addNews(new News(newsName, newsText));

        return "redirect:/";
    }

    @PostMapping("/addVoting")
    public String addVoting(
            @RequestParam("votingName") String votingName,
            @RequestParam("votingText") String votingText){
        votingService.addVoting(new Voting(votingName, votingText));

        return "redirect:/";
    }

//    @PostMapping("/addNewsComment")
//    public String addNewsComment(
//            @RequestParam("newsComment") String newsComment,
//        newsService.(new News(news));
//
//        return "redirect:/";
//    }


//    @PostMapping("/saveURLforVideo")
//    public String saveURLforVideo(@RequestParam("url") String url,
//                                  @RequestParam("nameOfVideo") String nameOfVideo,
//                                  @RequestParam("textForVideo") String textOfVideo) {
//        System.out.println("Hello MainController");
//        listURLService.saveURLforVideo(new ListURL(nameOfVideo, textOfVideo, url));
//        return "redirect:/";
//    }



//    @GetMapping("/allURL")
//    public String findALL(Model model){
//        model.addAttribute("listURL", listURLService.findALL());
//
//        List<ListURL> all = listURLService.findALL();
//        System.out.println(all + " \n");
//        return "listURL";
//    }
}