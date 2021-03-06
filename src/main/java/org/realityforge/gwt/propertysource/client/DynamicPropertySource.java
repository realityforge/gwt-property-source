package org.realityforge.gwt.propertysource.client;

import com.google.gwt.core.shared.GWT;
import java.util.List;

/**
 * Each method in a subclass will be generated to return the value of returned
 * by that method during GWT compilation. This can be used to produce constant
 * return values based on e.g. property values or other information statically
 * available during GWT compilation.
 *
 * Property values can be accessed using
 * {@link #getSelectionPropertyValue(String)} and
 * {@link #getConfigurationPropertyValues(String)}. These methods can only be
 * used during GWT compilation.
 *
 * Supported return types for the methods are <code>String</code>,
 * <code>boolean</code> and <code>List&lt;String&gt;</code>.
 *
 * @see PropertySource
 */
public class DynamicPropertySource
  implements PropertySource
{
  /**
   * Helper interface used during GWT compilation to find property values.
   */
  public interface PropertyProxy
  {
    String getSelectionPropertyValue( String name );

    String getSelectionPropertyFallback( String name );

    List<String> getConfigurationPropertyValues( String name );
  }

  // Implementation gets injected here when generating the concrete class
  private PropertyProxy proxy;

  /**
   * Gets the value of the named property that has been defined in gwt.xml
   * files.
   *
   * @param name the name of the property
   * @return the property value as a string
   */
  protected final String getSelectionPropertyValue( final String name )
  {
    if ( GWT.isClient() )
    {
      throw new IllegalStateException( "Only supported during the compile phase." );
    }
    else
    {
      return proxy.getSelectionPropertyValue( name );
    }
  }

  /**
   * Gets the value of the named property that has been defined in gwt.xml
   * files.
   *
   * @param name the name of the property
   * @return the property value as a string
   */
  protected final String getSelectionPropertyFallback( final String name )
  {
    if ( GWT.isClient() )
    {
      throw new IllegalStateException( "Only supported during the compile phase." );
    }
    else
    {
      return proxy.getSelectionPropertyFallback( name );
    }
  }

  /**
   * Gets the value of the named configuration property that has been defined
   * in gwt.xml files.
   *
   * @param name the name of the property
   * @return the property values as a list of strings
   */
  protected final List<String> getConfigurationPropertyValues( final String name )
  {
    if ( GWT.isClient() )
    {
      throw new IllegalStateException( "Only supported during the compile phase." );
    }
    else
    {
      return proxy.getConfigurationPropertyValues( name );
    }
  }
}
