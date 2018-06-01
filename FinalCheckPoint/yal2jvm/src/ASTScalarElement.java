/* Generated By:JJTree: Do not edit this line. ASTScalarElement.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTScalarElement extends SimpleNode {
  private String name;

  public ASTScalarElement(int id) {
    super(id);
  }

  public ASTScalarElement(parserGrammar p, int id) {
    super(p, id);
  }

  public String getName() {
	  return name;
  }

  public void setName(String name) {
	  this.name = name;
  }

  public String toString() {
	  String test;

	  test = super.toString() + " " + name;

	  return test;
  }

  @Override
  public int analyse(SymbolsTable currentTable){
    currentTable.putOnHashMap(new Symbol("ScalarElement",name,true));
    System.out.println("ScalarElement pos na hashmap ");
    return 0;
  }

  public String convertToByteCodes(MapVariables data){
    String line = "";

    if(jjtGetParent().getId() == parserGrammarTreeConstants.JJTVARLIST) {
      data.putOnHashMap(name);
    }
    return line;
  }
}
/* JavaCC - OriginalChecksum=431b0b6f1ff139e666bd5d9e25b1a1ea (do not edit this line) */
