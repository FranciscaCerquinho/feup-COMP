/* Generated By:JJTree: Do not edit this line. ASTTerm.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTTerm extends SimpleNode {
  private String name;
	private String nameInteger;

  public ASTTerm(int id) {
    super(id);
  }

  public ASTTerm(parserGrammar p, int id) {
    super(p, id);
  }

  public String getName() {
	  return name;
  }

  public String getNameInteger() {
	  return nameInteger;
  }

  public void setName(String name) {
	  this.name = name;
  }

  public void setNameInteger(String name) {
	  this.nameInteger = name;
  }

  public String toString() {
	  String test = super.toString();

	if(name != null)
	  test+= " " + name;

	if(nameInteger != null)
	  test+= " " + nameInteger;

	  return test;
  }

  @Override
  public boolean analyse(SymbolsTable currentTable){

		analyseContent(currentTable);

    return true;
  }

  @Override
  public boolean analyseContent(SymbolsTable currentTable){
		System.out.println("Analyse the children of Term");

    for(int i=0; i < jjtGetNumChildren();i++){
      jjtGetChild(i).analyse(currentTable);
    }

    return true;
  }

	public boolean analyseRhs(SymbolsTable currentTable){
		System.out.println("Analyse the right part of Term");

		if(nameInteger == null){
			for(int i=0; i < jjtGetNumChildren();i++){
	      return jjtGetChild(i).analyseRhs(currentTable);
	    }
		}
		else{
			return true;
		}
		return true;

	}

  public void convertToByteCodes(MapVariables mapVariables){
    
    if(name == null && nameInteger == null) {
      for(int i = 0; i < jjtGetNumChildren(); i++){
        jjtGetChild(i).convertToByteCodes(mapVariables);
      }
    }
    else if (nameInteger != null) {
      System.out.println("iconst_" + nameInteger);
    }
    else if (name != null) {
      System.out.println("iconst_" + name);
    }
  }

}
/* JavaCC - OriginalChecksum=6e0a45afda7272769448323ecc8eb0e4 (do not edit this line) */
