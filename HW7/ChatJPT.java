import javafx.application.Application;
import javafx.scene.Group;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

    /**
     * ChatJPT application.
     * @author Diya Sharma
     * @version 13.31
     */
public class ChatJPT extends Application {

    private TextArea chatArea;
    private TextArea inputField;
    private PrintWriter writer;
    private String fileName = "conversation_history.txt";

    /**
     * start.
     */
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);

        // Chat area
        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setPrefHeight(500);
        chatArea.setStyle("-fx-font-family: 'Segoe UI', Helvetica, Arial, sans-serif;");
        chatArea.setWrapText(true);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(chatArea);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        scrollPane.setStyle("-fx-background: #f2f2f2;");

        // Input field
        inputField = new TextArea();
        inputField.setWrapText(true);
        inputField.setPrefHeight(40);
        inputField.setPromptText("Type your message here...");
        inputField.setStyle("-fx-font-family: 'Segoe UI', Helvetica, Arial, sans-serif;");
        HBox.setHgrow(inputField, Priority.ALWAYS);
        //named inner class
        inputField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().toString().equals("ENTER")) {
                    sendMessage();
                    event.consume();
                }
            }
        });
        Button submitButton = new Button("Send");
        submitButton.setStyle("-fx-font-family: 'Segoe UI', Helvetica, Arial, sans-serif;");
        //lambda expression
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sendMessage();
            }
        });
        HBox inputBox = new HBox(5, inputField, submitButton);
        inputBox.setAlignment(Pos.CENTER_LEFT);
        inputBox.setPadding(new Insets(10));
        inputBox.setStyle("-fx-background-color: #ffffff;");

        root.setCenter(scrollPane);
        root.setBottom(inputBox);

        // Try JALL-E button
        Button tryButton = new Button("Try JALL-E");
        tryButton.setStyle("-fx-font-family: 'Segoe UI', Helvetica, Arial, sans-serif;");
         //anonymous lambda expression
        tryButton.setOnAction(event -> {
            Stage smileyStage = new Stage();

            Circle face = new Circle(200, 200, 150, Color.YELLOW);
            face.setStroke(Color.BLACK);
            face.setStrokeType(StrokeType.OUTSIDE);
            face.setStrokeWidth(2);

            Ellipse leftEye = new Ellipse(150, 150, 20, 30);
            leftEye.setCenterX(220 - 70);
            leftEye.setCenterY(220 - 70);
            leftEye.setFill(Color.BLACK);

            Ellipse rightEye = new Ellipse(250, 150, 20, 30);
            rightEye.setCenterX(220 + 30);
            rightEye.setCenterY(220 - 70);
            rightEye.setFill(Color.BLACK);

            Arc mouth = new Arc(200, 290, 80, 60, 0, 180);
            mouth.setFill(null);
            mouth.setRotate(180);
            mouth.setStroke(Color.BLACK);
            mouth.setStrokeWidth(15.0);
            mouth.setType(ArcType.OPEN);

            Polygon star1 = createStar(50, 50, 20, 40);
            star1.setStroke(Color.BLACK);
            star1.setFill(Color.BLUE);
            face.setStrokeWidth(2);

            Polygon star2 = createStar(350, 50, 20, 40);
            star2.setStroke(Color.BLACK);
            star2.setFill(Color.GREEN);
            face.setStrokeWidth(2);

            Polygon star3 = createStar(50, 350, 20, 40);
            star3.setStroke(Color.BLACK);
            star3.setFill(Color.RED);
            face.setStrokeWidth(2);

            Polygon star4 = createStar(350, 350, 20, 40);
            star4.setStroke(Color.BLACK);
            star4.setFill(Color.ORANGE);
            face.setStrokeWidth(2);

            Text promptText = new Text("Prompt: Smiley face");
            promptText.setFont(Font.font("Arial", 20));
            promptText.setFill(Color.BLACK);
            promptText.setLayoutX(110); // Adjust X position
            promptText.setLayoutY(30); // Adjust Y position

            Group root2 = new Group(face, leftEye, rightEye, mouth, star1, star2, star3, star4, promptText);
            Scene smileyScene = new Scene(root2, 400, 400);
            smileyStage.setScene(smileyScene);
            smileyStage.setTitle("Smiley Face");
            smileyStage.show();
        });
        BorderPane.setAlignment(tryButton, Pos.TOP_RIGHT);
        root.setTop(tryButton);
        BorderPane.setMargin(tryButton, new Insets(10));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Chat JPT");
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> {
            try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                if (chatArea.getText() != null) {
                    writer.print(chatArea.getText());
                }
            } catch (IOException e) {
                System.err.println("Error writing conversation history to file: " + e.getMessage());
            }
        });
    }

    /**
     * finds and appends message.
     */
    private void sendMessage() {
        String message = inputField.getText().trim();
        if (!message.isEmpty()) {
            chatArea.appendText("User: " + message + "\n");
            try {
                chatArea.appendText("ChatJPT: "
                    + ResponseGenerator.getResponseGenerator().getResponseToPrompt(message) + "\n");
            } catch (Exception e) {
                // Handle error if unable to get response generator
                chatArea.appendText("ChatJPT: Sorry, I'm unable to respond at the moment.\n");
                //System.out.println(ResponseGenerator.keywordResponse);
                e.printStackTrace();
            }
            inputField.clear();
        }
    }

    /**
     * Helper method to make star.
     */
    private Polygon createStar(double x, double y, double innerRadius, double outerRadius) {
        Polygon star = new Polygon();
        for (int i = 0; i < 5; i++) {
            double angle = Math.PI / 2 + i * 2 * Math.PI / 5;
            star.getPoints().addAll(
                    x + outerRadius * Math.cos(angle),
                    y + outerRadius * Math.sin(angle),
                    x + innerRadius * Math.cos(angle + Math.PI / 5),
                    y + innerRadius * Math.sin(angle + Math.PI / 5)
            );
        }
        star.setFill(Color.WHITE);
        star.setStroke(Color.BLACK);
        return star;
    }

    /**
     * Main method.
     * @param args args
     */
    public static void main(String[] args) {
        launch(args);
    }
}