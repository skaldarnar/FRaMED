package org.framed.orm.ui.command;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.framed.orm.model.Container;
import org.framed.orm.model.Node;

/**
 * This command is for creating roletype, natrualtype and rolegroup. 
 * @author Kay Bierzynski
 * */
public class ORMNodeCreateCommand extends Command {

  private Container parent;
  private Node node;
  private Rectangle constraints;

  public ORMNodeCreateCommand() {
    super.setLabel("ORMNodeCreate");
  }

  /**
   * The command can be executed if all parameters have been set.
   */
  @Override
  public boolean canExecute() {

    return constraints != null && parent != null;
  }

  /**
   * Set the constraints for the {@link Node} and add it to the container {@link Container}.
   */
  @Override
  public void execute() {

    node.setConstraints(constraints);
    node.setContainer(parent);
  }

  /**
   * Remove the {@link Node} from the container {@link Container}.
   */
  @Override
  public void undo() {

    node.setConstraints(null);
    node.setContainer(null);
  }


  public void setConstraints(final Rectangle constraints) {
    this.constraints = constraints;
  }



  public void setNode(final Node node) {
    this.node = node;
  }

  public void setContainer(final Container parent) {
    this.parent = parent;
  }
}