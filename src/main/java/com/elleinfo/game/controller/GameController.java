package com.elleinfo.game.controller;

import com.elleinfo.game.entity.GiantBombGame;
import com.elleinfo.game.model.Game;
import com.elleinfo.game.model.GameFilter;
import com.elleinfo.game.service.GameService;
import com.elleinfo.game.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {

  private static final Logger LOGGER = LoggerFactory.getLogger(GameController.class);
  @Autowired
  private GameService gameService;

  public GameController() {
  }

  @GetMapping("/")
  public String index(Model model) {

    return "redirect:/games";
  }

  @GetMapping("/about")
  public String about(Model model) {

    return "about";
  }

  @GetMapping("/games")
  public String getAll(Model model, @RequestParam(required = false) String name,
                       @RequestParam(required = false) String aliases,
                       @RequestParam(required = false) String platforms,
                       @RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "10") int size) {

    List<Game> games = new ArrayList<Game>();
    try {
      Pageable paging = PageRequest.of(page - 1, size);

      Page<Game> pageGames;
      GameFilter filter = new GameFilter.Builder()
              .setName(name)
              .setAliases(aliases)
              .setPlatforms(platforms)
              .build();
      pageGames = gameService.findGames(filter, paging);

      games = pageGames.getContent();

      model.addAttribute("currentPage", pageGames.getNumber() + 1);
      model.addAttribute("totalItems", pageGames.getTotalElements());
      model.addAttribute("totalPages", pageGames.getTotalPages());
      model.addAttribute("pageSize", size);
      model.addAttribute("platformsMap", Utils.getPlatformsMap());
      model.addAttribute("name", name);
      model.addAttribute("aliases", aliases);
      model.addAttribute("platforms", platforms);
      LOGGER.info(model.toString());
      model.addAttribute("games", games);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "games";
  }




  @GetMapping("/game/{id}")
  public String getGame(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
    try {
      GiantBombGame game = gameService.findById(id).get();

      model.addAttribute("game", game);
      return "game";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
      return "redirect:/games";
    }
  }



}
