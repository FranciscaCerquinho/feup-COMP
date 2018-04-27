/* Generated By:JJTree: Do not edit this line. SimpleNode.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class SimpleNode implements Node {

  protected Node parent;
  protected Node[] children;
  protected int id;
  protected Object value;
  protected parserGrammar parser;

  public SimpleNode(int i) {
    id = i;
  }

  public SimpleNode(parserGrammar p, int i) {
    this(i);
    parser = p;
  }

  public void jjtOpen() {
  }

  public void jjtClose() {
  }

  public void jjtSetParent(Node n) { parent = n; }
  public Node jjtGetParent() { return parent; }

  public void jjtAddChild(Node n, int i) {
    if (children == null) {
      children = new Node[i + 1];
    } else if (i >= children.length) {
      Node c[] = new Node[i + 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = n;
  }

  public Node jjtGetChild(int i) {
    return children[i];
  }

  public int jjtGetNumChildren() {
    return (children == null) ? 0 : children.length;
  }

  public void jjtSetValue(Object value) { this.value = value; }
  public Object jjtGetValue() { return value; }

  /* You can override these two methods in subclasses of SimpleNode to
     customize the way the node appears when the tree is dumped.  If
     your output uses more than one line you should override
     toString(String), otherwise overriding toString() is probably all
     you need to do. */

  public String toString() {
    return parserGrammarTreeConstants.jjtNodeName[id];
  }
  public String toString(String prefix) { return prefix + toString(); }

  /* Override this method if you want to customize how the node dumps
     out its children. */

  public void dump(String prefix) {
    System.out.println(toString(prefix));
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        SimpleNode n = (SimpleNode)children[i];
        if (n != null) {
          n.dump(prefix + " ");
        }
      }
    }
  }

  public int getId() {
    return id;
  }

  public boolean analyse(SymbolsTable currentTable){
    for(int i=0; i < jjtGetNumChildren();i++){
      jjtGetChild(i).analyse(currentTable);
    }
    return true;
  }

  public boolean analyseContent(SymbolsTable currentTable){
    return true;
  }

  public boolean analyseRhs(SymbolsTable currentTable){
    return true;
  }

  public boolean analyseLhs(SymbolsTable currentTable, boolean value){
    return true;
  }

  public boolean isScalar(){
    return true;
  }

  public void convertToByteCodes(MapVariables data){
    return;
  }

  public String getName() {
    return "";
  }
}

/* JavaCC - OriginalChecksum=4ffdb2cf57f2332df7bea5a797ddfcf8 (do not edit this line) */
