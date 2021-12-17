package mapa02;

import java.util.Arrays;

public class Hospedagem{
    String[] numHospSimples = {"10", "20", "30"};
    String[] numHospLuxo = {"40", "50", "60"};
    double[] FHospSimples = {10, 20, 30};
    double[] FHospLuxo = {40, 50, 60};
    String[] tipo = {"Simples", "Luxo"};
    Double precoSimples = 300.00;
    Double precoLuxo = 500.00;
    int capacidadeSimples = 4;
    int capacidadeLuxo = 8;
    
    @Override
    public String toString() {
        return "Hospedagem [FHospLuxo=" + Arrays.toString(FHospLuxo) + ", FHospSimples=" + Arrays.toString(FHospSimples)
                + ", tipo=" + Arrays.toString(tipo) + "]";
    }
}