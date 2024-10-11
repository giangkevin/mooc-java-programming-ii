package title;

import javafx.application.Application;
import javafx.stage.Stage;


public class UserTitle extends Application{
        
    public void start(Stage window){
        Parameters params = getParameters();
        String name = params.getNamed().get("name");


        window.setTitle(name);
        window.show();
    }

}
