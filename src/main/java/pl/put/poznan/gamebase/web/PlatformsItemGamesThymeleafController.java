package pl.put.poznan.gamebase.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooDetail;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import pl.put.poznan.gamebase.structures.Platform;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.datatables.ConvertedDatatablesData;
import io.springlets.data.web.datatables.Datatables;
import io.springlets.data.web.datatables.DatatablesColumns;
import io.springlets.data.web.datatables.DatatablesPageable;
import io.springlets.web.NotFoundException;
import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import io.springlets.web.mvc.util.MethodLinkBuilderFactory;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pl.put.poznan.gamebase.service.api.GamePlatService;
import pl.put.poznan.gamebase.service.api.PlatformService;
import pl.put.poznan.gamebase.structures.GamePlat;

/**
 * = PlatformsItemGamesThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Platform.class, type = ControllerType.DETAIL)
@RooDetail(relationField = "games", views = { "show" })
@RooThymeleaf
@Controller
@RequestMapping(value = "/platforms/{platform}/games", name = "PlatformsItemGamesThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class PlatformsItemGamesThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PlatformService platformService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private GamePlatService gamePlatService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<PlatformsCollectionThymeleafController> collectionLink;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param platformService
     * @param gamePlatService
     * @param conversionService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public PlatformsItemGamesThymeleafController(PlatformService platformService, GamePlatService gamePlatService, ConversionService conversionService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setPlatformService(platformService);
        setGamePlatService(gamePlatService);
        setConversionService(conversionService);
        setMessageSource(messageSource);
        setCollectionLink(linkBuilder.of(PlatformsCollectionThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PlatformService
     */
    public PlatformService getPlatformService() {
        return platformService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platformService
     */
    public void setPlatformService(PlatformService platformService) {
        this.platformService = platformService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return GamePlatService
     */
    public GamePlatService getGamePlatService() {
        return gamePlatService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param gamePlatService
     */
    public void setGamePlatService(GamePlatService gamePlatService) {
        this.gamePlatService = gamePlatService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MessageSource
     */
    public MessageSource getMessageSource() {
        return messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param messageSource
     */
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MethodLinkBuilderFactory
     */
    public MethodLinkBuilderFactory<PlatformsCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<PlatformsCollectionThymeleafController> collectionLink) {
        this.collectionLink = collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ConversionService
     */
    public ConversionService getConversionService() {
        return conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param conversionService
     */
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param locale
     * @param method
     * @return Platform
     */
    @ModelAttribute
    public Platform getPlatform(@PathVariable("platform") Long id, Locale locale, HttpMethod method) {
        Platform platform = null;
        if (HttpMethod.PUT.equals(method)) {
            platform = platformService.findOneForUpdate(id);
        } else {
            platform = platformService.findOne(id);
        }
        if (platform == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Platform", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return platform;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateForm(Model model) {
        populateFormats(model);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @param datatablesColumns
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatables", produces = Datatables.MEDIA_TYPE, value = "/dt")
    @ResponseBody
    public ResponseEntity<ConvertedDatatablesData<GamePlat>> datatables(@ModelAttribute Platform platform, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<GamePlat> games = getGamePlatService().findByPlatform(platform, search, pageable);
        long totalGamesCount = getGamePlatService().countByPlatform(platform);
        ConvertedDatatablesData<GamePlat> data = new ConvertedDatatablesData<GamePlat>(games, totalGamesCount, draw, getConversionService(), datatablesColumns);
        return ResponseEntity.ok(data);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param datatablesColumns
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatablesByIdsIn", produces = Datatables.MEDIA_TYPE, value = "/dtByIdsIn")
    @ResponseBody
    public ResponseEntity<ConvertedDatatablesData<GamePlat>> datatablesByIdsIn(@RequestParam("ids") List<Long> ids, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<GamePlat> games = getGamePlatService().findAllByIdsIn(ids, search, pageable);
        long totalGamesCount = games.getTotalElements();
        ConvertedDatatablesData<GamePlat> data = new ConvertedDatatablesData<GamePlat>(games, totalGamesCount, draw, getConversionService(), datatablesColumns);
        return ResponseEntity.ok(data);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView createForm(@ModelAttribute Platform platform, Model model) {
        populateForm(model);
        model.addAttribute("gamePlat", new GamePlat());
        return new ModelAndView("platforms/games/create");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @param gamesToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromGames", value = "/{gamesToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromGames(@ModelAttribute Platform platform, @PathVariable("gamesToRemove") Long gamesToRemove) {
        getPlatformService().removeFromGames(platform, Collections.singleton(gamesToRemove));
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @param gamesToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromGamesBatch", value = "/batch/{gamesToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromGamesBatch(@ModelAttribute Platform platform, @PathVariable("gamesToRemove") Collection<Long> gamesToRemove) {
        getPlatformService().removeFromGames(platform, gamesToRemove);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param platform
     * @param games
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PostMapping(name = "create")
    public ModelAndView create(@ModelAttribute Platform platform, @RequestParam(value = "gamesIds", required = false) List<Long> games, @RequestParam("parentVersion") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Remove empty values
        if (games != null) {
            for (Iterator<Long> iterator = games.iterator(); iterator.hasNext(); ) {
                if (iterator.next() == null) {
                    iterator.remove();
                }
            }
        }
        // Concurrency control
        if (!Objects.equals(version, platform.getVersion()) && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            // Obtain the selected books and include them in the author that will be
            // included in the view
            if (games != null) {
                platform.setGames(new HashSet<GamePlat>(getGamePlatService().findAll(games)));
            } else {
                platform.setGames(new HashSet<GamePlat>());
            }
            // Reset the version to prevent update
            platform.setVersion(version);
            // Include the updated element in the model
            model.addAttribute("platform", platform);
            model.addAttribute("concurrency", true);
            return new ModelAndView("platforms/games/create");
        } else if (!Objects.equals(version, platform.getVersion()) && "discard".equals(concurrencyControl)) {
            populateForm(model);
            // Provide the original element from the Database
            model.addAttribute("platform", platform);
            model.addAttribute("concurrency", false);
            return new ModelAndView("platforms/games/create");
        }
        getPlatformService().setGames(platform, games);
        return new ModelAndView("redirect:" + getCollectionLink().to(PlatformsCollectionThymeleafLinkFactory.LIST).toUriString());
    }
}
