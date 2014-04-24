package org.framed.orm.ui.action;

import java.util.List;

import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.ui.actions.SaveAction;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;
import org.framed.orm.ui.editPart.ORMCompartmentEditPart;
import org.framed.orm.ui.editPart.ORMGroupingEditPart;
import org.framed.orm.ui.editor.ORMGraphicalEditor;

/**
 * @author Kay BIerzynski
 * */
//TODO: rename this class to StepOut
public class GoUpTreeAction extends SelectionAction {


	public static final String GO_UP_TREE_ID = "GoUpTree";
	public static final String  GO_UP_TREE_REQUEST = "GoUpTree";
	private Request request;

	/**
	 * Create a new instance of the class.
	 * @param part
	 */
	public GoUpTreeAction(IWorkbenchPart part) {
		super(part);
		setId( GO_UP_TREE_ID);
		setText("Step out");
		request = new Request(GO_UP_TREE_REQUEST);
	}

	/**
	 * Execute the commands that perform the {@link GoUpTreeAction#GO_UP_TREE_REQUEST GO_UP_TREE_REQUEST}.
	 *
	 * It is assumed that this method is executed directly after
	 * {@link GoUpTreeAction#calculateEnabled() calculateEnabled()}
	 */
	@Override
	public void run() {
		 ORMGraphicalEditor editorPart = null;
		// selected objects must be compartment or grouping editpart because the action is enabled.
		@SuppressWarnings("unchecked") List<AbstractGraphicalEditPart> editParts = getSelectedObjects();
		CompoundCommand compoundCommand = new CompoundCommand();
		for(AbstractGraphicalEditPart editPart : editParts) {
			compoundCommand.add(editPart.getCommand(request));
			if(editorPart==null) editorPart = (ORMGraphicalEditor) ((DefaultEditDomain)editPart.getViewer().getEditDomain()).getEditorPart();
		}
		SaveAction save = new SaveAction(editorPart);
		execute(compoundCommand);
		save.run();
		editorPart.getOwnViewer().getSelectionManager().deselectAll();
	}

	/**
	  * {@inheritDoc}
	  * <p>The action is enabled if all the selected entities on the
	  * editor are {@link ORMCompartmentEditPart} or  {@link ORMGroupingEditPart} instances</p>
	 */
	@Override
	protected boolean calculateEnabled() {

     for(Object selectedObject : getSelectedObjects()) {
  
  	   	if(selectedObject instanceof ORMCompartmentEditPart) {
  	   		if(((ORMCompartmentEditPart) selectedObject).equals(((ORMCompartmentEditPart) selectedObject).getViewer().getRootEditPart().getContents()))
  	   			return true;
  	   	}
  	   	if(selectedObject instanceof ORMGroupingEditPart) {
  	   		if(((ORMGroupingEditPart) selectedObject).equals(((ORMGroupingEditPart) selectedObject).getViewer().getRootEditPart().getContents()))
  	   			return true;
  	   		}
     	}
     return false;
    }

}