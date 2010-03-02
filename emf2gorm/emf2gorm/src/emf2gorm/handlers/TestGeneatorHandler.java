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

package emf2gorm.handlers;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



//import no.machina.openNoark.Ecore2GormTests;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
/*import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl;
import org.eclipse.emf.codegen.ecore.genmodel.presentation.GenModelEditor;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;*/
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class TestGeneatorHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */ 
	public TestGeneatorHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		
		try{
		
		IEditorPart editor =  HandlerUtil.getActiveEditor(event);
		
		//Method m = editor.getClass().getMethod("getGenerator");
		Object generator = invoke(editor, "getGenerator");
		Object genModel = invoke(generator, "getInput");
		
		
		Object elem =  invoke(genModel, "getEcoreModelElement");
		String out = ""; 
		Object pack = null;
		for(Object eo : (Iterable)invoke(genModel, "eContents")){
			if(pack == null)pack = eo;
			out += eo.toString()+"\n";
			for(Object eo2 : (Iterable)invoke(eo, "eContents")){
				out += eo2.toString()+"\n";
			}
		}
		//Ecore2GormTests transformer = new Ecore2GormTests("no.machina.domain");
		
		
		}catch(Throwable t){
			StringWriter sw = new StringWriter();
			t.printStackTrace(new PrintWriter(sw));
			MessageDialog.openInformation(
					window.getShell(),
					"Emf2gorm Plug-in",
					"Generation sucessfull");
		}
		return null;
	}
	
	private Object invoke(Object obj, String method) throws NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		Method m = obj.getClass().getMethod(method);
		return m.invoke(obj);
	}
}
