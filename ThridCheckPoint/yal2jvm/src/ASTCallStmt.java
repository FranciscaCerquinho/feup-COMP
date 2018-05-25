/* Generated By:JJTree: Do not edit this line. ASTCallStmt.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.util.ArrayList;

public
class ASTCallStmt extends SimpleNode {
  private String name;
  	private String nameId2;

    public ASTCallStmt(int id) {
      super(id);
    }

    public ASTCallStmt(parserGrammar p, int id) {
      super(p, id);
    }

    public String getName() {
  	  return name;
    }

    public String getNameId2() {
  	  return nameId2;
    }

    public void setName(String name) {
  	  this.name = name;
    }

    public void setNameId2(String name) {
  	  this.nameId2 = name;
    }

    public String toString() {
  	  String test = super.toString();

  	if(name != null)
  	  test+= " " + name;

  	if(nameId2 != null)
  	  test+= " " + nameId2;

  	  return test;
    }

    @Override
    public int analyse(SymbolsTable currentTable){
  		if(name != null && nameId2 != null)
  			return 0;

      if(currentTable.returnSymbol(name) != null){
        int b = analyseContent(currentTable);

  			System.out.println("This function exists: CallStmt");
        return b;
      }

      System.out.println("This function doesn't exist! " + name);
      return -1;
    }

    @Override
    public int analyseContent(SymbolsTable currentTable){
  		System.out.println("Analyse children of CallStmt");
      int b=0;

      for(int i=0; i < jjtGetNumChildren();i++){
        if(jjtGetChild(i).analyseContent(currentTable)==-1)
          b=-1;
      }

      return b;
    }

    public String convertToByteCodes(MapVariables mapVariables, int loop_no){
      String line = "";
      String call = "";
      for(int i = 0; i < jjtGetNumChildren(); i++){
          line += jjtGetChild(i).convertToByteCodes(mapVariables, loop_no);
      }

      if(nameId2 == null){
        SimpleNode node = (SimpleNode)this;
        while(node.jjtGetParent() != null) {
          node = (SimpleNode)node.jjtGetParent();
        }
        call += "invokestatic "+ node.getName() + "/" + name + "(";
        for(int i = 0; i < jjtGetNumChildren(); i++){
          call += jjtGetChild(i).checkArgumentsType();
        }
        call += ")";

      }
      else {
        call += "invokestatic "+ name + "/" + nameId2 + "(";
        for(int i = 0; i < jjtGetNumChildren(); i++){
          call += jjtGetChild(i).checkArgumentsType();
        }
        call += ")";

      }

      line += call;
      line += "\n\n";

      return line;
    }

}
/* JavaCC - OriginalChecksum=b1093cf9be00752b849437115fba253a (do not edit this line) */
