package sc.view;

import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sc.model.ListOperation;
import sc.MainApp;
import sc.controller.Controller;

/**
 * <b>CalculatorOverviewController is a part of the view of SimpleCount application.</b>
 * <p>
 * His task is to receive any user action (click, select a button, keyboard input, etc.).
 * These events are sent to the controller.
 * </p>
 *
 * @author bechad_p
 * @version 1.0
 */
public class CalculatorOverviewController {

	/**
	 * Access to the main app.
	 */
	private MainApp			mainApp;

	/**
	 * Access to the controller
	 */
	private	Controller		controllerCalc;

	/**
	 * displayText is the screen which result is display.
	 * It's a TextArea.
	 */
    @FXML
    private TextArea displayText;
	/**
	 * displayOp is the screen which operator is display.
	 * It's a TextArea.
	 */
    @FXML
    private TextArea displayOp;

    /**
     * Number event.
     */
    @FXML
    private void eventNumber(Event evt) {
    	controllerCalc.handleNumbers(((Node) evt.getSource()).getId());
    }

    /**
     * TwoArguments event.
     * @param evt
     */
    @FXML
    private void eventOperationTwoArguments(Event evt) {
    	controllerCalc.handleOperationTwoArguments(((Node) evt.getSource()).getId());
    }

    /**
     * OneArgument event.
     * @param evt
     */
    @FXML
    private void eventOperationOneArgument(Event evt) {
    	controllerCalc.handleOperationOneArgument(((Node) evt.getSource()).getId());
    }

    /**
     * Equal event.
     */
    @FXML
    private void eventOperationEqual() {
    	controllerCalc.handleOperationEqual();
    }

	/**
     * Reset event.
     */
    @FXML
    private void eventReset() {
    	controllerCalc.handleReset();
    }
    /**
     * Comma event.
     */
    @FXML
    private void eventComma() {
    	controllerCalc.handleComma();
    }

    /**
     *  Delete event.
     */
    @FXML
    private void eventDelete() {
    	controllerCalc.handleDelete();
    }

    /**
     * Keybord Pressed event.
     * @param event
     */
    @FXML
    public void eventKeyboardPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.DIGIT0 || event.getCode() == KeyCode.NUMPAD0) {
            controllerCalc.handleNumbers("0");
        }
        else if (event.getCode() == KeyCode.DIGIT1 || event.getCode() == KeyCode.NUMPAD1) {
            controllerCalc.handleNumbers("1");
        }
        else if (event.getCode() == KeyCode.DIGIT2 || event.getCode() == KeyCode.NUMPAD2) {
            controllerCalc.handleNumbers("2");
        }
        else if (event.getCode() == KeyCode.DIGIT3 || event.getCode() == KeyCode.NUMPAD3) {
            controllerCalc.handleNumbers("3");
        }
        else if (event.getCode() == KeyCode.DIGIT4 || event.getCode() == KeyCode.NUMPAD4) {
            controllerCalc.handleNumbers("4");
        }
        else if (event.getCode() == KeyCode.DIGIT5 || event.getCode() == KeyCode.NUMPAD5) {
            controllerCalc.handleNumbers("5");
        }
        else if (event.getCode() == KeyCode.DIGIT6 || event.getCode() == KeyCode.NUMPAD6) {
            controllerCalc.handleNumbers("6");
        }
        else if (event.getCode() == KeyCode.DIGIT7 || event.getCode() == KeyCode.NUMPAD7) {
            controllerCalc.handleNumbers("7");
        }
        else if (event.getCode() == KeyCode.DIGIT8 || event.getCode() == KeyCode.NUMPAD8) {
            controllerCalc.handleNumbers("8");
        }
        else if (event.getCode() == KeyCode.DIGIT9 || event.getCode() == KeyCode.NUMPAD9) {
            controllerCalc.handleNumbers("9");
        }
        else if (event.getCode() == KeyCode.ADD) {
        	controllerCalc.handleOperationTwoArguments("ADD");
        }
    	else if (event.getCode() == KeyCode.SUBTRACT) {
    		controllerCalc.handleOperationTwoArguments("LESS");
    	}
    	else if (event.getCode() == KeyCode.MULTIPLY) {
    		controllerCalc.handleOperationTwoArguments("MUL");
    	}
    	else if (event.getCode() == KeyCode.DIVIDE) {
    		controllerCalc.handleOperationTwoArguments("DIV");
    	}
    	else if (event.getCode() == KeyCode.DELETE) {
    		controllerCalc.handleDelete();
    	}
    	else if (event.getCode() == KeyCode.BACK_SPACE) {
    		controllerCalc.handleDelete();
    	}
    	else if (event.getCode() == KeyCode.COMMA) {
    		controllerCalc.handleComma();
    	}
    	else if (event.getCode() == KeyCode.DECIMAL) {
    		controllerCalc.handleComma();
    	}
    }

    /**
     * Event Menu-File-Quit
     */
	@FXML
	private void	eventMenuFileQuit() {
		controllerCalc.handleMenuFileQuit();
	}

	/**
	 * Event Menu-Help-About
	 */
	@FXML
	private void	eventMenuHelpAbout() {
		controllerCalc.handleMenuHelpAbout();

	}

	/**
	 * Event Menu-Edit-Copy
	 */
	@FXML
	private void	eventMenuEditCopy() {
		controllerCalc.handleMenuEditCopy();
	}

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public CalculatorOverviewController() {
    }


    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	controllerCalc = new Controller();

    	controllerCalc.getOpMod().nbrTmpProperty().addListener(((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
			displayText.setText(newValue);
		}));
    	controllerCalc.getOpMod().opProperty().addListener(((ObservableValue<? extends ListOperation> observable, ListOperation oldValue, ListOperation newValue) -> {
    		displayOp.setText(newValue.transformOp());
	}));
    }

    /**
     * Is called by the mainApp to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}