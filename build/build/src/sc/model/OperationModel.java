package sc.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

/**
 * <b>OperationModel is an abstract class which define the model of SimpleCount application</b>
 * <p>
 * The model stores data that is retrieved according to commands from the controller and displayed in the view.
 * </p>
 *
 * @author bechad_p
 * @version 1.0
 */
public abstract class OperationModel  {

	/**
	 * The operator of the operation.
	 * It is observated by the view.
	 */
	protected ObjectProperty<ListOperation> 		op;

	/**
	 * First operand of the operation.
	 * It is observated by the view.
	 */
	protected StringProperty						nbrBefore;

	/**
	 * Second operand of the operation.
	 * It is observated by the view.
	 */
	protected StringProperty						nbrTmp;

	/**
	 * State of the Comma.
	 * Set to false if no Comma exist on the operation.
	 * It is observated by the view.
	 */
    protected BooleanProperty						isComma;

    /**
     * Getter nbrBefore.
     * @return nbrBefore String
     */
	public String getNbrBefore() {
		return nbrBefore.get();
	}

	/**
	 * Setter nbrBefore.
	 * @param nbrBefore
	 */
	public void setNbrBefore(String nbrBefore) {
		this.nbrBefore.set(nbrBefore);
	}

	/**
	 * Getter nbrBeforeProperty.
	 * @return nbrBeforeProperty StringProperty
	 */
	public final StringProperty nbrBeforeProperty() {
		  return nbrBefore;
	}

	/**
	 * Getter nbrTmp.
	 * @return nbrTmp String
	 */
	public String getNbrTmp() {
		return nbrTmp.get();
	}

	/**
	 * Setter nbrTmp.
	 * @param nbrTmp
	 */
	public void setNbrTmp(String nbrTmp) {
		this.nbrTmp.set(nbrTmp);
	}

	/**
	 * Getter nbrTmpProperty.
	 * @return nbrTmpProperty StringProperty
	 */
	public final StringProperty nbrTmpProperty() {
		  return nbrTmp;
	}

	/**
	 *	Getter isComma.
	 * @return true if comma exist on nbrTmp
	 */
	public Boolean getIsComma() {
		return isComma.getValue();
	}

	/**
	 * Setter isComma.
	 * @param isComma
	 */
	public void setIsComma(Boolean isComma) {
		this.isComma.set(isComma);
	}

	/**
	 * Getter isCommaProperty.
	 * @return isCommaProperty BooleanProperty
	 */
	public final BooleanProperty isCommaProperty() {
		  return isComma;
	}

	/**
	 * Getter op.
	 * @return op ListOperation.
	 */
	public ListOperation getOp() {
		return op.get();
	}

	/**
	 * Setter op.
	 * @param op
	 */
	public void setOp(ListOperation op) {
		this.op.set(op);
	}

	/**
	 * Getter opProperty.
	 * @return opProperty
	 *  ObjectProperty<ListOperation>
	 */
	public final ObjectProperty<ListOperation> opProperty() {
		  return op;
	}
}
