package henry416;

import java.util.Date;

public class B01basic implements java.io.Serializable {
    
    private Date currentDate = new Date();

    /**
     * @return the currentDate
     */
    public Date getCurrentDate() {
        return currentDate;
    }

    /**
     * @param currentDate the currentDate to set
     */
    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
    
}
