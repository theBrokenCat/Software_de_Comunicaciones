package calculadora;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class OperacionesCalculadora {

	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private double ultimoResultado;
	private double memoria;

	public double implementacionSumar(double operando1, double operando2) {
		lock.writeLock().lock();
		try {
			ultimoResultado = operando1 + operando2;
			return ultimoResultado;
		} finally {
			lock.writeLock().unlock();
		}
	}

	public double implementacionRestar(double operando1, double operando2) {
		lock.writeLock().lock();
		try {
			ultimoResultado = operando1 - operando2;
			return ultimoResultado;
		} finally {
			lock.writeLock().unlock();
		}
	}

	public double implementacionMultiplicar(double operando1, double operando2) {
		lock.writeLock().lock();
		try {
			ultimoResultado = operando1 * operando2;
			return ultimoResultado;
		} finally {
			lock.writeLock().unlock();
		}
	}

	public double implementacionDividir(double operando1, double operando2) throws Exception {
		lock.writeLock().lock();
		try {
			// comprobaciones
			ultimoResultado = operando1 / operando2;
			return ultimoResultado;
		} finally {
			lock.writeLock().unlock();
		}
	}

	public double implementacionCuadrado(double operando1) {
		lock.writeLock().lock();
		try {
			ultimoResultado = operando1 * operando1;
			return ultimoResultado;
		} finally {
			lock.writeLock().unlock();
		}
	}

	public double implementacionUR() {
		lock.readLock().lock();
		try {
			return ultimoResultado;
		} finally {
			lock.readLock().unlock();
		}
	}

	public void implementacionMA() {
		lock.writeLock().lock();
		try {
			memoria = ultimoResultado;
		} finally {
			lock.writeLock().unlock();
		}
	}

	public double implementacionMO() {
		lock.readLock().lock();
		try {
			return memoria;
		} finally {
			lock.readLock().unlock();
		}
	}

	public void implementacionML() {
		lock.writeLock().lock();
		try {
			memoria = 0;
		} finally {
			lock.writeLock().unlock();
		}
	}
}
