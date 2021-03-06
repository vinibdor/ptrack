package br.org.vinicius.jsf.ptrack.web;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.jia.ptrack.domain.ArtifactType;

public class ArtifactTypeConverter implements Converter {

	public final static String CONVERTER_ID = "jia.ArtifactType";

	public ArtifactTypeConverter() {

	}

	public Object getAsObject(FacesContext context, UIComponent component, 	String value) {

		if (value == null) {
			return null;
		}
		try {
			int artifactValue = Integer.parseInt(value);
			return ArtifactType.getEnumManager().getInstance(artifactValue);
		} catch (NumberFormatException ne) {
			Utils.log(context, "Can't convert to an ArtifactType; value ("
					+ value + ") is not an integer.");
			throw new ConverterException(
					"Can't convert to an ArtifactType; value (" + value
							+ ") is not an integer.", ne);
		} catch (IllegalArgumentException e) {
			Utils.log(context, "Can't convert ArtifactType; unknown value: "
					+ value);
			throw new ConverterException(
					"Can't convert ArtifactType; unknown value: " + value, e);
		}
	}

	public String getAsString(FacesContext context, UIComponent component, 	Object value) {

		if (value == null) {
			return null;
		}
		if (value instanceof ArtifactType) {
			ArtifactType artifact = (ArtifactType) value;
			return String.valueOf(artifact.getValue());
		} else {
			Utils.log(context, "Incorrect type (" + value.getClass()
					+ "; value = " + value
					+ "); value must be an ArtifactType instance");
			throw new ConverterException("Incorrect type (" + value.getClass()
					+ "; value = " + value
					+ "); value must be an ArtifactType instance");
		}
	}

}
