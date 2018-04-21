/* Generated By:JJTree: Do not edit this line. ASTArgument.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTArgument extends SimpleNode {

	private String name;

  public ASTArgument(int id) {
    super(id);
  }

  public ASTArgument(parserGrammar p, int id) {
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


  public boolean analyse(SymbolsTable currentTable){
    currentTable.putOnHashMap(new Symbol("Argument",name,true));
    System.out.println("Argument: ");
    System.out.println(currentTable);
		
    return true;
  }
}
/* JavaCC - OriginalChecksum=2dc67edd26d714c5ea195f2f3f8af2ed (do not edit this line) */
