package yang.yang.springbootdemo.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;





/**
 * Created by michael.xing on 6/23/15.
 */
@RestController
@RequestMapping("/books")
public class BookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    public BookController() {
        LOGGER.info("started book controller");
    }

    @RequestMapping(value = "",
                    method = RequestMethod.GET)
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
