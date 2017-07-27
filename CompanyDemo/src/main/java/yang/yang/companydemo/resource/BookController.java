package yang.yang.companydemo.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


/**
 * Created by michael.xing on 6/23/15.
 */
@Component
@Path("/books")
public class BookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    public BookController() {
        LOGGER.info("started book controller");
    }

    @GET
    public String getAllBooks() {
        LOGGER.info("we got it");
        return "done";
    }

//    @RequestMapping(value = "/{id}",
//                    method = RequestMethod.POST)
//    public Book findBook(String id) {
//        LOGGER.info("we got post");
//        Book book = new Book();
//        book.setCreateBy(id);
//        return book;
//    }

}
