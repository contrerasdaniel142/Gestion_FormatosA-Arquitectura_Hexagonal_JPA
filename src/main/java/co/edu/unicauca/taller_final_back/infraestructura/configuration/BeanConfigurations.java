package co.edu.unicauca.taller_final_back.infraestructura.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.taller_final_back.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.taller_final_back.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.taller_final_back.aplicacion.output.GestionarEstadoGatewayIntPort;
import co.edu.unicauca.taller_final_back.aplicacion.output.GestionarFormatoAGatewayIntPort;
import co.edu.unicauca.taller_final_back.aplicacion.output.GestionarObservacionGatewayIntPort;
import co.edu.unicauca.taller_final_back.dominio.usecases.GestionarDocenteCUAdapter;
import co.edu.unicauca.taller_final_back.dominio.usecases.GestionarEstadoCUAdapter;
import co.edu.unicauca.taller_final_back.dominio.usecases.GestionarFormatoACUAdapter;
import co.edu.unicauca.taller_final_back.dominio.usecases.GestionarObservacionCUAdapter;

@Configuration
public class BeanConfigurations {

    @Bean
    public GestionarDocenteCUAdapter crearGestionarDocenteCUInt(GestionarDocenteGatewayIntPort objGestionarDocenteGateway, FormateadorResultadosIntPort objFormateadorResultados){
        GestionarDocenteCUAdapter objGestionarDocenteCU = new GestionarDocenteCUAdapter(objGestionarDocenteGateway, objFormateadorResultados);
        return objGestionarDocenteCU;
    }

    @Bean
    public GestionarFormatoACUAdapter crearGestionarFormatoACUInt(GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway, GestionarDocenteGatewayIntPort objGestionarDocenteGateway, FormateadorResultadosIntPort objFormateadorResultados){
        GestionarFormatoACUAdapter objGestionarFormatoACU = new GestionarFormatoACUAdapter(objGestionarFormatoAGateway, objGestionarDocenteGateway, objFormateadorResultados);
        return objGestionarFormatoACU;
    }

    @Bean
    public GestionarObservacionCUAdapter crearGestionarObservacionCUInt(GestionarObservacionGatewayIntPort objGestionarObservacionGateway, GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway, GestionarDocenteGatewayIntPort objGestionarDocenteGateway, GestionarEstadoGatewayIntPort objGestionarEstadoGatewayInt, FormateadorResultadosIntPort objFormateadorResultados){
        GestionarObservacionCUAdapter objGestionarObservacionCU = new GestionarObservacionCUAdapter(objGestionarObservacionGateway, objGestionarFormatoAGateway, objGestionarDocenteGateway, objGestionarEstadoGatewayInt, objFormateadorResultados);
        return objGestionarObservacionCU;
    }

    @Bean
    public GestionarEstadoCUAdapter crearGestionarEstadoCUInt(GestionarFormatoAGatewayIntPort objGestionarFormatoAGateway, GestionarEstadoGatewayIntPort objGestionarEstadoGatewayInt, FormateadorResultadosIntPort objFormateadorResultados){
        GestionarEstadoCUAdapter objGestionarEstadoCU = new GestionarEstadoCUAdapter(objGestionarFormatoAGateway, objGestionarEstadoGatewayInt, objFormateadorResultados);
        return objGestionarEstadoCU;
    }
}
