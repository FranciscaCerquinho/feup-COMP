/* Generated By:JJTree: Do not edit this line. ASTStmtlst.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTStmtlst extends SimpleNode {
  public ASTStmtlst(int id) {
    super(id);
  }

  public ASTStmtlst(parserGrammar p, int id) {
    super(p, id);
  }

  @Override
  public boolean analyseContent(SymbolsTable currentTable){
    System.out.println("Analyse the right part of Stmtlst");

    for(int i=0; i < jjtGetNumChildren();i++){
      jjtGetChild(i).analyse(currentTable);
    }

    return true;
  }

  public String convertToByteCodes(MapVariables data){
    String line = "";

    for(int i = 0; i < jjtGetNumChildren(); i++){
     line += jjtGetChild(i).convertToByteCodes(data);
    }

    return line;
  }


}
/* JavaCC - OriginalChecksum=0dcb631473af42492ddd8245414264d7 (do not edit this line) */
