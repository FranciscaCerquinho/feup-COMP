/* Generated By:JJTree: Do not edit this line. ASTArraySize.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTArraySize extends SimpleNode {
  private String name;


  public ASTArraySize(int id) {
    super(id);
  }

  public ASTArraySize(parserGrammar p, int id) {
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
		  test+= " " + name;

	  return test;
  }

  @Override
  public int analyse(SymbolsTable currentTable){
    int b = 0;
    if(name==null){
			System.out.println("Name of ArraySize is null");
			b = analyseContent(currentTable);
		}

		System.out.println("Name of ArraySize isn't null");

    return b;
  }

  @Override
  public int analyseContent(SymbolsTable currentTable){
		System.out.println("Analyse children of ArraySize");
    int b = 0;

    for(int i=0; i < jjtGetNumChildren();i++){
      if(jjtGetChild(i).analyse(currentTable)==-1)
        b=-1; 
    }

    return b;
  }

	public int analyseRhs(SymbolsTable currentTable){
		System.out.println("Analyse the right part of ArraySize");
		return 0;
	}

  public String convertToByteCodes(MapVariables mapVariables, int loop_no){
    String line = "";
    for(int i = 0; i < jjtGetNumChildren(); i++){
      line += jjtGetChild(i).convertToByteCodes(mapVariables, loop_no);
    }
    return line;
  }

}
/* JavaCC - OriginalChecksum=31696448752bbfae99e245ee9cac6a9f (do not edit this line) */
