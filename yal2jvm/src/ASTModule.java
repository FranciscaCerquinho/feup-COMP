/* Generated By:JJTree: Do not edit this line. ASTModule.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.util.ArrayList;

public
class ASTModule extends SimpleNode {
  private String name;
	SymbolsTable symbolsTable;
  public ASTModule(int id) {
    super(id);
  }

  public ASTModule(parserGrammar p, int id) {
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

  public int analyse(SymbolsTable currentTable){
		System.out.println("Analyse of Module");
    int b= 0;
		symbolsTable = new SymbolsTable(currentTable);

    for(int i=0; i < jjtGetNumChildren();i++){
      if(jjtGetChild(i).analyse(symbolsTable)==-1)
        b=-1;
    }

    for(int i=0; i < jjtGetNumChildren();i++){
      if(jjtGetChild(i).analyseContent(symbolsTable)==-1)
        b=-1;
    }
    return b;
  }

  public String convertToByteCodes(MapVariables data){
    String line = "";
    line += ".class public " + name + "\n";
    line += ".super java/lang/Object" + "\n";
    line += "\n";
    MapVariables mapVariables = new MapVariables(data);
    for(int i = 0; i < jjtGetNumChildren(); i++){
      if(jjtGetChild(i).getId() == parserGrammarTreeConstants.JJTFUNCTION) {
        String name = "";
        String returnType = "";
        ArrayList<String> returns = jjtGetChild(i).getFunction();
        name = returns.get(0);
        returnType = returns.get(1);
        mapVariables.putOnHashMapFunctionReturn(name,returnType);
      }
    }

    for(int i = 0; i < jjtGetNumChildren(); i++){
      line += jjtGetChild(i).convertToByteCodes(mapVariables);
    }

    line += "\n";
    line += ".method static public <clinit>()V" + "\n";
    String temp = "";
    int locals = 0;
    for(int i = 0; i < this.jjtGetNumChildren(); i++) {
      if(this.jjtGetChild(i).getId() != parserGrammarTreeConstants.JJTDECLARATION)
        break;
      ASTDeclaration declaration = (ASTDeclaration)this.jjtGetChild(i);
      if(declaration.jjtGetNumChildren()>1){
        locals++;
        if(Integer.parseInt(declaration.jjtGetChild(1).getName()) > 5)
          temp += "bipush " + declaration.jjtGetChild(1).getName() + "\n";
        else
          temp += "iconst_" + declaration.jjtGetChild(1).getName() + "\n";
        temp+= "newarray int\nputstatic " + name + "/"+declaration.jjtGetChild(0).getName() + " [I\n";
      }
    }
    line+= ".limit locals " + locals + "\n";
    line+= ".limit stack 1 \n";
    line+= temp;
    line+= "return\n";
    line+= ".end method\n";
    return line;
  }

}
/* JavaCC - OriginalChecksum=642f3f3704f11600c98c0128057a09ad (do not edit this line) */
