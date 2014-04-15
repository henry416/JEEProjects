package henry416;

import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.logging.Logger;


@Singleton
@Startup
@DataSourceDefinition(name = "java:global/jdbc/lab11DS",
        className = "org.apache.derby.jdbc.EmbeddedDriver",
        url = "jdbc:derby:memory:lab11DB;create=true;user=app;password=app"
)
public class DBPopulator {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private BookEJB bookEJB;

  private Logger logger = Logger.getLogger("henry416");

  // ======================================
  // =          Lifecycle methods         =
  // ======================================

  @PostConstruct
  private void createDummyData() {
    bookEJB.createBook(new Book("The Hitchhiker's Guide to the Galaxy"));
    bookEJB.createBook(new Book("Harry Potter and the Goblet of Fire"));
    logger.info("&&&&&&&&&&&&&& Inserted " + bookEJB.findAllBooks().size() + " Books");
  }
}
