package es.carlos.tfg.Objetos;

public class Reto {
    private int id;
    private String pregunta;
    private String preguntaA;
    private String preguntaB;
    private String preguntaC;
    private String preguntaOK;
    private int nivel;
    private String tipo;

    public Reto(int id, String pregunta, String preguntaA, String preguntaB, String preguntaC, String preguntaOK, int nivel, String tipo) {
        this.id = id;
        this.pregunta = pregunta;
        this.preguntaA = preguntaA;
        this.preguntaB = preguntaB;
        this.preguntaC = preguntaC;
        this.preguntaOK = preguntaOK;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPreguntaOK() {
        return preguntaOK;
    }

    public void setPreguntaOK(String preguntaOK) {
        this.preguntaOK = preguntaOK;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "id: " + id + " Respuesta Correcta: " + preguntaOK;
    }
}
