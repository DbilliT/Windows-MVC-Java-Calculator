package sc.model;


/**
 * <b> Enum couple with int of Operations
 * <p>
 *	This enum is a list of all operations that user can do on the SimpleCount Application.
 *	Each enum is bind with a int to facilitate the controller parsing.
 * </p>
 *
 * @author bechad_p
 * @version 1.0
 */
public enum ListOperation {
	ADD(1),
	LESS(2),
	MUL(3),
	DIV(4),
	COS(5),
	SIN(6),
	TAN(7),
	LOG(8),
	EXP(9),
	SQUARE(10),
	ROOT(11),
	PRCT(12),
	NONE(13);

	/**
	 * enum int value
	 */
	private int numVal;

	/**
	 * Constructor of the enum ListOperation
	 * @param numVal
	 */
	private ListOperation(int numVal) {
        this.numVal = numVal;
    }
	/**
	 * setter numVal
	 * @see numVal
	 * @param num
	 */
	public void setNumVal(int num) {
		this.numVal = num;
	}

	/**
	 * getter numVal
	 *@see numVal
	 * @return numVal
	 */
    public int getNumVal() {
        return this.numVal;
    }
    /**
     * Transform the numVal value into a string opration.
     * @see numVal
     * @return String Operation (example : "+", "-" ect)
     */
   public String transformOp() {
	   String	sOp;

	   switch (this.numVal) {
	   	case 1:  sOp = "+";
	   		break;
	   	case 2:  sOp = "-";
	   		break;
	   	case 3:  sOp = "*";
	   		break;
	   	case 4:  sOp = "/";
	   		break;
	   	case 5:  sOp = "Cos";
	   		break;
	   	case 6:  sOp = "Sin";
	   		break;
	   	case 7:  sOp = "Tan";
	   		break;
	   	case 8:  sOp = "Log";
	   		break;
	   	case 9:  sOp = "Exp";
	   		break;
	   	case 10: sOp = "²";
	   		break;
	   	case 11: sOp = "V¯";
	   		break;
	   	case 12: sOp = "%";
   			break;
	   	default:
	   		sOp = "";
	   }
	   return sOp;
   }
}
