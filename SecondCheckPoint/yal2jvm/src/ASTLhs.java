/* Generated By:JJTree: Do not edit this line. ASTLhs.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTLhs extends SimpleNode {
  public ASTLhs(int id) {
        super(id);
      }

  public ASTLhs(parserGrammar p, int id) {
    super(p, id);
  }

  @Override
  public boolean analyseContent(SymbolsTable currentTable){
    System.out.println("Analyse children of Lhs");

    SymbolsTable symbolsTable = new SymbolsTable(currentTable);

    for(int i=0; i < jjtGetNumChildren();i++){
      jjtGetChild(i).analyse(symbolsTable);
    }

    return true;
  }

  public boolean analyseLhs(SymbolsTable currentTable, boolean value){
    System.out.println("Analyse the left part of Call");

    for(int i=0; i < jjtGetNumChildren();i++){
      jjtGetChild(i).analyseLhs(currentTable, value);
    }
    return true;
  }

  public void convertToByteCodes(MapVariables mapVariables){
      jjtGetChild(0).convertToByteCodes(mapVariables);
  }


}
/* JavaCC - OriginalChecksum=3d0cae9338b1a3f9a542bc5c3b6c9d38 (do not edit this line) */
