/* Generated By:JJTree: Do not edit this line. ASTVarlist.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTVarlist extends SimpleNode {
  public ASTVarlist(int id) {
    super(id);
  }

  public ASTVarlist(parserGrammar p, int id) {
    super(p, id);
  }

  @Override
  public boolean analyseContent(SymbolsTable currentTable){
    for(int i=0; i < jjtGetNumChildren();i++){
      jjtGetChild(i).analyse(currentTable);
    }

    return true;
  }

}
/* JavaCC - OriginalChecksum=8ce8ae1fb4cc606b52776763fe56aacd (do not edit this line) */
