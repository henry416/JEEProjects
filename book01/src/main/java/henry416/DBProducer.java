package henry416;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DBProducer {

  @Produces
  @PersistenceContext(unitName = "testPU")
  private EntityManager em;
}
