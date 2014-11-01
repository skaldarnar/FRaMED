/**
 */
package org.framed.orm.model.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import org.framed.orm.model.OrmPackage;

/**
 * This is the item provider adapter for a {@link org.framed.orm.model.RoleConstraint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RoleConstraintItemProvider extends ConstraintItemProvider {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoleConstraintItemProvider(AdapterFactory adapterFactory) {
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

      addEndsPropertyDescriptor(object);
      addSecondPropertyDescriptor(object);
      addFirstPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Ends feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addEndsPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(
        ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
        getResourceLocator(),
        getString("_UI_RoleConstraint_ends_feature"),
        getString("_UI_PropertyDescriptor_description", "_UI_RoleConstraint_ends_feature",
            "_UI_RoleConstraint_type"), OrmPackage.Literals.ROLE_CONSTRAINT__ENDS, true, false,
        true, null, null, null));
  }

  /**
   * This adds a property descriptor for the Second feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addSecondPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(
        ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
        getResourceLocator(),
        getString("_UI_RoleConstraint_second_feature"),
        getString("_UI_PropertyDescriptor_description", "_UI_RoleConstraint_second_feature",
            "_UI_RoleConstraint_type"), OrmPackage.Literals.ROLE_CONSTRAINT__SECOND, true, false,
        true, null, null, null));
  }

  /**
   * This adds a property descriptor for the First feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addFirstPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(
        ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
        getResourceLocator(),
        getString("_UI_RoleConstraint_first_feature"),
        getString("_UI_PropertyDescriptor_description", "_UI_RoleConstraint_first_feature",
            "_UI_RoleConstraint_type"), OrmPackage.Literals.ROLE_CONSTRAINT__FIRST, true, false,
        true, null, null, null));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    return getString("_UI_RoleConstraint_type");
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
  }

}
