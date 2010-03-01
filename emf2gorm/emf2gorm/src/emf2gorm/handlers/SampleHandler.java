package emf2gorm.handlers;

import java.io.PrintWriter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



import no.machina.openNoark.Ecore2Gorm;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
//import org.eclipse.emf.codegen.ecore.generator.Generator;
//import org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl;
//import org.eclipse.emf.codegen.ecore.genmodel.presentation.GenModelEditor;
//import org.eclipse.emf.ecore.EModelElement;
//import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.emf.codegen.ecore.genmodel.presentation.GenModelEditor;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.ISelectionService;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */ 
	public SampleHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		try{
			
			GenModelEditor editor =  (GenModelEditor) HandlerUtil.getActiveEditor(event);
			
			
			URI uri = ((Resource)editor.getEditingDomain().getResourceSet().getResources().get(0)).getURI();
			
			//URI String is on the form: "platform:/resource/<projectname>/model/<modelname>.genmodel"
			//we just want the project name
			String proj = uri.toString().substring(19, uri.toString().indexOf('/', 19));

			//Getting the genModel from the editor
			Generator generator = editor.getGenerator();
			GenModel genModel = (GenModel) generator.getInput();

			
			String out = ""; 
			EObject pack = null;
			for(EObject eo : genModel.eContents()){
				if(pack == null)pack = eo;
				out += eo.toString()+"\n";
				for(EObject eo2 : eo.eContents()){
					out += eo2.toString()+"\n";
				}
			}
			Ecore2Gorm transformer = new Ecore2Gorm();
			transformer.transform(pack, proj);

			MessageDialog.openInformation(
					window.getShell(),
					"Emf2gorm Plug-in",
			"Generation sucessfull");

		}catch(Throwable t){
			t.printStackTrace();
			StringWriter sw = new StringWriter();
			t.printStackTrace(new PrintWriter(sw));
			MessageDialog.openInformation(
					window.getShell(),
					"Emf2gorm Plug-in",
					"Generation failed: "+t.getMessage().toString());
		}
		return null;
	}
	
}
