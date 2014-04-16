package henry416;

import javax.ejb.Remote;


@Remote
public interface StudentServiceRemote {
  public String doAction();
}
