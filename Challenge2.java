import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;

public class Challenge2
{
    private static TextField textFieldMessage;
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
        stage.show();
        
        textFieldMessage = new TextField();
        textFieldMessage.setLayoutX(200);
        textFieldMessage.setLayoutY(100);
        textFieldMessage.setPromptText("Enter your message");
        rootPane.getChildren().add(textFieldMessage);
        

        Button btn = new Button();
        btn.setText("Try Me");
        btn.setLayoutX(stage.getWidth() / 2);
        btn.setLayoutY(stage.getHeight() / 2);
        btn.setOnAction((ActionEvent ae) -> printHello());
        rootPane.getChildren().add(btn);

    }

    private static void printHello() 
    {
        String message = textFieldMessage.getText();
        System.out.println(message);
    }
}