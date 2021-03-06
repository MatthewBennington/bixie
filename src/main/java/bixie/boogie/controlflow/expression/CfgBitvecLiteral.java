
package bixie.boogie.controlflow.expression;

import java.util.HashMap;

import bixie.boogie.ast.location.ILocation;
import bixie.boogie.controlflow.CfgVariable;
import bixie.boogie.type.BoogieType;

/**
 * @author schaef
 * 
 */
public class CfgBitvecLiteral extends CfgExpression {

	private int length;
	private String value;
	
	public CfgBitvecLiteral(ILocation loc, BoogieType type, int length,
			String value) {
		super(loc, type);
		this.length = length;
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		//TODO
		return sb.toString();
	}


	@Override
	public CfgExpression substitute(
			HashMap<CfgVariable, CfgExpression> substitutes) {
		return new CfgBitvecLiteral(this.getLocation(), this.getType(), this.length, this.value);
	}
	
	
}
