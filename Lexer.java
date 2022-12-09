public class Lexer {
  //Variables 
  private String input;
  private Token[] tokens;
  
  //Constructor
  public Lexer(String input) {
   this.input = input;
   this.tokens = new Token[input.length()];
  }
  
  //Function to tokenize the input
  public void tokenize(){
   int tokenIndex = 0;
   for(int i=0; i<input.length(); i++) {
    char ch = input.charAt(i);
    switch(ch) {
    case '+': 
     tokens[tokenIndex++] = new Token("Operation", "+");
     break;
    case '-': 
     tokens[tokenIndex++] = new Token("Operation", "-");
     break;
    case '*': 
     tokens[tokenIndex++] = new Token("Operation", "*");
     break;
    case '/':
     tokens[tokenIndex++] = new Token("Operation", "/");
     break;
    case '^': 
     tokens[tokenIndex++] = new Token("Operation", "^");
     break;
    case '>': 
     tokens[tokenIndex++] = new Token("Greater Than", ">");
     break;
    case '<': 
     tokens[tokenIndex++] = new Token("Less Than", "<");
     break;
    case '>=': 
     tokens[tokenIndex++] = new Token("Greater Than or Equal to", ">=");
     break;
    case '<=': 
     tokens[tokenIndex++] = new Token("Less Than or Equal to", "<=");
     break;
    case '==': 
     tokens[tokenIndex++] = new Token("Equal to", "==");
     break;
    case '!=': 
     tokens[tokenIndex++] = new Token("Not Equal to", "!=");
     break;
    case '!': 
     tokens[tokenIndex++] = new Token("Logical Not", "!");
     break;
    case '&&': 
     tokens[tokenIndex++] = new Token("Logical And", "&&");
     break;
    case '||': 
     tokens[tokenIndex++] = new Token("Logical Or", "||");
     break;
    case '.': 
     tokens[tokenIndex++] = new Token("Real Literal", Character.toString(ch));
     break;
    case '0': case '1': case '2': case '3': case '4': //Natural literal
    case '5': case '6': case '7': case '8': case '9':
     tokens[tokenIndex++] = new Token("Natural Literal", Character.toString(ch));
     break;
    case 'true': case 'false': //Boolean literal
     tokens[tokenIndex++] = new Token("Boolean Literal", Character.toString(ch));
     break;
    case '\'': //Character literal
     tokens[tokenIndex++] = new Token("Character Literal", Character.toString(ch));
     break;
    case '"': //String literal
     tokens[tokenIndex++] = new Token("String Literal", Character.toString(ch));
     break;
    case 'for': //Keywords for selection statement
     tokens[tokenIndex++] = new Token("Keyword", "for");
     break;
    case 'while': //Keywords for loop statement
     tokens[tokenIndex++] = new Token("Keyword", "while");
     break;
    case 'String': case 'int': case 'char': case 'float': //Keywords for variable declaration
    case 'boolean':
     tokens[tokenIndex++] = new Token("Keyword", Character.toString(ch));
     break;
    }
   }
  }
