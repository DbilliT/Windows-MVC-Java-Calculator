package sc.controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.application.Platform;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import sc.model.ComputeModel;
import sc.model.ListOperation;

/**
 * <b>Controller is the controller of simpleCount Application.</b>
 * <p>
 * 	Controller handle :
 * <ul>
 * <li>Keyboard Input</li>
 * <li>ButtonAction Input</li>
 * <li>MenuBar Input</li>
 * </ul>
 * </p>
 * <p>
 * The class Controller send commands to the model to update the model's state.
 * </p>
 *
 * @author bechad_p
 * @version 1.0
 */
public class Controller {

		/**
		 *	ComputeModel opMod is a Model
		 *	@see Controller#getOpMod()
		 */
		private ComputeModel	opMod;

		/**
		 *	Getter for opMod
		 * @return the model opMod
		 */
		public ComputeModel getOpMod() {
			return (opMod);
		}

		/**
		 * handle the number enter by the user
		 * and redirects it on opMod (model)
		 * @param num
		 */
	    public void handleNumbers(String num)
	    {
	    	if (num.equalsIgnoreCase("0")) {
	    		if ((!opMod.getNbrTmp().equals("0")) && (opMod.getNbrTmp().length() < 10))
		    		opMod.setNbrTmp(opMod.getNbrTmp() + "0");
	    	}
	    	else {
	    		if (opMod.getNbrTmp().equals("0"))
	    			opMod.setNbrTmp(num);
	    		else if (opMod.getNbrTmp().length() < 10)
	    			opMod.setNbrTmp(opMod.getNbrTmp() + num);
	    	}
	    }
	    /**
	     * handle the operations with one argument enter
	     * by the user and redirects it on opMod (model)
	     * @param sOperation
	     */
	    public void handleOperationTwoArguments(String sOperation) {
	    	//System.out.println("LOL");
			for(ListOperation loTmp : ListOperation.values())
			{
				if (sOperation.equalsIgnoreCase(loTmp.name())) {
					opMod.setOp(loTmp);
					opMod.setNbrBefore(opMod.getNbrTmp());
					opMod.setNbrTmp("0");
					opMod.setIsComma(false);
					break;
				}
	   		}
	    }

	    /**
	     * handle the operations with two arguments enter
	     * by the user and redirects it on opMod (model)
	     * @param sOperation
	     */
	    public void handleOperationOneArgument(String sOperation) {
			for(ListOperation loTmp : ListOperation.values())
	    	{
	    		if (sOperation.equalsIgnoreCase(loTmp.name())) {
	    			opMod.setOp(loTmp);
	    	    	handleOperationEqual();
	    	    	break;
	    		}
	    	}
	    }

	    /**
	     * handle when the user enter "equal".
	     * It redirects this one on opMod to do the operation.
	     */
	    public void handleOperationEqual() {
	    	System.out.println(opMod.getNbrBefore());
	    	System.out.println(opMod.getOp().name());
	    	try {
	    	if (opMod.getOp() != ListOperation.NONE)
	    	{
	    		if (opMod.getNbrBefore() == "")
	    			opMod.calculOneArgument();
	    		else
	    			opMod.calculTwoArguments();
	    		if (opMod.getIsError() == true)
	    		{
	    			opMod.setNbrTmp("0");
	    			opMod.setNbrBefore(opMod.getNbrTmp());
	        		opMod.setIsComma(false);
	        		opMod.setOp(ListOperation.NONE);
	    		}
	    		else
	    		{
	    			opMod.setNbrTmp(opMod.getStringResult());
	    			opMod.setNbrBefore(opMod.getNbrTmp());
	        		opMod.setIsComma(false);
	        		opMod.setOp(ListOperation.NONE);
	    		}
	    	}
	    	}
	    	catch (Exception e) {
	    		this.handleReset();
	    	}

	    }

		/**
	     * Reset handle.
	     * set opMod (model) variable to default values.
	     */
	    public void handleReset() {
	    	opMod.setNbrTmp("0");
			opMod.setNbrBefore("");
    		opMod.setIsComma(false);
    		opMod.setOp(ListOperation.NONE);
	    }

	    /**
	     * Comma handle.
	     * Check if comma can be add and redirects it on opMod (model).
	     */
	    public void handleComma() {
	    	if ((opMod.getIsComma() == false) && (opMod.getNbrTmp().indexOf('.') < 0)) {
	    		opMod.setNbrTmp(opMod.getNbrTmp() + ".");
	    		opMod.setIsComma(true);
	    	}
	    }

	    /**
	     *  Delete handle.
	     *  Redirects the command to opMod to remove one number of nbrTmp.
	     */
	    public void handleDelete() {
	    	if (opMod.getNbrTmp().length() != 0)
	    	{
	    		if (opMod.getNbrTmp().charAt(opMod.getNbrTmp().length()-1) == '.')
	    			opMod.setIsComma(false);
	    		opMod.setNbrTmp(opMod.getNbrTmp().substring(0, opMod.getNbrTmp().length()-1));
	    	}
	    	if (opMod.getNbrTmp().length() == 0)
	    		opMod.setNbrTmp("0");
	    }

	    /**
	     * Exit the Application when the user click on File/Exit
	     */
	    public void	handleMenuFileQuit() {
			Platform.exit();
			System.exit(0);
		}

	    /**
	     * Redirects the user on Simple doc
	     * Javadoc documentation : Open the browser.
	     */
		public void	handleMenuHelpAbout() {
			try {
				Desktop.getDesktop().browse(new URI("file:///C:/Users/DbilliT/workspace/simpleCount/doc/index.html"));
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}

		/**
		 * Copy the current result (nbrTmp) on User computer.
		 */
		public void	handleMenuEditCopy() {
			final Clipboard clipboard = Clipboard.getSystemClipboard();
			final ClipboardContent content = new ClipboardContent();

			content.putString("Ce projet vaut au moins 30");
			clipboard.setContent(content);
		}

		/**
		 * Controller default constructor.
		 * Creating the instance opMod (model)
		 */
	    public Controller() {
	    	opMod = new ComputeModel();
	    }
}
