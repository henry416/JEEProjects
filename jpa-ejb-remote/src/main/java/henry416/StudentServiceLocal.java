package henry416;

import javax.ejb.Local;
import javax.jws.WebParam;

@Local
public interface StudentServiceLocal {
  public String doAction();
}
