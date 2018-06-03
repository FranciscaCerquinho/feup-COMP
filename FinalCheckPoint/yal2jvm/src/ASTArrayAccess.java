/* Generated By:JJTree: Do not edit this line. ASTArrayAccess.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTArrayAccess extends SimpleNode {
  private String name;

  public ASTArrayAccess(int id) {
    super(id);
  }

  public ASTArrayAccess(parserGrammar p, int id) {
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
  public int analyse(SymbolsTable currentTable){

    if(currentTable.returnSymbol(name) != null){
			System.out.println("This value's array exists on Symbols Table");

      return 1;
		}

    System.out.println("This value's array doesn't exist on Symbols Table");
    return -1;

  }

	public int analyseRhs(SymbolsTable currentTable){
		System.out.println("Analyse the right part of ArrayAccess");

		return 1;
	}

	public int analyseLhs(SymbolsTable currentTable, boolean value){
		Symbol symbol = currentTable.returnSymbol(name);

		if(symbol == null){
			System.out.println("Symbol is null on ArrayAccess");
			currentTable.putOnHashMap(new Symbol("ArrayAccess",name,value));
		}

		else{
			//verificar se o valor de Rhs não é escalar OU se o símbolo não é um array
			if(value != true || symbol.isScalar() == true){
				System.out.println("Semantics Error!");
				return -1;
			}
		}

		return 0;

	}

	public String convertToByteCodes(MapVariables mapVariables){
    String line = "";

		line += "aload_" +  mapVariables.returnByteCode(name) + "\n";
		line +=  this.jjtGetChild(0).convertToByteCodes(mapVariables);

		if(this.jjtGetParent().getId() != parserGrammarTreeConstants.JJTLHS)
			line += "iaload"  + "\n";
		
		return line;
  }

}
/* JavaCC - OriginalChecksum=7ebc8b8804d088e1ea5d187558cc8d52 (do not edit this line) */
