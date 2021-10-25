package tech.rebb.dt;

public class RebbDTException extends Exception{
    String message;
    public RebbDTException(String message){
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }
}
