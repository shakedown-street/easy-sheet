package legacy.spreadsheet;

import expr.Expr;
import expr.Parser;
import expr.Variable;

public class Cell {

	private String reference;
	private String formula;
	
	// For expr
	private Variable var;

	public Cell(String _reference) {
		formula = "";
		reference = _reference;
		var = Variable.make(_reference);
	}
	
	public Cell(String _formula, String _reference) {
		this(_reference);
		formula = _formula;
	}

	public String getReference() {
		return reference;
	}

	public String getFormula() {
		return formula;
	}
	
	public void setFormula(String _formula) {
		formula = _formula;
	}
	
	public String getValue() {
		if (formula.startsWith("=")) {
			try {
				Expr expr = Parser.parse(formula.substring(1));
				double val = expr.value();
				var.setValue(val);
				return Double.toString(val);
			} catch (Exception e) {
				return "ERR";
			}
		} else {
			return formula;
		}
	}

	public String toString() {
		return getReference();
	}

}
