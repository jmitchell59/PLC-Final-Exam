# PLC-Final-Exam
## 1)
See Token.java
## 2)
See Compiler.java
## 3)
See Lexer.java
## 4)
See Parser.java
## 5)
M_s(if(<and>) <block>[1] else <block>[2], s) <br/>
		if M_b(<and>, s) == error <br/>
		return error <br/>
		if M_b(<and>, s) <br/>
			return M_block(<block>[1], s) <br/>
		else return M_block(<block>[2], s) <br/>
## 6)
M_while (while (<and>) <block> =, s) <br/>
		if M_b(<and>, s) == error <br/>
		return error <br/>
		if M_b(<and>, s) <br/>
			if M_b(<stmt>, s) ==error <br/>
				error <br/>
			else s = M_s(<block>, s) <br/>
			M_while(while (<and>) <block> =, s)		 <br/>
		else <br/>
		return s <br/>
## 7)
M_e (<expression>, s) == switch(<expression>) <br/>
	case <term>[1] *  <term>[2]: <br/>
		if M_e(<expression>.term[1], s) == error || M_e(<expression>.term[2], s) == error <br/>
		return error <br/>
		if(M_t(<term[1]>).type != M_t(<term[2]>).type) <br/>
		return error		 <br/>
		else return M_t(<term[1]>, s) * M_t (<term[2]>, s) <br/>
## 8)
M_bool_e (<bool_expression>, s) == switch(<bool_expression>) <br/>
	case <boolterm>[1] *  <boolterm>[2]: <br/>
		if M_bool_e(<bool_expression>.term[1], s) == error || M_e(<bool_expression>.term[2], s) == error <br/>
		return error	 <br/>
		else return M_bool_t(<bool_term[1]>, s) * M_bool_t (<bool_term[2]>, s) <br/>
	case <boolterm>[1] /  <boolterm>[2]: <br/>
		if M_bool_e(<bool_expression>.term[1], s) == error || M_e(<bool_expression>.term[2], s) == error  <br/>
		return error		 <br/>
		else return M_bool_t(<bool_term[1]>, s) / M_bool_t (<bool_term[2]>, s) <br/>
	case <boolterm>[1] %  <boolterm>[2]: <br/>
		if M_bool_e(<bool_expression>.term[1], s) == error || M_e(<bool_expression>.term[2], s) == error  <br/>
		return error		 <br/>
		else return M_bool_t(<bool_term[1]>, s) % M_bool_t (<bool_term[2]>, s) <br/>
	case <boolterm> <br/>
		if M_bool_e(<bool_expression>.term, s) == error   <br/>
		return error		 <br/>
		else return M_bool_t(<bool_term>, s) <br/>
## 9)
<assignment> -> id = <expression>
		if <expression>.type == char_lit) then id.expected == char_lit or nat_lit <br/>
		if <expression>.type == string_lit then id.expected == string_lit <br/>
		if <expression>.type == nat_lit then id.expected == bool_lit or char_lit or real_lit or nat_lit <br/>
		if <expression>.type == bool_lit then id.expected nat_lit or bool_lit <br/>
		if <expression>.type == real_lit then id.expected == real_lit <br/>
	<expression> -> <term>[1] + <term>[2] <br/>
		if(lookup(term[1]).type == string_lit && lookup(term[2]) == string_lit ) <br/>
				<expression> ==  “<term>[1].value <term>[2].value” <br/>
 <br/>					
	<expression> -> <term> - <term> <br/>
	<expression> -> <term> <br/>
	<term> -> <factor> * <factor> <br/>
		PREDICATE if(lookup(factor[1]).type == string_lit && lookup(factor[2]) == nat_lit ) <br/>
				<term> == <factor>[1].value <factor>[1].value <br/>
	<term> -> <factor> / <factor> <br/>
		PREDICATE: <factor> <> 0 <br/>
	<term> -> <factor> % <factor> <br/>
		PREDICATE: <factor> <> 0 <br/>
	<term> -> <factor> <br/>
	<factor> -> ( <expression> ) <br/>
	<factor> -> int_lit <br/>
	<factor> -> id <br/>
	<factor> -> <expression> <br/>
## 10)
### Statement 1:
int y = 1;
double radius = 1.0;
int x = 5 * (3/2);
x = y + 1;
double area = radius * radius * 3.14;
### Statement 2:
int a = 50; <br/>
float b; <br/>
a = 25; <br/>
b = 34.25f; <br/>
### Statement 3:
a, b = 50, 100 ; <br/>
print(a) ; <br/>
print(b) ; <br/>
## 11)
### a) 
2 * ( b - 1 ) - 1 > 0 <br/>
2*(b-1)>1 <br/>
(b-1)>1/2 <br/>
Weakest Precondition: b > 3/2 <br/>
### b)
if(x<y) <br/>
x = x + 1  <br/>
else <br/>
x=3x <br/>
{x<0} <br/>
Weakest Precondition: x<-1 <br/>
	 <br/>
### c)
y=a * 2 * (b-1) - 1 <br/>
if(x<y) <br/>
x=y+1 <br/>
else <br/>
x=3x <br/>
{x<0} <br/>
x=y+1 <br/>
else <br/>
x=3y <br/>
Weakest Precondition: y<-1 <br/>

### d)
a=3*(2*b+a); <br/>
b=2*a-1 <br/>
{b>5} <br/>
2*a-1>5 <br/>
2*a>6 <br/>
Weakest Precondition: a>3 <br/>
