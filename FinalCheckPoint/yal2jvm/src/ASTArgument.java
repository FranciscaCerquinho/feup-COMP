/* Generated By:JJTree: Do not edit this line. ASTArgument.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTArgument extends SimpleNode {
  private String name;
  private String string;
  private String integer;

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

  public String getString() {
    return string;
  }

  public void setString(String string) {
    this.string = string;
  }

  public String getInteger() {
    return integer;
  }

  public void setInteger(String integer) {
    this.integer = integer;
  }

  public String toString() {
	  String test = "";

    if(name != null)
      test = super.toString() + " " + name;
    else if(string != null)
      test = super.toString() + " " + string;
    else if(integer != null)
      test = super.toString() + " " + integer;

	  return test;
  }


  public int analyse(SymbolsTable currentTable){
    if(name != null && currentTable.returnSymbol(name) == null){
      System.out.println("Error, variable " + name + " does not exists!");
      return -1;
    }
    return 0;
  }

  public String convertToByteCodes(MapVariables mapVariables){
    String line = "";

    if(name != null ) {
      line += "iload_" + mapVariables.returnByteCode(name) + "\n";
    }
    else if(string != null) {
      line += "ldc " + string + "\n";
    }
    else if(integer != null) {
      if(Integer.parseInt(integer)<=5)
        line += "iconst_" + integer + "\n";
      else
        line += "bipush " + integer + "\n";
    }
      return line;
  }

  public String checkArgumentsType(){

    if(name != null ) {
      return "I";
    }
    else if(string != null)
      return "Ljava/lang/String";
    else if(integer != null)
      return "I";
    else
      return "";
  }

}
/* JavaCC - OriginalChecksum=e02e34cc3789ce245053ad03df1f4094 (do not edit this line) */
