# OLS
**Otra Lenguaje Simple** (Spanish version of [Yet Another Simple Language](https://github.com/ShutoAraki/YASL-Compiler))

Created by: Shuto Araki, Zavien Sibilia, Emily Costa

Created on: 08/21/2019

## How to run

```java
java -jar run_this.jar modules/modulo1.ols
```


```
<Proceso> -->
  proceso ID ; <Block> .

<Block> -->
  <ValDecls> <VarDecls> <FunDecls> <Stmt>

<ValDecls> -->
  <ValDecl> <ValDecls>
| ε

<ValDecl> -->
  val ID = <Sign> NUM ;

<Sign> -->
  -
| ε

<VarDecls> -->
  <VarDecl> <VarDecls>
| ε

<VarDecl> -->
  var ID : <Type> ;

<Type> -->
  ent
| bool
| vacio

<FunDecls> -->
  <FunDecl> <FunDecls>
| ε

<FunDecl> -->
  fun ID ( <ParamList> ) : <Type> ; <Block> ;

<ParamList> -->
  <Params>
| ε

<Params> -->
  <Param> , <Params>
| <Param>

<Param> -->
  ID : <Type>

<StmtList> —>
  <Stmts>
| ε

<Stmts> -->
  <Stmt> ; <Stmts>
| <Stmt>

<Stmt> -->
  ID = <Expr>
| empezar <StmtList> fin
| si <Expr> entonces <Stmt>
| si <Expr> entonces <Stmt> mas <Stmt>
| mientras <Expr> hacer <Stmt>
| leer STRING
| leer STRING , ID
| escribir <Items>
| <Expr>

<Items> -->
  <Item> , <Items>
| <Item>

<Item> -->
  <Expr>
| STRING

<Expr> -->
  <SimpleExpr> <RelOp> <SimpleExpr>
| <SimpleExpr>

<RelOp> -->
  == | <> | <= | >= | < | >

<SimpleExpr> -->
  <SimpleExpr> <AddOp> <Term>
| <Term>

<AddOp> -->
  + | - | o

<Term> -->
  <Term> <MulOp> <Factor>
| <Factor>

<MulOp> -->
  * | div | mod | y

<Factor> -->
  NUM
| ID
| ID ( <ArgList> )
| verdad
| falso
| <UnOp> <Factor>
| ( <Expr> )

<UnOp> -->
  - | no

<ArgList> -->
  <Args>
| ε

<Args> -->
  <Expr> , <Args>
| <Expr>
```


