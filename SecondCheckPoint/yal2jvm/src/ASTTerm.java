/* Generated By:JJTree: Do not edit this line. ASTTerm.java Version 4.3 */
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
}
/* JavaCC - OriginalChecksum=4fed4c4acdb17d83930148652e686f7c (do not edit this line) */
