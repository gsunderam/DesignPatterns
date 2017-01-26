package springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: gsunderam
 * Date: Jul 18, 2013
 */
@Service
public class QuoteService {
  private Quote quote;

  public Quote getRestQuote(long id, String username) {
     return new Quote(id, username);
  }

  public String deleteQuote(String id) {
     return "DELETED Quote for " + id;
  }

  public String putQuote(String id) {
     return "UPDATED Quote for " + id;
  }

  public Quote createQuote(String id, String name) {
     return new Quote(Long.valueOf(id), name);
  }

  @Autowired
  public void setQuote(Quote quote) {
    this.quote = quote;
  }
}
