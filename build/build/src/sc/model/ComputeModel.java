
package sc.model;

import java.math.BigDecimal;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * <b>ComputeModel inerith of OperationModel class and implement it.</b>
 * <p>
 * The ComputeModel class performs calculations and register results.
 * </p>
 *
 * @author bechad_p
 * @version 1.0
 */
public class ComputeModel extends OperationModel {

	/**
	 * bdNomberOne is the first operand of the operation.
	 * It is a BigDecimal : A BigDecimal consists of an arbitrary precision integer unscaled value and a 32-bit integer scale.
	 * If zero or positive, the scale is the number of digits to the right of the decimal point.
	 * If negative, the unscaled value of the number is multiplied by ten to the power of the negation of the scale.
	 * The value of the number represented by the BigDecimal is therefore (unscaledValue × 10-scale).
	 * @see bdNomberTwo
	 * @see bdResult
	 */
	private BigDecimal	bdNomberOne;
	/**
	 * bdNomberTwo is the second operand of the operation.
	 * It is a BigDecimal
	 * @see bdNomberOne
	 * @see bdResult
	 */
	private BigDecimal	bdNomberTwo;
	/**
	 * bdNomberResult is the result of the operation.
	 * It is stock as BigDecimal
	 * @see bdNomberOne
	 * @see bdNomberTwo
	 */
	private BigDecimal	bdResult;
	/**
	 * sReuslt is the result of the operation.
	 * It is stock as String
	 */
	private String		sResult;
	/**
	 * fNomberOne is the first operand of the operation if the operation is a division.
	 * It is a float.
	 * @seefNomberTwo
	 */
	private Float		fNomberOne;
	/**
	 * fNomberTwo is the second operand of the operation if the operation is a division
	 * It is a float.
	 * @seefNomberOne
	 */
	private Float		fNomberTwo;
	/**
	 * isError is a boolean set to true if an error occur.
	 */
	private Boolean		isError;

	/**
	 * 	Additon operation.
	 */
    public void add() {
    	bdResult = bdNomberOne.add(bdNomberTwo).setScale(8, BigDecimal.ROUND_HALF_UP);;
    	sResult = bdResult.toString();
    }

    /**
	 * 	Soustraction operation.
	 */
    public void soustraction() {
    	bdResult = bdNomberOne.subtract(bdNomberTwo).setScale(8, BigDecimal.ROUND_HALF_UP);
    	sResult = bdResult.toString();
    }

    /**
	 * 	Division operation.
	 */
    public void division(float nbr1, float nbr2) throws ArithmeticException {
    		bdResult = new BigDecimal(nbr1 / nbr2).setScale(8, BigDecimal.ROUND_HALF_UP);
    		sResult = bdResult.toString();
    }

    /**
	 * 	Multiplication operation.
	 */
    public void multiplication() {
    	bdResult = bdNomberOne.multiply(bdNomberTwo).setScale(8, BigDecimal.ROUND_HALF_UP);
    	sResult = bdResult.toString();
    }

    /**
	 * 	Sinus operation.
	 */
    public void sin() {
        bdResult = new BigDecimal(Math.sin(bdNomberOne.doubleValue())).setScale(8, BigDecimal.ROUND_HALF_UP);
        sResult = bdResult.toString();
    }

    /**
	 * 	Cosinus operation.
	 */
    public void cos() {
        bdResult = new BigDecimal(Math.cos(bdNomberOne.doubleValue())).setScale(8, BigDecimal.ROUND_HALF_UP);
        sResult = bdResult.toString();
    }

    /**
	 * 	Tangeant operation.
	 */
    public void tan() {
        bdResult = new BigDecimal(Math.tan(bdNomberOne.doubleValue())).setScale(8, BigDecimal.ROUND_HALF_UP);
        sResult = bdResult.toString();
    }

    /**
	 * 	Logarithm operation.
	 */
    public void logarithm() {
        bdResult = new BigDecimal(Math.log(bdNomberOne.doubleValue())).setScale(8, BigDecimal.ROUND_HALF_UP);
        sResult = bdResult.toString();
    }

    /**
	 * 	Square operation.
	 */
    public void square() {
        bdResult = new BigDecimal(Math.pow(bdNomberOne.doubleValue(), bdNomberTwo.doubleValue())).setScale(8, BigDecimal.ROUND_HALF_UP);
        sResult = bdResult.toString();
    }

    /**
	 * 	Exponentiel operation.
	 */
    public void exponentiel() {
        bdResult = new BigDecimal(Math.exp(bdNomberOne.doubleValue())).setScale(8, BigDecimal.ROUND_HALF_UP);
        sResult = bdResult.toString();
    }

    /**
	 * 	Square root operation.
	 */
    public void squareRoot() {
        bdResult = new BigDecimal(Math.sqrt(bdNomberOne.doubleValue())).setScale(8, BigDecimal.ROUND_HALF_UP);
        sResult = bdResult.toString();
    }

    /**
	 * 	Square root operation.
	 */
    public void pourcentage(float nbr1) {
    	bdResult = new BigDecimal(nbr1 / 100).setScale(8, BigDecimal.ROUND_HALF_UP);
		sResult = bdResult.toString();
    }

    /**
     * Getter bdResult.
     * @return Result (BigDecimal)
     */
    public BigDecimal	getResult() {
    	return bdResult;
    }

    /**
     *	Getter isError boolean.
     * @return true if error
     */
    public Boolean	getIsError() {
    	return isError;
    }

    /**
     * Getter sResult.
     * @return result as String
     */
	public String getStringResult() {
		return sResult;
	}

	/**
	 * Setter sResult
	 * @param sResult
	 */
	public void setStringResult(String sResult) {
		this.sResult = sResult;
	}

	/**
	 * check witch operation with one argument the ComputerModel
	 * has to do and redirects it on the good one.
	 */
    public void	calculOneArgument() {
    	isError = false;
    	bdNomberOne = new BigDecimal(this.getNbrTmp());
    	fNomberTwo = Float.parseFloat(this.getNbrTmp());
    	bdResult = new BigDecimal(0);

    	if (this.getOp() == ListOperation.COS)
    		cos();
    	else if (this.getOp() == ListOperation.SIN)
    		sin();
    	else if (this.getOp() == ListOperation.TAN)
    		tan();
    	else if (this.getOp() == ListOperation.LOG)
    		logarithm();
    	else if (this.getOp() == ListOperation.EXP)
    		exponentiel();
    	else if (this.getOp() == ListOperation.ROOT)
    		squareRoot();
    	else if (this.getOp() == ListOperation.PRCT)
    		pourcentage(fNomberTwo);

    }

    /**
     * check witch operation with two arguments the ComputerModel
     * has to do and redirects it on the good one.
     */
    public void	calculTwoArguments() {
    	isError = false;
    	fNomberOne = Float.parseFloat(this.getNbrBefore());
    	fNomberTwo = Float.parseFloat(this.getNbrTmp());
    	bdNomberOne = new BigDecimal(this.getNbrBefore());
    	bdNomberTwo = new BigDecimal(this.getNbrTmp());
    	bdResult = new BigDecimal(0);

    	if (this.getOp() == ListOperation.ADD)
    		add();
    	else if (this.getOp() == ListOperation.LESS)
    		soustraction();
    	else if (this.getOp() == ListOperation.MUL)
    		multiplication();
    	else if (this.getOp() == ListOperation.DIV)
    		division(fNomberOne, fNomberTwo);
    	else if (this.getOp() == ListOperation.SIN)
    		sin();
    	else if (this.getOp() == ListOperation.TAN)
    		tan();
    	else if (this.getOp() == ListOperation.LOG)
    		logarithm();
    	else if (this.getOp() == ListOperation.EXP)
    		exponentiel();
    	else if (this.getOp() == ListOperation.SQUARE)
    		square();
    	else if (this.getOp() == ListOperation.ROOT)
    		squareRoot();
    	else if (this.getOp() == ListOperation.PRCT)
    		pourcentage(fNomberTwo);
    }

    /**
     * ComputeModel default constructor
     */
    public ComputeModel() {
    	this.nbrTmp = new SimpleStringProperty("0");
        this.nbrBefore = new SimpleStringProperty("");
        this.op = new SimpleObjectProperty<ListOperation>(ListOperation.NONE);
        this.isComma = new SimpleBooleanProperty(false);
    }
}
