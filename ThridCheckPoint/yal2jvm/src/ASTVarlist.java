/* Generated By:JJTree: Do not edit this line. ASTVarlist.java Version 6.0 */
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
      public int analyseContent(SymbolsTable currentTable){
        System.out.println("Analyse the children of Varlist");
        int b=0;
        for(int i=0; i < jjtGetNumChildren();i++){
         if(jjtGetChild(i).analyse(currentTable)==-1)
          b=-1;
        }

        return b;
      }

      public String convertToByteCodes(MapVariables data, int loop_no){
        String line = "";
        for(int i=0; i < jjtGetNumChildren();i++){
          line += jjtGetChild(i).convertToByteCodes(data, loop_no);
        }

        return line;
      }
}
/* JavaCC - OriginalChecksum=e449665735ec50a50062d1a8a349a85d (do not edit this line) */
