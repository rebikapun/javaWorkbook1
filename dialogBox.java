import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.stage.WindowEvent;

public class dialogBox
{
    public static void main (String args[])
    {
        launchFX();
    }

    private static void launchFX()
    {
        new JFXPanel();                             // iniatialise JavaFX
        Platform.runLater(() ->  initialiseGUI());  // runs initialiseation on the JavaFX thread
    }

    private static void initialiseGUI()
    {
        Stage stage = new Stage();
        stage.setTitle("my first GUI");
        stage.setResizable(false);
        Pane rootPane = new Pane();
        stage.setScene(new Scene (rootPane));
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.setOnCloseRequest((WindowEvent we) -> displayCloseDialog(we));
        stage.show();

        Button btn = new Button();
        btn.setText("Try Me");
        btn.setLayoutX(stage.getWidth() / 2);
        btn.setLayoutY(stage.getHeight() / 2);
        btn.setOnAction((ActionEvent ae) -> printHello());
        rootPane.getChildren().add(btn);

    }

    private static void printHello() 
    {
        System.out.println("You are cool");
    }
    
    private static void displayCloseDialog(WindowEvent we) 
    {
        System.out.println("Close button was clicked");
        
        Alert alert = new Alert (AlertType.CONFIRMATION);
        alert.setTitle("Confrimation");
        alert.setHeaderText("Look, a confrimation dialog");
        alert.setContentText("Are you sure you want to quit?");
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            terminate();
        }
        else
        {
            we.consume();
        }
    }

    private static void terminate()
    {
        System.out.println("bye bye!");
        System.exit(0);
    }
}