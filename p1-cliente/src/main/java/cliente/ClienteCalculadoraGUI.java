package cliente;

import CalculadoraGUI.CalculadoraGUI;

public class ClienteCalculadoraGUI {

    public static void main(String[] args) {
        try {
            new CalculadoraGUI(new AdaptadorOperacionesCalculadoraGUI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
