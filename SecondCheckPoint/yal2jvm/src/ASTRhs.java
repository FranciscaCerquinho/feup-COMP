/* Generated By:JJTree: Do not edit this line. ASTRhs.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTRhs extends SimpleNode {

	private String name;

  public ASTRhs(int id) {
    super(id);
  }

  public ASTRhs(parserGrammar p, int id) {
    super(p, id);
  }

  public String getName() {
	  return name;
  }

  public void setName(String name) {
	  this.name = name;
  }

  public String toString() {
	  String test = super.toString();

	  if(name != null)
		  test += " " + name;

	  return test;
  }

  @Override
  public boolean analyse(SymbolsTable currentTable){
    analyseContent(currentTable);

		return true;
  }

  @Override
  public boolean analyseContent(SymbolsTable currentTable){
		System.out.println("Analyse the children of Rhs");

    for(int i=0; i < jjtGetNumChildren();i++){
      jjtGetChild(i).analyse(currentTable);
    }

    return true;
  }

	public boolean analyseRhs(SymbolsTable currentTable){
		System.out.println("Analyse the right part of Rhs");

			return jjtGetChild(0).analyseRhs(currentTable);
	}
}
/* JavaCC - OriginalChecksum=cc96ebd068d1335202539761baa8fdf1 (do not edit this line) */
