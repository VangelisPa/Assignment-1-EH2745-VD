package Assignment1;

public class BaseVoltage {
	private String rdfID;
	private double nominalValue;
	//	
	    public Element extractNode (Node node){
			Element element = (Element) node;
			this.rdfID = element.getAttribute("rdf:ID");
			this.nominalValue = Double.parseDouble(element.getElementsByTagName("cim:BaseVoltage.nominalVoltage").item(0).getTextContent());	
			return element;
		}
	 // 
		public String getrdfID() {
			return rdfID;
		}
		
		public double getNomValue() {
			return nominalValue;
		}
}
