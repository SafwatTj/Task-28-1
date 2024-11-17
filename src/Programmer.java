import Excepions.ProgrammerBusyException;
import Excepions.ProgrammerUnavailableNowException;

public class Programmer {

    private String name;
    private String status;

    private final static String AVAILABLE_STATUS = "доступен";
    private final static String UNAVAILABLE_STATUS = "не доступен";
    private final static String  BUSY_STATUS = "занят";

    public Programmer(String name) {
        this.name = name;
        this.status = AVAILABLE_STATUS;
    }

    public void setAvailable() {
        this.status = AVAILABLE_STATUS;
    }
    public void setUnavailable() {
        this.status = UNAVAILABLE_STATUS;
    }
    public void setBusy() {
        this.status = BUSY_STATUS;
    }

    @Override
    public String toString() {
        return name + "("+ status + ")";
    }

    public String doWork(String msg){
        if (status.equals(UNAVAILABLE_STATUS)){
            throw new ProgrammerUnavailableNowException();
        }
        if (status.equals(BUSY_STATUS)){
            throw new ProgrammerBusyException();
        }
        if (msg==null){
            return "";
        }
        return msg.toUpperCase();
    }

}
