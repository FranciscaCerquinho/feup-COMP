/* Generated By:JJTree: Do not edit this line. ASTExprtest.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTExprtest extends SimpleNode {
  private String name;

  public ASTExprtest(int id) {
    super(id);
  }

  public ASTExprtest(parserGrammar p, int id) {
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
  
    return analyseContent(currentTable);
  }

  @Override
  public int analyseContent(SymbolsTable currentTable){
		System.out.println("Analyse children of Exprtest");

    int returnValue;
    boolean arg;
    System.out.println("Analyse Rhs of Exprtest");
    returnValue = jjtGetChild(1).analyseRhs(currentTable);
    if(returnValue==-1 || returnValue==1)
      arg=true;
    else
      arg=false;
    System.out.println("Analyse Lhs of Exprtest");
    int b = jjtGetChild(0).analyseLhs(currentTable, arg);

    if(b == -1 || returnValue == -1)
      return -1;
    return 0;
  }

  public String convertToByteCodes(MapVariables data){
    String line = "";

    for(int i = 0; i < jjtGetNumChildren(); i++){
      line += jjtGetChild(i).convertToByteCodes(data);
    }


    if(name.equals("<"))//>=
      line+="if_icmpge";
    else if(name.equals(">"))//<=
      line+="if_icmple";
    else if(name.equals("<="))//>
        line+="if_icmpgt";
    else if(name.equals(">="))//<
        line+="if_icmplt";
    else if(name.equals("=="))//!=
        line+="if_icmpne";
    else if(name.equals("!="))//==
        line+="if_icmpeq";
    else return "error on comparison";

    line +=" loop"+ (data.loopCounter - 1) + "_end" + "\n";
    line += "\n";

    return line;
  }

}
/* JavaCC - OriginalChecksum=b1c6f14c27735b49ad08b5d10fa19073 (do not edit this line) */
