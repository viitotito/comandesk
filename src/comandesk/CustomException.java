package comandesk;

public class CustomException extends Exception{

    //Exceção Personalizada para problemas específicos das classes.
    public CustomException(String message) {
        super(message);
    }
}
