package calculadora;

/** Esta clase contiene la implementación final de cada operación disponible en la calculadora.
 * Debe contener un método público de instancia por cada método de la interfaz CalculadoraGUI.ICalculadora.
 * Para evitar confusiones, se recomienda que cada uno de los métodos citados anteponga 'implementacion' al
 * nombre del método de CalculadoraGUI.ICalculadora. Por ejemplo: si se desea crear el método que implementa
 * la suma, su nombre en esta clase será 'implementacionSumar'.
 */
public class OperacionesCalculadora {

	// aquí se le mete la memoria
	private double ultimoResultado;
	private double memoria;


	public double implementacionSumar(double operando1, double operando2) {
		ultimoResultado = operando1 + operando2;
		return ultimoResultado;
	}

	public double implementacionRestar(double operando1, double operando2) {
		ultimoResultado = operando1 - operando2;
		return ultimoResultado;
	}

	public double implementacionMultiplicar(double operando1, double operando2) {
		ultimoResultado = operando1 * operando2;
		return ultimoResultado;
	}

	public double implementacionDividir(double operando1, double operando2) throws Exception{
		//comprobamos dos casos, si los dos operandos son 0, o si solo el segundo es 0
		if (operando1 == 0 && operando2 == 0) {
			throw new Exception("No se puede dividir 0 entre 0");
		} else if (operando2 == 0) {
			throw new Exception("No se puede dividir entre 0");
		} else {
			ultimoResultado = operando1 / operando2;
			return ultimoResultado;
		}
	}

	public double implementacionCuadrado(double operando1) {
		ultimoResultado = operando1 * operando1;
		return ultimoResultado;
	}

	//ultimo resultado
	public double implementacionUR(){
		return ultimoResultado;
	}

	//memoria añadir (guardar)
	public void implementacionMA(){
		memoria = ultimoResultado;
	}

	//memoria obtener
	public double implementacionMO(){
		return memoria;
	}

	//memoria limpiar
	public void implementacionML(){
		memoria = 0;
	}

}
