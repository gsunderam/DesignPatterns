package springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static log.Logger.stdout;

/**
 * User: gsunderam
 * Date: Jul 18, 2013
 */
@Controller
@RequestMapping("/quotes")
public class QuoteController {
  private QuoteService quoteService;

  public QuoteController() {}

  @Autowired
  public QuoteController(QuoteService quoteService) {
     this.quoteService = quoteService;
  }

  @RequestMapping(value="/{id}/{name}", method = RequestMethod.POST)
  public String getQuote(@PathVariable("id") long id, @PathVariable("name") String name, ModelMap model) {
    stdout("Received request: " + id);
    Quote quote = quoteService.getRestQuote(id, name);
    model.addAttribute("model", quote);
    return "quote";
  }

  //This returns JSON response as the jackson library is in the classpath. Content Negotiation is by passed
  @RequestMapping(value="/quoterest/{id}/{username}", method = RequestMethod.POST)
  public @ResponseBody Quote getJsonQuote(@PathVariable("id") String id, @PathVariable("username") String username) {
    stdout("Received request in Json Quote: " + username + " id: " + id);
    Quote quote = quoteService.getRestQuote(Long.valueOf(id), username);
    return quote;
  }

  @RequestMapping(value="/quote", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public ModelAndView createQuote(String id, String name) {
    stdout("Received request in POST: " + id);
    Quote quote = quoteService.createQuote(id, name);
    return new ModelAndView("quoteXML", "quote", quote);
  }


  public void setQuoteService(QuoteService quoteService) {
    this.quoteService = quoteService;
  }
}
