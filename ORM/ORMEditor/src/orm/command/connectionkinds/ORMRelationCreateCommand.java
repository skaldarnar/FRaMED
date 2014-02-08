package orm.command.connectionkinds;

import org.eclipse.gef.commands.Command;

import orm.model.Relation;
import orm.model.Node;
import orm.model.RelationContainer;

/**
 * @author Kay Bierzynski
 * */
public class ORMRelationCreateCommand extends Command {
	
	  private Node target;
	  private Node source;
	  private Relation relation;
	  private RelationContainer rc;

	  
	  @Override
	  public boolean canExecute() {
	    return target != null && source != null && relation != null && rc!=null;
	  }
	   
	  @Override public void execute() {
	    relation.setSource(source);
	    relation.setTarget(target);
	    relation.setRelationContainer(rc);
	  }
	 
	  @Override public void undo() {
	    relation.getSource().getOutgoingLinks().remove(relation);
	    relation.setSource(null);
	    relation.getTarget().getIncomingLinks().remove(relation);
	    relation.setTarget(null);
	    relation.setRelationContainer(null);
	  }
	 
	  public void setSourceNode(Node source) {
	    this.source = source;
	  }
	   
	  public void setTargetNode(Node target) {
	    this.target = target;
	  }
	   
	  public void setRelation(Relation relation) {
	    this.relation = relation;
	  }
	   
	  public void setRelationContainer(RelationContainer rm) {
		    this.rc = rm;
	  }
}
