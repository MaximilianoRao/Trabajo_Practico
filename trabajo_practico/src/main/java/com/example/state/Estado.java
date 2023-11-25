package com.example.state;

import com.example.context.Incidente;





public interface Estado {
    
    public void apertura(Incidente t);

    public void asignar(Incidente t);

    public void resolver(Incidente t);

    public String getEstadoAsString();

}
