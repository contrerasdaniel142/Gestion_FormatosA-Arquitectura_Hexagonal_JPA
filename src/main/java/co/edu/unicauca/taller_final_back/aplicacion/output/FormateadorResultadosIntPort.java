package co.edu.unicauca.taller_final_back.aplicacion.output;

public interface FormateadorResultadosIntPort {
    public void retornarRespuestaErrorEntidadYaExiste(String mensaje);
    public void retornarRespuestaErrorEntidadNoExiste(String mensaje);
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje);
}
