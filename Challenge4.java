import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.stage.WindowEvent;

public class Challenge4
{
    private static TextField enterRANKING;
    private static TextField enterNAME;
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
        stage.setTitle("Top Universities by Rebika");
        stage.setResizable(false);
        Pane rootPane = new Pane();
        stage.setScene(new Scene (rootPane));
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.setOnCloseRequest((WindowEvent we) -> terminate());
        stage.show();
        
        Label label1 = new Label("Enter details of University");
        label1.setLayoutX(200);
        label1.setLayoutY(75);
        rootPane.getChildren().add(label1);

        enterRANKING = new TextField();
        enterRANKING.setLayoutX(200);
        enterRANKING.setLayoutY(100);
        enterRANKING.setPromptText("Enter ranking");
        rootPane.getChildren().add(enterRANKING);
        
        enterNAME = new TextField();
        enterNAME.setLayoutX(200);
        enterNAME.setLayoutY(150);
        enterNAME.setPromptText("Enter name of University");
        rootPane.getChildren().add(enterNAME);
       
        Button btn = new Button();
        btn.setText("Enter");
        btn.setLayoutX(stage.getWidth() / 2);
        btn.setLayoutY(stage.getHeight() / 2);
        btn.setOnAction((ActionEvent ae) -> printHello());
        rootPane.getChildren().add(btn);

    }

    private static void printHello() 
    {
        String rank = enterRANKING.getText();
        String name = enterNAME.getText();
        System.out.println(rank);
        System.out.println(name);
    }

    private static void terminate()
    {
        System.out.println("bye bye!");
        System.exit(0);
    }
}