/* Generated By:JJTree: Do not edit this line. ASTFunction.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.util.ArrayList;

public
class ASTFunction extends SimpleNode {
  private String name;

public ASTFunction(int id) {
  super(id);
}

public ASTFunction(parserGrammar p, int id) {
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
public boolean analyse(SymbolsTable currentTable){
  boolean isScalar = jjtGetChild(0).isScalar();
  if(isScalar)
    currentTable.putOnHashMap(new Symbol("Function",name,true));
  else
    currentTable.putOnHashMap(new Symbol("Function",name,false));

  System.out.println("Function: " + " name: " + name + " Tipo: " + isScalar);

  analyseContent(currentTable);
  return true;
}

@Override
public boolean analyseContent(SymbolsTable currentTable){
  System.out.println("Analyse children of Function");

  SymbolsTable symbolsTable = new SymbolsTable(currentTable);

  for(int i=0; i < jjtGetNumChildren();i++){
    jjtGetChild(i).analyse(symbolsTable);
  }

  return true;
}

public void convertToByteCodes(MapVariables data){

  MapVariables mapVariables = new MapVariables();
  String returnType = "V";

  if(name.equals("main")){
    System.out.println(".method public static main([Ljava/lang/String;)V");
  }
  else{
    ArrayList<String> typeOfArgs = new ArrayList<String>();
    for(int i = 0; i < jjtGetNumChildren(); i++){
        if(jjtGetChild(i).getId() == parserGrammarTreeConstants.JJTVARLIST) {
          for(int j = 0; j < jjtGetChild(i).jjtGetNumChildren(); j++){
            if(jjtGetChild(i).jjtGetChild(j).getId() == parserGrammarTreeConstants.JJTARRAYELEMENT)
              typeOfArgs.add("[I");
            else if(jjtGetChild(i).jjtGetChild(j).getId() == parserGrammarTreeConstants.JJTSCALARELEMENT)
              typeOfArgs.add("I");
          }
        }
        else if(jjtGetChild(i).getId() == parserGrammarTreeConstants.JJTARRAYELEMENT) {
          returnType = "[I";
        }
        else if(jjtGetChild(i).getId() == parserGrammarTreeConstants.JJTSCALARELEMENT) {
          returnType = "I";
        }
    }

    String function = ".method public static " + name + "(";
    for(int k = 0; k < typeOfArgs.size(); k++){
      function += typeOfArgs.get(k);
    }
    function += ")" + returnType;
    System.out.println(function);

  }

  System.out.println(".limit locals 10");
  System.out.println(".limit stack 10");

  for(int i = 0; i < jjtGetNumChildren(); i++){
    jjtGetChild(i).convertToByteCodes(mapVariables);
  }

  if(returnType.equals("V"))
    System.out.println("return");
  else
    System.out.println("ireturn");

  System.out.println(".end method");
  System.out.println();

}


}
/* JavaCC - OriginalChecksum=abac2313f4a585dbc8038a0f08c4989e (do not edit this line) */
