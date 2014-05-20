package org.framed.orm.ui.editPolicy;

import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.framed.orm.model.Compartment;
import org.framed.orm.model.Grouping;
import org.framed.orm.model.NaturalType;
import org.framed.orm.model.RoleType;
import org.framed.orm.ui.action.StepInAction;
import org.framed.orm.ui.action.StepOutAction;
import org.framed.orm.ui.action.StepInNewPageAction;
import org.framed.orm.ui.action.StepOutNewPageAction;
import org.framed.orm.ui.command.StepInCommand;
import org.framed.orm.ui.command.StepOutCommand;
import org.framed.orm.ui.command.ORMGroupingDeleteCommand;
import org.framed.orm.ui.command.StepInNewPageCommand;
import org.framed.orm.ui.command.StepOutNewPageCommand;
import org.framed.orm.ui.command.types.ORMCompartmentDeleteCommand;
import org.framed.orm.ui.command.types.ORMNaturalTypeDeleteCommand;
import org.framed.orm.ui.command.types.ORMRoleTypeDeleteCommand;
import org.framed.orm.ui.editPart.ORMGroupingEditPart;
import org.framed.orm.ui.editPart.types.ORMCompartmentEditPart;
import org.framed.orm.ui.editor.ORMGraphicalEditor;
import org.framed.orm.ui.figure.ORMCompartmentV1Figure;
import org.framed.orm.ui.figure.ORMGroupingV1Figure;

/**
 * @author Kay Bierzynski
 * */
public class ORMTypeComponentEditPolicy extends ComponentEditPolicy {
	
	@Override 
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		Command retVal = null;
		if(getHost().getModel() instanceof Compartment ){
			if(((ORMCompartmentEditPart)getHost()).getFigure() instanceof ORMCompartmentV1Figure ){
				ORMCompartmentDeleteCommand typeDeleteCommand = new ORMCompartmentDeleteCommand();
				typeDeleteCommand.setCompartment((Compartment) getHost().getModel());
				retVal = typeDeleteCommand;
			}
		}
		if(getHost().getModel() instanceof NaturalType){
			ORMNaturalTypeDeleteCommand typeDeleteCommand = new ORMNaturalTypeDeleteCommand();
	    	typeDeleteCommand.setType((NaturalType) getHost().getModel());
	    	retVal = typeDeleteCommand;
		}
		if(getHost().getModel() instanceof RoleType){
			ORMRoleTypeDeleteCommand typeDeleteCommand = new ORMRoleTypeDeleteCommand();
	    	typeDeleteCommand.setType((RoleType) getHost().getModel());
	    	retVal = typeDeleteCommand;
		}
		if(getHost().getModel() instanceof Grouping){
			if(((ORMGroupingEditPart)getHost()).getFigure() instanceof ORMGroupingV1Figure ){
				ORMGroupingDeleteCommand groupingDeleteCommand = new ORMGroupingDeleteCommand();
				groupingDeleteCommand.setGrouping((Grouping) getHost().getModel());
				retVal = groupingDeleteCommand;
			}
		}
	    return retVal;
	  }
	
	 private StepInCommand createStepInCommand() {
	        EditPart host =  getHost();
	        
	        StepInCommand command = new  StepInCommand();
	        command.setEditPart((AbstractGraphicalEditPart)host);	        
	        command.setEditorPart( (ORMGraphicalEditor) ((DefaultEditDomain) host.getViewer().getEditDomain())
	            .getEditorPart());
	        
	        return command;
	    }
	
	 
	 private StepOutCommand createStepOutCommand() {
	        EditPart host =  getHost();
	       
	        StepOutCommand command = new  StepOutCommand();
	        command.setEditPart((AbstractGraphicalEditPart)host);
	        command.setEditorPart( (ORMGraphicalEditor) ((DefaultEditDomain) host.getViewer().getEditDomain())
            .getEditorPart());
	        return command;
	    }
	 
	 private StepInNewPageCommand createStepInNewPageCommand() {
	        EditPart host =  getHost();
	        
	        StepInNewPageCommand command = new StepInNewPageCommand();
	        command.setEditPart((AbstractGraphicalEditPart)host);
	        
	        return command;
	    }
	
	 
	 private StepOutNewPageCommand createStepOutNewPageCommand() {
	        EditPart host =  getHost();
	       
	        StepOutNewPageCommand command = new  StepOutNewPageCommand();
	        command.setEditPart((AbstractGraphicalEditPart)host);
	        return command;
	    }
	 
	/**
     * <p>Extends the parent implementation by handling incoming GO_DOWN_TREE, GO_UP_TREE, STEP_IN_NEW_PAGE and STEP_OUT_NEW_PAGE requests.</p>
     * <p>The parent implementation {@inheritDoc}</p>
     */
    @Override
    public Command getCommand(Request request) {
        if(request.getType().equals(StepInAction.STEP_IN_REQUEST)){
            return createStepInCommand();
        }
        if(request.getType().equals(StepOutAction.STEP_OUT_REQUEST)){
            return createStepOutCommand();
        }
        if(request.getType().equals(StepInNewPageAction.STEP_IN_NEW_PAGE_REQUEST)){
            return createStepInNewPageCommand();
        }
        if(request.getType().equals(StepOutNewPageAction.STEP_OUT_NEW_PAGE_REQUEST)){
            return createStepOutNewPageCommand();
        }
        return super.getCommand(request);
    }
}
