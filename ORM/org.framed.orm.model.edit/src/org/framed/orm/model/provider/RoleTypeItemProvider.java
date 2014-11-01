/**
 */
package org.framed.orm.model.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.framed.orm.model.OrmFactory;
import org.framed.orm.model.OrmPackage;
import org.framed.orm.model.RoleType;

/**
 * This is the item provider adapter for a {@link org.framed.orm.model.RoleType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RoleTypeItemProvider extends RoleGroupElementItemProvider {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoleTypeItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
    if (itemPropertyDescriptors == null) {
      super.getPropertyDescriptors(object);

      addFulfillmentPropertyDescriptor(object);
      addNamePropertyDescriptor(object);
      addIncomingPropertyDescriptor(object);
      addOutgoingPropertyDescriptor(object);
      addBoundariesPropertyDescriptor(object);
      addTr_extendsPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Fulfillment feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addFulfillmentPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(
        ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
        getResourceLocator(),
        getString("_UI_AbstractRole_fulfillment_feature"),
        getString("_UI_PropertyDescriptor_description", "_UI_AbstractRole_fulfillment_feature",
            "_UI_AbstractRole_type"), OrmPackage.Literals.ABSTRACT_ROLE__FULFILLMENT, true, false,
        true, null, null, null));
  }

  /**
   * This adds a property descriptor for the Name feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addNamePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(
        ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
        getResourceLocator(),
        getString("_UI_NamedElement_name_feature"),
        getString("_UI_PropertyDescriptor_description", "_UI_NamedElement_name_feature",
            "_UI_NamedElement_type"), OrmPackage.Literals.NAMED_ELEMENT__NAME, true, false, false,
        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
  }

  /**
   * This adds a property descriptor for the Incoming feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addIncomingPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(
        ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
        getResourceLocator(),
        getString("_UI_RelationTarget_incoming_feature"),
        getString("_UI_PropertyDescriptor_description", "_UI_RelationTarget_incoming_feature",
            "_UI_RelationTarget_type"), OrmPackage.Literals.RELATION_TARGET__INCOMING, true, false,
        true, null, null, null));
  }

  /**
   * This adds a property descriptor for the Outgoing feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addOutgoingPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(
        ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
        getResourceLocator(),
        getString("_UI_RelationTarget_outgoing_feature"),
        getString("_UI_PropertyDescriptor_description", "_UI_RelationTarget_outgoing_feature",
            "_UI_RelationTarget_type"), OrmPackage.Literals.RELATION_TARGET__OUTGOING, true, false,
        true, null, null, null));
  }

  /**
   * This adds a property descriptor for the Boundaries feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addBoundariesPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(
        ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
        getResourceLocator(),
        getString("_UI_RelationTarget_boundaries_feature"),
        getString("_UI_PropertyDescriptor_description", "_UI_RelationTarget_boundaries_feature",
            "_UI_RelationTarget_type"), OrmPackage.Literals.RELATION_TARGET__BOUNDARIES, true,
        false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
  }

  /**
   * This adds a property descriptor for the Tr extends feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addTr_extendsPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(
        ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
        getResourceLocator(),
        getString("_UI_RoleType_tr_extends_feature"),
        getString("_UI_PropertyDescriptor_description", "_UI_RoleType_tr_extends_feature",
            "_UI_RoleType_type"), OrmPackage.Literals.ROLE_TYPE__TR_EXTENDS, true, false, true,
        null, null, null));
  }

  /**
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
   * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
    if (childrenFeatures == null) {
      super.getChildrenFeatures(object);
      childrenFeatures.add(OrmPackage.Literals.TYPE__ATTRIBUTES);
      childrenFeatures.add(OrmPackage.Literals.TYPE__OPERATIONS);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child) {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns RoleType.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/RoleType"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    String label = ((RoleType) object).getName();
    return label == null || label.length() == 0 ? getString("_UI_RoleType_type")
        : getString("_UI_RoleType_type") + " " + label;
  }


  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification) {
    updateChildren(notification);

    switch (notification.getFeatureID(RoleType.class)) {
      case OrmPackage.ROLE_TYPE__NAME:
      case OrmPackage.ROLE_TYPE__BOUNDARIES:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false,
            true));
        return;
      case OrmPackage.ROLE_TYPE__ATTRIBUTES:
      case OrmPackage.ROLE_TYPE__OPERATIONS:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true,
            false));
        return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
   * that can be created under this object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
    super.collectNewChildDescriptors(newChildDescriptors, object);

    newChildDescriptors.add(createChildParameter(OrmPackage.Literals.TYPE__ATTRIBUTES,
        OrmFactory.eINSTANCE.createAttribute()));

    newChildDescriptors.add(createChildParameter(OrmPackage.Literals.TYPE__OPERATIONS,
        OrmFactory.eINSTANCE.createOperation()));
  }

}
