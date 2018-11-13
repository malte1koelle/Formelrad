package application;

/**
 * Berechnet das Formelrad
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
@SuppressWarnings("LossyEncoding")
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;


	public Calculator() {
	}

	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
	}
	
	public double getLeistung() {
		return leistung;
	}
	
	public double getSpannung() {
		return spannung;
	}

	public double getStrom() {
		return strom;
	}

	public double getWiderstand() {
		return widerstand;
	}

	public void setLeistung(double leistung) {
		this.leistung = leistung;
	}

	public void setSpannung(double spannung) {
		this.spannung = spannung;
	}

	public void setStrom(double strom) {
		this.strom = strom;
	}

	public void setWiderstand(double widerstand) {
		this.widerstand = widerstand;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + leistung + 
				", spannung=" + spannung + 
				", strom=" + strom + 
				", widerstand="	+ widerstand + "]";
	}

	public void calculate() {
		System.out.println(this.toString());
		if(leistung != 0 && spannung != 0){
			strom = iAusPundU(leistung, spannung);
			widerstand = rAusUundP(spannung, leistung);
		}
		else if(leistung != 0 && strom != 0){
			spannung = uAusPundI(leistung, strom);
			widerstand = rAusPundI(leistung, strom);
		}
		else if(leistung != 0 && widerstand != 0){
			spannung = uAusPundR(leistung, widerstand);
			strom = iAusPundR(leistung, strom);
		}
		else if(spannung != 0 && strom != 0){
			leistung = pAusUundI(spannung, strom);
			widerstand = rAusUundI(spannung, strom);
		}
		else if(spannung != 0 && widerstand != 0){
			leistung = pAusUundR(spannung, widerstand);
			strom = iAusUundR(spannung, widerstand);
		}
		else if(strom != 0 && widerstand != 0){
			leistung = pAusRundI(widerstand, strom);
			spannung = uAusRundI(widerstand, strom);
		}
		System.out.println(this.toString());
	}
	
	/* Hier die Methoden mit den Formlen hinzuf�gen
	 */

	// U berechnen
	public double uAusPundI(double p, double i) {
		return p/i ;
	}

	public double uAusRundI(double r, double i) {
		return r*i ;
	}

	public double uAusPundR(double p, double r) {
		return Math.sqrt(p*r) ;
	}

	// R berechnen
	public double rAusUundP(double u, double p){
		return (u*u)/p;
	}

	public double rAusPundI(double p, double i){
		return p/(i*i);
	}

	public double rAusUundI(double u, double i){
		return u/i;
	}

	// I berechnen
	public double iAusPundR(double p, double r){
		return Math.sqrt(p/r);
	}

	public double iAusPundU(double p, double u){
		return p/u;
	}

	public double iAusUundR(double u, double r){
		return u/r;
	}

	// P berechnen
	public double pAusUundR(double u, double r) {
		return (u * u) / r;
	}

	public double pAusUundI(double u, double i){
		return u * i;
	}

	public double pAusRundI(double r, double i){
		return r*(i*i);
	}
	
}
