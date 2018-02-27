package sc;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sc.view.CalculatorOverviewController;

/**
 * <b>MainApp is the main class of SimpleCount Appliation.</b>
 * <p>
 * 	SimpleCount respect the norm MVC :
 * <ul>
 * <li>Model</li>
 * <li>View</li>
 * <li>Controller</li>
 * </ul>
 * </p>
 * <p>
 * Application developed during Epitech Java Modul
 * PROMO 2018
 * </p>
 *
 * @author bechad_p
 * @version 1.0
 */
public class MainApp extends Application {

    /**
     *	The JavaFX Stage class is the top level JavaFX container.
     *
     * @see MainApp#start(Stage)
     */
	private Stage primaryStage;
	/**
	 * 	Contain MenuBar and is a container
	 */
    private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("SimpleCount");
        this.primaryStage.getIcons().add(new Image("file:resources/images/Icone.png"));

        initRootLayout();
        showCalculatorOverview();
	}
	 /**
     * Initializes the root layout.
     * Set Stage height and width ect..
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setHeight(550);
            primaryStage.setWidth(450);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showCalculatorOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CalculatorOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);

            // Give the controllerView access to the main app.
            CalculatorOverviewController controllerView = loader.getController();
            controllerView.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructor MainApp.
     */
    public MainApp() {
    }

    /**
     * Returns the main stage.
     * @return primaryStage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * function main call lauch
     * @see MainApp#start(Stage)
     * @param args
     */
	public static void main(String[] args) {
		launch(args);
	}
}
