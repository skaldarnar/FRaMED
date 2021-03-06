package org.framed.orm.ui.editor;


import java.util.HashMap;
import java.util.Map;

import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.SelectionToolEntry;
import org.eclipse.gef.tools.SelectionTool;
import org.framed.orm.model.NamedElement;
import org.framed.orm.model.Shape;
import org.framed.orm.ui.editor.ORMGraphicalEditor.EditorType;
import org.framed.orm.ui.factory.ORMCyclicFactory;
import org.framed.orm.ui.factory.ORMAttributeFactory;
import org.framed.orm.ui.factory.ORMCompartmentTypeFactory;
import org.framed.orm.ui.factory.ORMDataTypeFactory;
import org.framed.orm.ui.factory.ORMFulfillmentFactory;
import org.framed.orm.ui.factory.ORMGroupFactory;
import org.framed.orm.ui.factory.ORMInheritanceFactory;
import org.framed.orm.ui.factory.ORMIrreflexiveFactory;
import org.framed.orm.ui.factory.ORMOperationFactory;
import org.framed.orm.ui.factory.ORMNaturalTypeFactory;
import org.framed.orm.ui.factory.ORMRelationshipFactory;
import org.framed.orm.ui.factory.ORMRelationshipImplicationFactory;
import org.framed.orm.ui.factory.ORMRoleEquivalenceFactory;
import org.framed.orm.ui.factory.ORMRoleGroupFactory;
import org.framed.orm.ui.factory.ORMRoleImplicationFactory;
import org.framed.orm.ui.factory.ORMRoleProhibitionFactory;
import org.framed.orm.ui.factory.ORMRoleTypeFactory;
import org.framed.orm.ui.factory.ORMTotalFactory;
import org.framed.orm.ui.tool.CreationAndDirectEditTool;


/**
 * This class provides the palett and it's entrys for the {@link ORMGraphicalEditor}.
 * 
 * @author Kay Bierzynski
 * */
public class ORMGraphicalEditorPalette extends PaletteRoot {

  /** The {@link PaletteGroup} to which all {@link PaletteDrawer}s are added. */
  private PaletteGroup group;
  /** A {@link HashMap}, which contains all visibility flags of the palett entry. */
  private final Map<String, Boolean> entryVisibility;
  /** A {@link HashMap}, which matchs to every palett entry a string id. */
  private final Map<String, CreationToolEntry> entries;

  /**
   * The constructor of this class, where the palett is build and entryVisibility and entries
   * variables are initialized.
   * */
  public ORMGraphicalEditorPalette() {

    entryVisibility = new HashMap<String, Boolean>();
    entries = new HashMap<String, CreationToolEntry>();

    addGroup();
    addSelectionTool();
     createComponentsDrawer();
     createComponentPartsDrawer();
     createConnectionsDrawer();
  }

  /**
   * This method add a palett entry with sting id/name to the entries map.
   * */
  private void addEntry(final String name, final CreationToolEntry entry, final Boolean visibility) {
    entries.put(name, entry);
    setEntryVisibility(name, visibility);
  }

  /** This method sets the visibility of an entry in the entryVisibility map and in the palette. */
  private void setEntryVisibility(final String name, final Boolean visibility) {
    entryVisibility.put(name, visibility);
    if (entries.size() != 0 && entries.get(name) != null) {
      entries.get(name).setVisible(visibility.booleanValue());
    }
  }

  /**
   * A getter for the visibility of a palett entry.
   * 
   * @return boolean
   * */
  private boolean getEntryVisisbility(final String name) {
    return entryVisibility.get(name).booleanValue();
  }


  /** This method sets the visibility of all palett entrys depending on the variable visible. */
  public void setRoleEntriesVisibility(final boolean visible) {
    if (visible) {
      setEntryVisibility("RoleType", true);
      setEntryVisibility("RoleGroup", true);
      setEntryVisibility("Role Implication", true);
      setEntryVisibility("Relationship Implication", true);
      setEntryVisibility("Role Equivalence", true);
      setEntryVisibility("Role Prohibition", true);
      setEntryVisibility("Relationship", true);
      setEntryVisibility("Irreflexive", true);
      setEntryVisibility("Total", true);
      setEntryVisibility("Cyclic", true);

      setEntryVisibility("Compartment", false);
      setEntryVisibility("NaturalType", false);
      setEntryVisibility("DataType", false);
      setEntryVisibility("Group", false);
      setEntryVisibility("Fulfilment", false);
    } else {
      setEntryVisibility("RoleType", false);
      setEntryVisibility("RoleGroup", false);
      setEntryVisibility("Role Implication", false);
      setEntryVisibility("Relationship Implication", false);
      setEntryVisibility("Role Equivalence", false);
      setEntryVisibility("Role Prohibition", false);
      setEntryVisibility("Relationship", false);
      setEntryVisibility("Irreflexive", false);
      setEntryVisibility("Total", false);
      setEntryVisibility("Cyclic", false);

      setEntryVisibility("Compartment", true);
      setEntryVisibility("NaturalType", true);
      setEntryVisibility("DataType", true);
      setEntryVisibility("Group", true);
      setEntryVisibility("Fulfilment", true);
    }
  }



  /** This method updates the visibility of the all palett entrys. */
  public void update(final ORMGraphicalEditor.EditorType type) {
    if (type.equals(EditorType.COMPARTMENT)) {
      setRoleEntriesVisibility(false);
    } else {
      setRoleEntriesVisibility(true);
    }
  }

  /** ! Update function for EditorChangeNotifier */
  public void update(final String type) {
    if (type.equals("StepOutNewPage")) {
      setRoleEntriesVisibility(false);
    }
  }

  /** This method add the {@link SelectionTool} to the palett. */
  private void addSelectionTool() {
    SelectionToolEntry entry = new SelectionToolEntry();
    group.add(entry);
    setDefaultEntry(entry);
  }

  /** This method initializes the {@link PaletteGroup} and adds the group to the palett. */
  private void addGroup() {
    group = new PaletteGroup("Framed Controls");
    add(group);
  }

  /**
   * This method creates the palett entrys for the creation of all {@link Shape} kinds and adds them
   * to palett.
   */
  private void createComponentsDrawer() {
    PaletteDrawer drawer = new PaletteDrawer("Componenten");
    CreationToolEntry entry =
        new CreationToolEntry("Compartment", "Create a new Compartment",
            new ORMCompartmentTypeFactory(), null, null);
    entry.setToolClass(CreationAndDirectEditTool.class);
    entry.setSmallIcon(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
        "icons/compartment.png"));
    drawer.add(entry);
    addEntry("Compartment", entry, true);

    entry =
        new CreationToolEntry("NaturalType", "Create a new NaturalType",
            new ORMNaturalTypeFactory(), null, null);
    entry.setToolClass(CreationAndDirectEditTool.class);
    entry.setSmallIcon(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
        "icons/naturaltype.png"));
    drawer.add(entry);
    addEntry("NaturalType", entry, true);
    
    entry =
        new CreationToolEntry("DataType", "Create a new DataType",
            new ORMDataTypeFactory(), null, null);
    entry.setToolClass(CreationAndDirectEditTool.class);
    entry.setSmallIcon(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
        "icons/datatype.png"));
    drawer.add(entry);
    addEntry("DataType", entry, true);

    entry =
        new CreationToolEntry("RoleType", "Create a new RoleType", new ORMRoleTypeFactory(), null,
            null);
    entry.setToolClass(CreationAndDirectEditTool.class);
    entry.setSmallIcon(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
        "icons/roletype.png"));
    drawer.add(entry);
    addEntry("RoleType", entry, false);

    entry =
        new CreationToolEntry("RoleGroup", "Create a new RoleGroup", new ORMRoleGroupFactory(),
            null, null);
    entry.setToolClass(CreationAndDirectEditTool.class);
    entry.setSmallIcon(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
        "icons/rolegroup.png"));
    drawer.add(entry);
    addEntry("RoleGroup", entry, false);

    entry =
        new CreationToolEntry("Group", "Create a new Group", new ORMGroupFactory(), null, null);
    entry.setToolClass(CreationAndDirectEditTool.class);
    entry.setSmallIcon(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/group.png"));
    drawer.add(entry);
    addEntry("Group", entry, true);

    group.add(drawer);
  }


  /**
   * This method creates the palett entrys for the creation of {@link NamedElement}s (Attributes and
   * Operations) and adds them to palett.
   */
  private void createComponentPartsDrawer() {

    PaletteDrawer drawer = new PaletteDrawer("Parts");

    CreationToolEntry entry1 =
        new CreationToolEntry("Operation", "Create a new Operation", new ORMOperationFactory(), null, null);
    entry1.setToolClass(CreationAndDirectEditTool.class);
    entry1.setSmallIcon(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
        "icons/EOperation.gif"));
    drawer.add(entry1);
    addEntry("Methode", entry1, true);

    CreationToolEntry entry2 =
        new CreationToolEntry("Attribute", "Create a new Attribute", new ORMAttributeFactory(),
            null, null);
    entry2.setToolClass(CreationAndDirectEditTool.class);
    entry2.setSmallIcon(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
        "icons/EAttribute.gif"));
    drawer.add(entry2);
    addEntry("Attribute", entry2, true);

    group.add(drawer);
  }

  /**
   * This method creates the palett entrys for the creation of all {@link Relation} kinds and adds
   * them to palett.
   */
  private void createConnectionsDrawer() {

    PaletteDrawer drawer = new PaletteDrawer("Connections");
    CreationToolEntry entry1 =
        new ConnectionCreationToolEntry("Fulfilment", "Create a new Fulfilment Relation",
            new ORMFulfillmentFactory(), null, null);
    entry1.setSmallIcon(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
        "icons/fulfilment.png"));
    drawer.add(entry1);
    addEntry("Fulfilment", entry1, true);

    CreationToolEntry entry2 =
        new ConnectionCreationToolEntry("Role Implication",
            "Create a new Role Implication Relation", new ORMRoleImplicationFactory(), null, null);
    entry2.setSmallIcon(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
        "icons/roleimplication.png"));
    drawer.add(entry2);
    addEntry("Role Implication", entry2, false);

    CreationToolEntry entry3 =
        new ConnectionCreationToolEntry("Role Equivalence",
            "Create a new Role Equivalence Relation", new ORMRoleEquivalenceFactory(), null, null);
    entry3.setSmallIcon(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
        "icons/roleequivalence.png"));
    drawer.add(entry3);
    addEntry("Role Equivalence", entry3, false);

    CreationToolEntry entry4 =
        new ConnectionCreationToolEntry("Role Prohibition",
            "Create a new Role Prohibition Relation", new ORMRoleProhibitionFactory(), null, null);
    entry4.setSmallIcon(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
        "icons/roleprohibition.png"));
    drawer.add(entry4);
    addEntry("Role Prohibition", entry4, false);

    CreationToolEntry entry5 =
        new ConnectionCreationToolEntry("Inheritance", "Create a new Inheritance Relation",
            new ORMInheritanceFactory(), null, null);
    entry5.setSmallIcon(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
        "icons/inheritance.png"));
    drawer.add(entry5);
    addEntry("Inheritance", entry5, true);

    CreationToolEntry entry6 =
        new ConnectionCreationToolEntry("Relationship", "Create a new Relationship Relation",
            new ORMRelationshipFactory(), null, null);
    entry6.setSmallIcon(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
        "icons/relationship.png"));
    drawer.add(entry6);
    addEntry("Relationship", entry6, false);
    
    CreationToolEntry entry7 =
        new ConnectionCreationToolEntry("Relationship Implication",
            "Create a new Relationship Implication Relation", new ORMRelationshipImplicationFactory(), null, null);
    entry7.setSmallIcon(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
        "icons/roleimplication.png"));
    drawer.add(entry7);
    addEntry("Relationship Implication", entry7, false);

    CreationToolEntry entry8 =
        new ConnectionCreationToolEntry("Irreflexive", "Create a new Irreflexive Relation",
            new ORMIrreflexiveFactory(), null, null);
    entry8.setSmallIcon(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
        "icons/irreflexive.png"));
    drawer.add(entry8);
    addEntry("Irreflexive", entry8, false);

    CreationToolEntry entry9 =
        new ConnectionCreationToolEntry("Total", "Create a new Total Relation",
            new ORMTotalFactory(), null, null);
    entry9
        .setSmallIcon(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/total.png"));
    drawer.add(entry9);
    addEntry("Total", entry9, false);

    CreationToolEntry entry10 =
        new ConnectionCreationToolEntry("Cyclic", "Create a new Cyclic Relation",
            new ORMCyclicFactory(), null, null);
    entry10.setSmallIcon(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
        "icons/cyclic.png"));
    drawer.add(entry10);
    addEntry("Cyclic", entry10, false);

    group.add(drawer);
  }
}
