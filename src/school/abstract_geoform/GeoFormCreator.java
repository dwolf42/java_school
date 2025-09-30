package school.abstract_geoform;

public abstract class GeoFormCreator {
	private String typ;
	
	public GeoFormCreator(String typ) {
		this.typ = typ;
	}

	public String getTyp() {
		return typ;
	}

	public abstract GeoForm create();
}
