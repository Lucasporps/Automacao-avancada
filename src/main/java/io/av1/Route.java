package io.av1;

public class Route {
    private String idCar, idDriver, idRoute;
    private SumoStringList edges;

    public Route(String idRoute, String[] edges) {
        this.idCar = null;
        this.idDriver = null;
        this.idRoute = idRoute;
        this.edges = this.StringToSumoStringList(edges);
    }

    public String getIdCar(){
        return this.idCar;
    }

    public String getIdDriver(){
        return this.idDriver;
    }

    public String getIdRoute(){
        return this.idRoute;
    }

    public SumoStringList getEdges(){
        return this.edges;
    }

    private SumoStringList StringToSumoStringList(String[] edges){
        SumoStringList edge = new SumoStringList();
		edge.clear();
		String[] aux = edges;

		for (String e : aux[1].split(" ")) {
			edge.add(e);
		}
        return edge;
    }
}
