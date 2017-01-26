package springrest;

import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Content;
import com.sun.syndication.feed.rss.Item;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: gsunderam
 * Date: Jan 8, 2015
 */
public class QuoteRSSFeedView extends AbstractRssFeedView {

  @Override
	protected void buildFeedMetadata(Map<String, Object> model, Channel feed, HttpServletRequest req) {

		feed.setTitle("Quotes");
		feed.setDescription("Quote Description");
		feed.setLink("http://www.sunderamg.com");

		super.buildFeedMetadata(model, feed, req);
	}
  
  @Override
  protected List<Item> buildFeedItems(Map<String, Object> model, HttpServletRequest req, HttpServletResponse res)
          throws Exception {
    Quote quote = (Quote) model.get("model");
    String msg = quote.getName() + ":" + quote.getId();

    List<Item> items = new ArrayList<Item>(1);
		Item item = new Item();
		item.setAuthor("SunderamG");
		item.setLink("http://www.sunderamg.com");

		Content content = new Content();
		content.setValue(msg);

		item.setContent(content);

		items.add(item);

		return items;
  }
}
