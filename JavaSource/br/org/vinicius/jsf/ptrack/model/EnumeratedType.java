package br.org.vinicius.jsf.ptrack.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class EnumeratedType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7590286912921680103L;

	/**
	 * Inner Class
	 * @author vinibdr
	 *
	 */
	public static class EnumManager   {
	    
		private HashMap<String, EnumeratedType> instancesByDesc = new HashMap<String, EnumeratedType>();
	    private HashMap<Integer, EnumeratedType> instancesByValue = new HashMap<Integer, EnumeratedType>();
	
	    public EnumManager()
	    {
	    }
	
	    public void addInstance(EnumeratedType instance)
	    {
	      instancesByDesc.put(instance.getDescription().toLowerCase(), instance);
	      instancesByValue.put(new Integer(instance.getValue()), instance);
	    }
	
	    public EnumeratedType getInstance(int value) throws IllegalArgumentException
	    {
	       EnumeratedType instance = instancesByValue.get(new Integer(value));
	       if (instance == null)
	         throw new IllegalArgumentException("Undefined value " + value + " for this type.");
	   return instance;
	}
	
	public EnumeratedType getInstance(String description)
	                                  throws IllegalArgumentException
	{
	   EnumeratedType instance = instancesByDesc.get(description.toLowerCase());
	   if (instance == null)
	     throw new IllegalArgumentException("Undefined description (" + description  + ") for this type.");
	       return instance;
	    }
	
	    public Map<Integer, EnumeratedType> getInstancesByValue()
	    {
	      return Collections.unmodifiableMap(instancesByValue);
	    }
	
	    public Map<String, EnumeratedType> getInstancesByDescription()
	    {
	      return Collections.unmodifiableMap(instancesByDesc);
	    }
	
	    public Collection<EnumeratedType> getInstances()
	    {
	      return Collections.unmodifiableCollection(instancesByDesc.values());
	    }
	  }

  private int value;
  private String description;

  protected EnumeratedType(int value, String description)
  {
    this.value = value;
    this.description = description;
  }

  public static EnumManager getEnumManager()
  {
    throw new UnsupportedOperationException("The method getEnumManager() needs to be overridden");
  }

  public int getValue()
  {
    return value;
  }

  public String getDescription()
  {
    return description;
  }

  /** Returns a string representation of the current value of this enumerated type. */
  public String toString()
  {
    return description;
  }

  /** Compares the value of two EnumeratedType objects. */
  public boolean equals(Object other)
  {
    if (this == other)
      return true;
    else if (other.getClass().equals(this.getClass()))
      return (((EnumeratedType)other).getValue() == value);
    else
      return false;
  }

  /** Compares the value of this EnumeratedType object with an integer value. */
  public boolean equals(int value)
  {
    return this.value == value;
  }

  /**
   * Returns 0 if the two values are equal, 1 if the value of this object is greater than the value of comparisonType,
   * and -1 if it is less than the value of this type.
   */
  public int compare(EnumeratedType comparisonType)
  {
    if (getValue() > comparisonType.getValue())
      return 1;
    else if (getValue() == comparisonType.getValue())
      return 0;
    else
      return -1;
  }

  public int hashCode()
  {
    return getValue();
  }
}