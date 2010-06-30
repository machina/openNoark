/*
    This file is part of Friark.

    Friark is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Friark is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Friark.  If not, see <http://www.gnu.org/licenses/>.
*/

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package no.machina.gestalt2;

import groovy.lang.GroovyClassLoader;


import java.security.CodeSource;
import java.util.List;
import java.util.Map;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.MethodNode;
import org.codehaus.groovy.ast.expr.ArgumentListExpression;
import org.codehaus.groovy.ast.expr.BinaryExpression;
import org.codehaus.groovy.ast.expr.BooleanExpression;
import org.codehaus.groovy.ast.expr.ClassExpression;
import org.codehaus.groovy.ast.expr.ClosureExpression;
import org.codehaus.groovy.ast.expr.ConstantExpression;
import org.codehaus.groovy.ast.expr.ConstructorCallExpression;
import org.codehaus.groovy.ast.expr.DeclarationExpression;
import org.codehaus.groovy.ast.expr.GStringExpression;
import org.codehaus.groovy.ast.expr.ListExpression;
import org.codehaus.groovy.ast.expr.MapEntryExpression;
import org.codehaus.groovy.ast.expr.MethodCallExpression;
import org.codehaus.groovy.ast.expr.NamedArgumentListExpression;
import org.codehaus.groovy.ast.expr.VariableExpression;
import org.codehaus.groovy.ast.stmt.BlockStatement;
import org.codehaus.groovy.ast.stmt.ExpressionStatement;
import org.codehaus.groovy.ast.stmt.IfStatement;
import org.codehaus.groovy.ast.stmt.ReturnStatement;
import org.codehaus.groovy.ast.stmt.Statement;
import org.codehaus.groovy.classgen.BytecodeSequence;
import org.codehaus.groovy.classgen.GeneratorContext;
import org.codehaus.groovy.control.CompilationFailedException;
import org.codehaus.groovy.control.CompilationUnit;
import org.codehaus.groovy.control.CompilationUnit.PrimaryClassNodeOperation;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.Phases;
import org.codehaus.groovy.control.SourceUnit;

/**
 *
 * @author kent
 */
public class SandboxingClassLoader extends GroovyClassLoader {

    private Map<String, List<String>> safeClasses;


		public SandboxingClassLoader(Map<String, List<String>> safeClasses) {
        super();
        this.safeClasses = safeClasses;
    }
/*    public SandboxingClassLoader(Map<String, List<String>> safeClasses,java.lang.ClassLoader parent,org.codehaus.groovy.control.CompilerConfiguration config) {
        super(parent, config);
        this.safeClasses = safeClasses;
    }*/

    @Override
    protected CompilationUnit createCompilationUnit(CompilerConfiguration config, CodeSource source) {
				//System.out.println("createCompilationUnit");
       // System.out.println("createCompilationUnit called");
        CompilationUnit cu = new CompilationUnit(config, source, this);

        cu.addPhaseOperation(new PrimaryClassNodeOperation() {

            public void call(SourceUnit source, GeneratorContext context, ClassNode classNode) throws CompilationFailedException {
                ClassNode node = classNode;
                for (Object method : node.getMethods()) {
                    MethodNode mnode = (MethodNode) method;
                    Statement code = mnode.getCode();
                    //if (mnode.getName().equals("getBuilderClosure")) {
                        checkStatement(code);
                    //}
                }

            }
        }, Phases.CLASS_GENERATION);
        return cu;
    }

    public void checkStatement(Statement statement) {
		
        //System.out.println("statement: " + statement);
        if (statement instanceof BlockStatement) {
            checkBlockStatement((BlockStatement) statement);
        } else if (statement instanceof ExpressionStatement) {
            checkExpressionStatement((ExpressionStatement) statement);
        } else if (statement instanceof ReturnStatement) {
            checkReturnStatement((ReturnStatement) statement);
        } else if (statement instanceof IfStatement) {
            checkIfStatement((IfStatement) statement);
        } else if (statement instanceof BytecodeSequence) {

				} else {
            //System.out.println("UNNKNOWN STATEMENT: " + statement);
        }
    }

    public void checkReturnStatement(ReturnStatement statement) {
        checkExpression(statement.getExpression());
    }

    public void checkBlockStatement(BlockStatement statement) {
        for (Object o : statement.getStatements()) {
            Statement s = (Statement) o;

            checkStatement(s);
        }
    }

    public void checkExpressionStatement(ExpressionStatement statement) {
        checkExpression(statement.getExpression());
    }

    public void checkIfStatement(IfStatement statement) {
        checkExpression(statement.getBooleanExpression());
        checkStatement(statement.getIfBlock());
        checkStatement(statement.getElseBlock());
    }



    private void checkExpression(org.codehaus.groovy.ast.expr.Expression expression) {
        //System.out.println("expression: "+expression);
        if (expression instanceof DeclarationExpression) {
            checkDeclarationExpression((DeclarationExpression) expression);
        } else if (expression instanceof VariableExpression) {
            checkVariableExpression((VariableExpression) expression);
        } else if (expression instanceof ClosureExpression) {
            checkClosureExpression((ClosureExpression) expression);
        } else if (expression instanceof ConstructorCallExpression) {
            checkConstructorCallExpression((ConstructorCallExpression) expression);
        } else if (expression instanceof MethodCallExpression) {
            checkMethodCallExpression((MethodCallExpression) expression);
        } else if (expression instanceof ArgumentListExpression) {
            checkArgumentListExpression((ArgumentListExpression) expression);
        } else if (expression instanceof NamedArgumentListExpression) {
            checkNamedArgumentListExpression((NamedArgumentListExpression) expression);
        } else if (expression instanceof ClassExpression) {
            checkClassExpression((ClassExpression) expression);
        } else if(expression instanceof ConstantExpression) {
            checkConstantExpression((ConstantExpression)expression);
        } else if(expression instanceof MapEntryExpression){
            checkMapEntryExpression((MapEntryExpression)expression);
        }else if(expression instanceof GStringExpression){
            checkGStringExpression((GStringExpression)expression);
        }else if(expression instanceof ListExpression) {
            checkListExpression((ListExpression)expression);
        } else if(expression instanceof BooleanExpression){
            checkBooleanExpression((BooleanExpression)expression);
        }else if(expression instanceof BinaryExpression){
            checkBinaryExpression((BinaryExpression)expression);
        }else {
            //System.out.println("UNNKNOWN EXPRESSION ENCOUNTERED: " + expression);
        }
    }

    private void checkDeclarationExpression(DeclarationExpression declarationExpression) {
        checkExpression(declarationExpression.getVariableExpression());
        checkExpression(declarationExpression.getRightExpression());
        checkExpression(declarationExpression.getLeftExpression());
    }



    private void checkVariableExpression(VariableExpression expression) {
        if (expression.hasInitialExpression()) {
            checkExpression(expression.getInitialExpression());
        }

        //System.out.println("variabel: " + expression.getText() + ", type: " + expression.getType().getTypeClass());
    }

    private void checkClosureExpression(ClosureExpression expression) {
        checkStatement(expression.getCode());
    }

    private void checkConstructorCallExpression(ConstructorCallExpression expression) {
        checkClass(expression.getType().getTypeClass());
        checkExpression(expression.getArguments());
    }

    private void checkMethodCallExpression(MethodCallExpression expression) {
        //System.out.println("methodcall  obj:"+expression.getObjectExpression()+" meth: "+expression.getMethodAsString());
        checkExpression(expression.getObjectExpression());
        checkExpression(expression.getMethod());
        checkExpression(expression.getArguments());
        
        if(expression.getObjectExpression() instanceof ConstantExpression){
            ConstantExpression ce = (ConstantExpression) expression.getObjectExpression();
            checkClass(ce.getType().getTypeClass());
            checkMethod(ce.getType().getTypeClass(), expression.getMethod().getText());
        }
        
        if(expression.getObjectExpression() instanceof VariableExpression){
            VariableExpression ve = (VariableExpression) expression.getObjectExpression();
            if(!ve.getText().equals("this")){
                checkClass(ve.getType().getTypeClass());
                checkMethod(ve.getType().getTypeClass(), expression.getMethod().getText());
            }
        }
        
    }
    
    

    private void checkArgumentListExpression(ArgumentListExpression expression) {
        for (org.codehaus.groovy.ast.expr.Expression subExpr : (List<org.codehaus.groovy.ast.expr.Expression>) expression.getExpressions()) {
            checkExpression(subExpr);
        }
    }

    private void checkNamedArgumentListExpression(NamedArgumentListExpression expression) {
        for (org.codehaus.groovy.ast.expr.MapEntryExpression subExpr : (List<org.codehaus.groovy.ast.expr.MapEntryExpression>) expression.getMapEntryExpressions()) {
            checkExpression(subExpr);
        }
    }
    private void checkClassExpression(ClassExpression expression) {
        if(!expression.getType().isScript())  checkClass(expression.getType().getTypeClass());

    }

    private void checkMapEntryExpression(MapEntryExpression expression){
        checkExpression(expression.getKeyExpression());
        checkExpression(expression.getValueExpression());
    }
    
    private void checkGStringExpression(GStringExpression expression){
        for(org.codehaus.groovy.ast.expr.Expression subExpr : (List<org.codehaus.groovy.ast.expr.Expression>) expression.getValues()){
            checkExpression(subExpr);
        }
    }
    private void checkConstantExpression(ConstantExpression expression){
        //System.out.println("constantexpr type: "+expression.getType().getTypeClass());
        checkClass(expression.getType().getTypeClass());
        
    }

    private void checkListExpression(ListExpression expression){
        for(org.codehaus.groovy.ast.expr.Expression subexpr : (List<org.codehaus.groovy.ast.expr.Expression>) expression.getExpressions()){
            System.out.println("subexpr: "+subexpr);
            checkExpression(subexpr);
        }
    }
    
    private void checkBooleanExpression(BooleanExpression expression){
        checkExpression(expression.getExpression());
    }

    private void checkBinaryExpression(BinaryExpression expression) {
        checkExpression(expression.getLeftExpression());
        checkExpression(expression.getRightExpression());
    }
    
    private void checkClass(Class klass) {
        boolean safe = false;
        for (String className : safeClasses.keySet()) {
            if (klass.getName().equals(className)) {
                safe = true;
            }
        }
        if (!safe) {
            //System.out.println("unsafe class: "+klass.getName());
            throw new SecurityException("unsafe class is attemted used: "+klass.getName());
        }
    }
    
    private void checkMethod(Class typeClass, String method) {
        if(!safeClasses.containsKey(typeClass.getName()) ) throw new SecurityException("unsafe class is attemted used");
        boolean safe = false;
        for(String allowdMethod : safeClasses.get(typeClass.getName())){
            if(allowdMethod.equals(method)) {
                safe = true;
            }
        }
        if(!safe) throw new SecurityException("unsafe method is attemted used. Class: "+typeClass.getName()+" method: "+method);
    }
}
