package es.carlos.tfg.Objetos;

public class Pregunta {
    private String pregunta;
    private String preguntaA;
    private String preguntaB;
    private String preguntaC;
    private Boolean A;
    private Boolean B;
    private Boolean C;

    public Pregunta(String pregunta, String preguntaA, String preguntaB, String preguntaC, Boolean a, Boolean b, Boolean c) {
        this.pregunta = pregunta;
        this.preguntaA = preguntaA;
        this.preguntaB = preguntaB;
        this.preguntaC = preguntaC;
        A = a;
        B = b;
        C = c;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getPreguntaA() {
        return preguntaA;
    }

    public void setPreguntaA(String preguntaA) {
        this.preguntaA = preguntaA;
    }

    public String getPreguntaB() {
        return preguntaB;
    }

    public void setPreguntaB(String preguntaB) {
        this.preguntaB = preguntaB;
    }

    public String getPreguntaC() {
        return preguntaC;
    }

    public void setPreguntaC(String preguntaC) {
        this.preguntaC = preguntaC;
    }

    public Boolean getA() {
        return A;
    }

    public void setA(Boolean a) {
        A = a;
    }

    public Boolean getB() {
        return B;
    }

    public void setB(Boolean b) {
        B = b;
    }

    public Boolean getC() {
        return C;
    }

    public void setC(Boolean c) {
        C = c;
    }
}
